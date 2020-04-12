package me.alphar.spring.ioc;

public class Car {

    private int maxSpeed;

    public String brand;

    private double price;

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
