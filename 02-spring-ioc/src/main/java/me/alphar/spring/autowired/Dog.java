package me.alphar.spring.autowired;

public class Dog implements Animal {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eatFood() {
        System.out.println("吃狗粮...");
    }
}
