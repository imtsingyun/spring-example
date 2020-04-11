package me.alphar.spring.createbean._01_constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Cat1Test {

    @Autowired
    private Cat1 cat1;

    @Test
    public void test() {
        System.out.println(cat1);
    }
}
