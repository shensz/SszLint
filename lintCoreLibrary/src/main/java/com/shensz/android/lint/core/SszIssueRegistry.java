package com.shensz.android.lint.core;

import com.android.tools.lint.checks.BuiltinIssueRegistry;
import com.android.tools.lint.checks.ToastDetector;
import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.shensz.android.lint.core.detector.HashMapForJDK7Detector;
import com.shensz.android.lint.core.detector.LogDetector;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SszIssueRegistry extends IssueRegistry {

    static {
        // 替换一些有问题的系统的检查  变成我们的改进版
        List<Issue> systemIssues = new BuiltinIssueRegistry().getIssues();
        List<Issue> systemIssuesNew = new ArrayList<>(systemIssues.size());
        systemIssuesNew.addAll(systemIssues);
        systemIssuesNew.remove(ToastDetector.ISSUE);
        systemIssuesNew.add(com.shensz.android.lint.core.detector.ToastDetector.ISSUE);
        try {
            Field field = BuiltinIssueRegistry.class.getDeclaredField("sIssues");
            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, systemIssuesNew);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public synchronized List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE,
                HashMapForJDK7Detector.ISSUE
        );
    }
}
