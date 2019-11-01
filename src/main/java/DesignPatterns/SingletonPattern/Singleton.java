package DesignPatterns.SingletonPattern;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {}   //防止外部类通过new方法创建对象

    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public void sss() {
        System.out.println("SP Singleton sss");
    }
}
