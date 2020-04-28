package me.alphar.spring.tx.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * 自己实现一个间单的 ThreadLocal
 */
public class SimpleThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        // 以线程对象为 Key，值为线程的变量副本
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if(o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }
}
