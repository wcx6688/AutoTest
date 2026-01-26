package com.course.testng.thread;

import org.testng.annotations.Test;

public class ThreadTest {

    // 该方法自身支持被多个线程调用（需配合 dataProvider） threadPoolSize = 3使用3个线程，invocationCount = 10总共执行10次
    // 此方式适合无依赖的独立操作（如压力测试），不适合有数据依赖的业务测试
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        //模拟创建商品
        System.out.println(Thread.currentThread().getName());
        // 注意：此方法必须是无状态的！
    }
}
