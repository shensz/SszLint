package com.shensz.android.lint.core;

import com.android.tools.lint.detector.api.Issue;
import com.shensz.android.lint.core.detector.HashMapForJDK7Detector;
import com.shensz.android.lint.core.detector.LogDetector;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SszIssueRegistryTest {

    private SszIssueRegistry mtIssueRegistry;

    /**
     * Setup for the other test methods
     */
    @Before
    public void setUp() throws Exception {
        mtIssueRegistry = new SszIssueRegistry();
    }

    /**
     * Test that the Issue Registry contains the correct number of Issues
     */
    @Test
    public void testNumberOfIssues() throws Exception {
        int size = mtIssueRegistry.getIssues().size();
        assertThat(size).isEqualTo(2);
    }

    /**
     * Test that the Issue Registry contains the correct Issues
     */
    @Test
    public void testGetIssues() throws Exception {
        List<Issue> actual = mtIssueRegistry.getIssues();
        assertThat(actual).contains(LogDetector.ISSUE);
        assertThat(actual).contains(HashMapForJDK7Detector.ISSUE);
    }

}