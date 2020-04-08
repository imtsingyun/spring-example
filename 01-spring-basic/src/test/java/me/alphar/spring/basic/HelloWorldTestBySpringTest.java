package me.alphar.spring.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HelloWorldTestBySpringTest {

    @Test
    public void sayHello() {
        HelloWorld world = new HelloWorld();
        world.setUsername("Tom");
        world.sayHello();
    }

    @Autowired
    private HelloWorld world;

    /**
     * 使用 Spring-IOC 获取对象
     */
    @Test
    public void sayHelloByIoc() {
        world.sayHello();
    }

    /**
     * 模拟 Spring ioc 容器操作
     */
    @Test
    public void testIOCMock() throws Exception {
        String className = "me.alphar.spring.basic.HelloWorld";
        HelloWorld world = null;
        // 使用反射创建对象 --------------------------------
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        constructor.setAccessible(true);    // 设置构造器的可访问性
        Object obj = constructor.newInstance();
        // 使用内省机制设置对象的属性 -----------------------
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd: pds) {
            // HelloWorld 类中的所有的属性名称
            String propertyName = pd.getName();
            if ("username".equals(propertyName)) {
                // 调用username的setter方法
                pd.getWriteMethod().invoke(obj, "Lucy");
            } else if ("age".equals(propertyName)) {
                pd.getWriteMethod().invoke(obj, 18);
            }
        }
        world = (HelloWorld) obj;

        world.sayHello();
    }
}