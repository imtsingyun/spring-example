package me.alphar.spring.basic;

public class HelloWorld {

    private String username;

    private Integer age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("hello, " + username + "("+ age + ") welcome to the Spring world!");
    }
}
