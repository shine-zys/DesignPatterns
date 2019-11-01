package DesignPatterns.SingletonPattern;

public class LazySingleton {

    private volatile static LazySingleton instance = null;

    private LazySingleton() {}

    public static LazySingleton getInstance() {      //double check locking
         if(instance == null) {
             synchronized(LazySingleton.class) {
                 if(instance == null) {
                     instance = new LazySingleton();
                 }
             }
         }
         return instance;
    }
}
