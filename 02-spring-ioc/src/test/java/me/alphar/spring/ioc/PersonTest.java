package me.alphar.spring.ioc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class PersonTest {

    // 使用 BeanFactory 获取对象
    @Test
    public void testBeanFactory() {
        Resource resources = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resources);
        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person);
    }

    // 使用 ApplicationContext 获取对象
    @Test
    public void testApplicationContext() {

    }
}
