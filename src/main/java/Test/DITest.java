package Test;

public class DITest {

    public class A {

        public void read() {
            System.out.println("read A");
        }
    }

    public class B extends A {

        public void read() {
            System.out.println("read B");
        }
    }

    public class C extends A {

        public void read() {
            System.out.println("read C");
        }
    }

    public void addObj(String className) {
        if(className.equals("B")) {
            new B().read();
        }
        if(className.equals("C")) {
            new C().read();
        }
    }

    public static void main(String[] args) {
        String className = "C";
        DITest dit = new DITest();
        dit.addObj(className);
    }
}
