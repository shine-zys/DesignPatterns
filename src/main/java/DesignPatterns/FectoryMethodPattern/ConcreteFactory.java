package DesignPatterns.FectoryMethodPattern;

public class ConcreteFactory extends Factory {

    @Override
    public Product create() {
        System.out.println("ConcreteFactory create");
        return new ConcreteProduct();
    }
}
