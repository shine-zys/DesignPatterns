package BaseClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhangyaosheng <zoey@douyu.tv>
 * @desc
 * @date 2020/1/17
 * @time 17:43
 * @copyright douyu.com
 */
public class StaticClass {

    String a = print();
    private final ExecutorService delegateAsyncTransformer = Executors.newCachedThreadPool(new StaticClass.DaemonThreadFactory());

    private static String print() {
        System.out.println("static class static method print ... ");
        return "aaa";
    }

    public StaticClass() {
        System.out.println("static class ...");
    }

    private class testClass {
        testClass() {
            System.out.println("static class testClass class start ... ");
            new StaticClass.testClass.innerClass();
            System.out.println("static class testClass class end ... ");
        }

        private class innerClass {
            innerClass() {
                System.out.println("static class testClass class innerClass class ... ");
            }
        }
    }

    private static class DaemonThreadFactory implements ThreadFactory {
        private DaemonThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    }

    public void test1() {
        System.out.println("test1 start ...");
        new StaticClass();
        System.out.println("test1 end ...");
    }

    public void test2() {
        System.out.println("test2 start ...");
        new StaticClass.testClass();
        System.out.println("test2 end ...");
    }

}
