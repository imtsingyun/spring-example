package me.alphar.spring.createbean._01_constructor;

import org.springframework.stereotype.Component;

@Component("")
public class Cat1 {

    public Cat1() {
        System.out.println("构建Cat1");
    }
}
