package DesignPatterns.FectoryMethodPattern;

public class ConcreteFactory2 extends Factory {

    @Override
    public Product create() {
        System.out.println("ConcreteFactory2 create");
        return new ConcreteProduct2();
    }
}
