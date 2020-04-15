package me.alphar.spring.aop;

import me.alphar.spring.aop.demo1.ForumService;
import me.alphar.spring.aop.demo1.ForumServiceImpl;
import me.alphar.spring.aop.demo1.PerformanceHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void proxy() {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                        target.getClass().getInterfaces(),
                                                        handler);

        proxy.removeTopic(10);
        proxy.removeForum(1000);
    }
}
