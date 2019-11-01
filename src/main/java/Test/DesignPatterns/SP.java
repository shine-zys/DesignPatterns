package Test.DesignPatterns;

import DesignPatterns.SingletonPattern.Singleton;

public class SP {

    public static class MyThread implements Runnable {

        private static int count;

        @Override
        public void run() {

            count++;
            System.out.println("MyThead run: " + count);
            Singleton singleton = Singleton.getInstance();
            singleton.sss();
        }
    }

    public static void main(String[] args) {
        /*Singleton singleton = Singleton.getInstance();
        singleton.sss();*/

        //单线程
        /*Thread thread = new Thread(new MyThread());
        thread.start();*/

        //多线程
        /*for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }*/
    }
}
