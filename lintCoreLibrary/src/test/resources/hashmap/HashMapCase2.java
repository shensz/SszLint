package com.meituan.android.lint.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK7 泛型新写法
 * 变量定义为Map<Integer, String> = new HashMap<>()
 * 变量初始化与变量声明在一起
 * case包含：
 *  局部变量
 *  成员变量
 *  静态变量
 * Created by chentong on 13/8/16.
 */
public class HashMapCase2 {
    // 1
    private Map<Integer, String> map1 = new HashMap<>();
    // 2
    private static Map<Integer, String> map2 = new HashMap<>();
    // 3
    private static final Map<Integer, String> map3 = new HashMap<>();
    public void test() {
        // 4
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
    }
}
