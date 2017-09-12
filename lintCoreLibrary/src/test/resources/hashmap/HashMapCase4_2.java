package com.meituan.android.lint.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK7 泛型新写法
 * 变量定义为HashMap<Integer, String>
 * 变量初始化与变量声明不在一起，且变量声明在另一个类中。 此为使用类
 * case包含：
 *  成员变量
 *  静态变量
 * Created by chentong on 13/8/16.
 */
public class HashMapCase4_2 {
    public void test() {
        // 1
        HashMapCase4_1.map2 = new HashMap<>();
        HashMapCase4_1.map2.put(1, "name");
        // 2
        HashMapCase4_1 case4_1 = new HashMapCase4_1();
        case4_1.map = new HashMap<>();
        case4_1.map.put(1, "name");
        // 3
        Sub.map2 = new HashMap<>();
        // 4
        Sub sub = new Sub();
        sub.map = new HashMap<>();
    }
    private static class Sub {
        public Map<Integer, String> map;
        public static Map<Integer, String> map2;
    }
}
