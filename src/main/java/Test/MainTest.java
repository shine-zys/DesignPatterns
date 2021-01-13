package Test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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



    @Data
    public static class CCC {
        private String a = "";

        private int b = 1;

        private Map<Integer, Integer> map = new HashMap<>();
    }

    public static void main(String[] args) {

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(22);
        list.add(22);
        list.add(1);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);*/
        /*CCC data = new CCC();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        data.setMap(map);
        Map<String, Object> res = BeanUtil.beanToMap(data);
        System.out.println(res);*/
        System.out.println(DateUtil.secondToTime((int) DateUtil.currentSeconds()));
    }
}
