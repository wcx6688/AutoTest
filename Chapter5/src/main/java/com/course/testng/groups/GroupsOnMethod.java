package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class GroupsOnMethod {

    @Test(groups = "server")
    public void server1(){
        System.out.println("这是服务端组的测试方法111");
    }
    @Test(groups="server")
    public void server2(){
        System.out.println("这是服务端组的测试方法222");
    }


    @Test(groups = "client")
    public void client1(){
        System.out.println("这是客户端组的测试方法aaa");
    }

    @Test(groups = "client")
    public void client2(){
        System.out.println("这是客户端组的测试方法bbb");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }


}
