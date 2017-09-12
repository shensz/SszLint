package com.meituan.android.lint.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK7 泛型新写法
 * 变量定义为HashMap<Integer, String>
 * 变量初始化与变量声明不在一起，且变量声明在另一个类中。 此为声明类
 * case包含：
 *  成员变量
 *  静态变量
 * Created by chentong on 13/8/16.
 */
public class HashMapCase4_1 {
    public Map<Integer, String> map;
    public static Map<Integer, String> map2;
}
