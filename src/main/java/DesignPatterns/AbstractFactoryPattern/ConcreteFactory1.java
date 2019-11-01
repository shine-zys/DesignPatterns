package DesignPatterns.AbstractFactoryPattern;

public class ConcreteFactory1 implements Factory {

    @Override
    public ProductA createProductA() {
        System.out.println("AFP ConcreteFactory1 createProductA");
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        System.out.println("AFP ConcreteFactory1 createProductB");
        return new ConcreteProductB1();
    }

    @Override
    public ProductC createProductC() {
        System.out.println("AFP ConcreteFactory1 createProductC");
        return new ConcreteProductC1();
    }
}
