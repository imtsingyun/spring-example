package me.alphar.spring.ioc;

import me.alphar.spring.beanEditor.Boss;
import me.alphar.spring.createbean._01_constructor.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class PersonTest {

    // 使用 BeanFactory 获取对象
    // beanFactory 有延迟初始化的特点，再创建Spring 容器的时候不回去立马创建对象
    // 而是等到从容器中获取对象的时候才会创建对象
    @Test
    public void testBeanFactory() {
        Resource resources = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resources);
        System.out.println("-------------------------------------------");
        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person);
    }

    // 使用 ApplicationContext 获取对象
    // ApplicationContext 在创建Spring容器的时候, 就会立马创初始化，而不会等到获取bean的时候才去创建
    @Test
    public void testApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("-------------------------------------------");
//        Person p = ctx.getBean("person", Person.class);
//        System.out.println(p);
    }

    @Test
    public void testCar() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Boss boss = ctx.getBean("boss", Boss.class);
        System.out.println(boss);
    }
}
