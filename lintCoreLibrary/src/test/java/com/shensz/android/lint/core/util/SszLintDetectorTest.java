package com.shensz.android.lint.core.util;

import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.android.utils.SdkUtils;
import com.shensz.android.lint.core.SszIssueRegistry;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by chentong on 12/8/16.
 */
public abstract class SszLintDetectorTest extends LintDetectorTest{

    private static final String PATH_TEST_RESOURCES = "/src/test/resources/";

    @Override
    protected List<Issue> getIssues() {
        List<Issue> issues = new ArrayList<Issue>();
        Class<? extends Detector> detectorClass = getDetectorInstance().getClass();
        // Get the list of issues from the registry and filter out others, to make sure
        // issues are properly registered
        List<Issue> candidates = new SszIssueRegistry().getIssues();
        for (Issue issue : candidates) {
            if (issue.getImplementation().getDetectorClass() == detectorClass) {
                issues.add(issue);
            }
        }
        return issues;
    }

    @Override
    protected InputStream getTestResource(String relativePath, boolean expectExists) {
        String path = (PATH_TEST_RESOURCES + relativePath).replace('/', File.separatorChar);
        File file = new File(getTestDataRootDir(), path);
        if (file.exists()) {
            try {
                return new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                if (expectExists) {
                    fail("Could not find file " + relativePath);
                }
            }
        }
        return null;
    }

    private File getTestDataRootDir() {
        CodeSource source = getClass().getProtectionDomain().getCodeSource();
        if (source != null) {
            URL location = source.getLocation();
            try {
                File classesDir = SdkUtils.urlToFile(location);
                return classesDir.getParentFile().getAbsoluteFile().getParentFile().getParentFile();
            } catch (MalformedURLException e) {
                fail(e.getLocalizedMessage());
            }
        }
        return null;
    }

    @Override
    protected boolean allowCompilationErrors() {
        return true;
    }

    public void assertResultWarning(String actual, int warningsCount) {
        assertResult(actual, 0, warningsCount);
    }

    public void assertResultError(String actual, int errorsCount) {
        assertResult(actual, errorsCount, 0);
    }
    public void assertResultNoWarnings(String actual) {
        assertThat(actual).isEqualTo("No warnings.");
    }
    public void assertResult(String actual, int errorsCount, int warningsCount) {
        assertThat(actual).contains(errorsCount + " errors, " + warningsCount + " warnings");
    }
}
