package Test;

import javax.annotation.PostConstruct;

/**
 * @author zhangyaosheng <zoey@douyu.tv>
 * @desc
 * @date 2019/9/4
 * @time 17:59
 * @copyright douyu.com
 */
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
