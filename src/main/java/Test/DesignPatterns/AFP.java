package Test.DesignPatterns;

import DesignPatterns.AbstractFactoryPattern.Factory;
import DesignPatterns.AbstractFactoryPattern.ProductA;
import DesignPatterns.AbstractFactoryPattern.ProductB;
import DesignPatterns.AbstractFactoryPattern.ProductC;
import Utils.XMLUtil;

public class AFP {

    public static void main(String[] args) throws Exception {

        String className = XMLUtil.getArgs("class-AFP");  //切换工厂不需要更新代码
        Class c = Class.forName(className);
        Factory factory = (Factory) c.newInstance();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
        ProductC productC = factory.createProductC();
        productA.aaa();
        productB.bbb();
        productC.ccc();
    }
}
