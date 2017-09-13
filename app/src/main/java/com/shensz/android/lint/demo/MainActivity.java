package com.shensz.android.lint.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLog();
        testHashMap();
        int i = 3;
    }

    private void go(int k){

    }

    private void testLog() {
        System.out.println("test");
        Log.i("test", "test");
        Log.d("hehe", "haha");
        Log.d("test", "test");
    }

    public static void testHashMap() {
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "name");
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "name");
        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1, "name");
    }
}
