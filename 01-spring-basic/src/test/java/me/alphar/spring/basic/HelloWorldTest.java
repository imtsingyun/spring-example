package me.alphar.spring.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

class HelloWorldTest {

    @Test
    void sayHello() {
        HelloWorld world = new HelloWorld();
        world.setUsername("Tom");
        world.sayHello();
    }

    /**
     * 使用 Spring-IOC 获取对象
     */
    @Test
    void sayHelloByIoc() {
        HelloWorld world;
        // 根据配置文件路径创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 从Spring容器中获取bean
        BeanFactory factory = new XmlBeanFactory(resource);
        // 根据名称找bean
//        world = (HelloWorld) factory.getBean("world");
        // 按照类型找bean（如果xml中配置了多个HelloWorld的对象，则会报错）
        world = factory.getBean(HelloWorld.class);
        // 第三中方式
        world = factory.getBean("world", HelloWorld.class);

        world.sayHello();
    }

    /**
     * 模拟 Spring ioc 容器操作
     */
    @Test
    void testIOCMock() throws Exception {
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