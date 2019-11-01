package DesignPatterns.SimpleFectoryPattern;

public class Factory {

    public static Product factoryMethod(String arg) {
        Product product = null;
        if (arg.equals("A")) {
            product = new ConcreteProductA();
        }
        if (arg.equals("B")) {
            product = new ConcreteProductB();
        }
        return product;
    }
}
