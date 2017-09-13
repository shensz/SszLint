package com.shensz.android.lint.core;

import com.android.tools.lint.detector.api.Detector;
import com.shensz.android.lint.core.detector.HashMapForJDK7Detector;
import com.shensz.android.lint.core.util.SszLintDetectorTest;

public class HashMapForJDK7DetectorTest extends SszLintDetectorTest {
    @Override
    protected Detector getDetector() {
        return new HashMapForJDK7Detector();
    }

    public void testCase1() throws Exception {
        String file = "hashmap/HashMapCase1.java";
        System.out.println(lintFiles(file));
    }

    public void testCase2() throws Exception {
        String file = "hashmap/HashMapCase2.java";
        System.out.println(lintFiles(file));
    }

    public void testCase3() throws Exception {
        String file = "hashmap/HashMapCase3.java";
        System.out.println(lintFiles(file));
    }

    public void testCase4() throws Exception {
        String file4_1 = "hashmap/HashMapCase4_1.java";
        String file4_2 = "hashmap/HashMapCase4_2.java";
        System.out.println(lintFiles(file4_1, file4_2));
    }

    public void testCase5() throws Exception {
        String file = "hashmap/HashMapCase5.java";
        System.out.println(lintFiles(file));
    }
}
