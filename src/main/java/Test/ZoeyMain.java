package Test;

import BaseClass.StaticClass;

/**
 * @author zhangyaosheng <zoey@douyu.tv>
 * @desc
 * @date 2020/1/17
 * @time 17:57
 * @copyright douyu.com
 */
public class ZoeyMain {

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5; i++) {
            StaticClass staticClass = new StaticClass();
            staticClass.listDirEx("ccc", true);
        }
    }
}
