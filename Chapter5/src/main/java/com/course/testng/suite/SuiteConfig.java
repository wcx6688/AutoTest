package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    //@BeforeSuite和@AfterSuite标记的方法在整个测试套件中只执行1次
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite运行啦");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest在每个<test>开始前执行");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest在每个<test>结束后执行");
    }

}
