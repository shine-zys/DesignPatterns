package Test;

import BaseClass.StaticClass;

public class ZoeyMain {

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5; i++) {
            StaticClass staticClass = new StaticClass();
            staticClass.listDirEx("ccc", true);
        }
    }
}
