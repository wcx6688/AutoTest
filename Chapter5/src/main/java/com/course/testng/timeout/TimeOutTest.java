package com.course.testng.timeout;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)
    public void timeoutSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void timeoutFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
