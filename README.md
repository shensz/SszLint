# 接入方式

`lintOptions`配置好后，使用

``` groovy
compile 'com.czt.mtlint:lint:latest.integration'
```

lint.xml等配置和以前lint用法相同

# 使用注意

## 不可使用1.2.x系列的gradle plugin

1.2.x gradle plugin遇到的两个问题

- [Issue 174808:custom lint in AAR doesn’t work](https://code.google.com/p/android/issues/detail?id=174808)
- [Issue 178699:lint.jar in AAR doesn’t work sometimes](https://code.google.com/p/android/issues/detail?id=178699)

## 项目中使用了retrolambda

如果项目中使用了gradle plugin 1.5 和 retrolambda，请注意配置替换原有的抽象语法树（ast），避免lint因不识别lambda表达式而报错

``` groovy
buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:<version>'
        classpath "me.tatarka:gradle-retrolambda:<version>"
        classpath 'me.tatarka.retrolambda.projectlombok:lombok.ast:0.2.3.a2'
    }

    // Exclude the version that the android plugin depends on.
    configurations.classpath.exclude group: 'com.android.tools.external.lombok'
}
```