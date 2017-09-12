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
        String file1 = "log/fake/Log.java";
        String file2 = "log/LogCase1.java";
        assertResultError(lintFiles(file1, file2), 1);
    }

    public void testCase2() throws Exception {
        String file1 = "log/fake/System.java";
        String file2 = "log/fake/PrintStream.java";
        String file3 = "log/LogCase2.java";
        assertResultError(lintFiles(file1, file2, file3), 1);
    }
}
