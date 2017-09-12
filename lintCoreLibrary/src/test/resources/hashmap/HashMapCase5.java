package com.meituan.android.lint.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK7 泛型新写法
 * 变量定义为HashMap<Integer, String>
 * 变量初始化与变量声明不在一起，传参
 * case包含：
 *  成员变量
 *  静态变量
 * Created by chentong on 13/8/16.
 */
public class HashMapCase5 {
    public Map<Integer, String> map3;
    public static Map<Integer, String> map2;

    public void test() {
        Map<Integer, String> map1 = null;

        test1(map1);
        test2(map1);

        test1(map2);
        test2(map2);

        test1(map3);
        test2(map3);


    }
    // 仅会检查到参数这一层级  所以只有下面一个错误
    public void test1(Map<Integer, String> map) {
        //1
        map = new HashMap<>();
        map.put(1, "name");
    }
    // 这种情况经测试确实不行 似乎现实意义也不大
    public void test2(Map map) {
        map = new HashMap<>();
        map.put(1, "name");
    }
}
