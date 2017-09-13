package com.shensz.android.lint.core;

import com.android.tools.lint.detector.api.Detector;
import com.shensz.android.lint.core.detector.LogDetector;
import com.shensz.android.lint.core.util.SszLintDetectorTest;

public class LogDetectorTest extends SszLintDetectorTest {
    @Override
    protected Detector getDetector() {
        return new LogDetector();
    }

    public void testCase1() throws Exception {
        String file = "log/LogCase1.java";
        System.out.print(lintFiles(file));
    }

    public void testCase2() throws Exception {
        String file = "log/LogCase2.java";
        System.out.print(lintFiles(file));
    }
}
