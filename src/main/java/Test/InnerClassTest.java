package Test;

import javax.annotation.PostConstruct;

public class InnerClassTest {

    InnerClassTest() {
        System.out.println("构造函数");
    }

    private class Pendant {
        public int a;
        Pendant() {
            System.out.println("Pendant构造函数: "+a);
        }
    }

    @PostConstruct
    public void func() {
        System.out.println("PostConstruct");
    }

    public void aaa() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        InnerClassTest test = new InnerClassTest();
        test.aaa();
    }
}
