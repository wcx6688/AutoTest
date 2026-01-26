package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest2 {

    @Test(dataProvider = "userData")
    public void testDataProvider(String name,int age){
        System.out.println("name="+name+"; age="+age);
    }

    @DataProvider(name="userData")
    public Object[][] providerData(){
        return new Object[][]{
                {"zhangsan",10}, {"lisi",20}, {"wangwu",30}
        };
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test111 name="+name+";age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test111 name="+name+";age="+age);
    }

    //Method method自动将方法名传过来
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",11},{"lisi",22}};

        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",33},{"zhaoliu",44}};
        }
        return result;
    }


}
