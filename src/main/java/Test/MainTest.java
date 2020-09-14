package Test;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @anchor zhangyaosheng
 * @desc
 * @date 2020/3/2
 * @time 7:20 下午
 * @copyright douyu.com
 */
public class MainTest {


    public static class A {
        private String a = "";

        private int b = 1;

        public void setA(String a1) {
            a = a1;
        }

        public String getA() {
            return a;
        }

        public void setB(int b1) {
            b = b1;
        }

        public int getB() {
            return b;
        }

        public String toString() {
            return "A [a = " + a + ", b = " + b + "]";
        }
    }

    public int funcA(A a) {
        a.setA("aaa");
        a.setB(5);
        return 2;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(22);
        list.add(22);
        list.add(1);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}
