package com.meituan.android.lint.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK7 泛型新写法
 * 变量定义为HashMap<Integer, String>
 * 变量初始化与变量声明不在一起，但在同一个类中
 * case包含：
 *  成员变量
 *  静态变量
 * Created by chentong on 13/8/16.
 */
public class HashMapCase3 {
    public Map<Integer, String> map;
    public static Map<Integer, String> map2;
    public void test() {
        // 1
        map = new HashMap<>();
        map.put(1, "name");
        // 2
        map2 = new HashMap<>();
        map2.put(1, "name");HashMapCase3.java
    }
}
