package Test.DesignPatterns;

import DesignPatterns.FectoryMethodPattern.Factory;
import DesignPatterns.FectoryMethodPattern.Product;
import Utils.XMLUtil;

public class FMP {

    public static void main(String[] args) throws Exception {

        //工厂方法模式
        String className = XMLUtil.getArgs("class-FMP");
        Class c = Class.forName(className);
        Factory factory = (Factory) c.newInstance();
        Product product = factory.create();
        product.ppp();
    }
}
