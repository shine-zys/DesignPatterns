package Test.DesignPatterns;

import DesignPatterns.SimpleFectoryPattern.Factory;
import DesignPatterns.SimpleFectoryPattern.Product;
import Utils.XMLUtil;

public class SFP {

    public static void main(String[] args) {
        //简单工厂模式
        String str = XMLUtil.getArgs("arg-SFP");  //读取配置文件
        Product pro = Factory.factoryMethod(str != null ? str : "");
        if (pro != null) {
            pro.print();
            pro.ppp();
        }
    }
}
