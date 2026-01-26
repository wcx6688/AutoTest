package com.course.testng.thread;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest {
    @DataProvider(name="createItem",parallel = true) // 启用并行提供数据
    public Object[][] createProduct(){
        return new Object[][]{
                {"商品A"},{"商品B"},{"商品C"},{"商品D"},{"商品E"},{"商品F"}
        };
    }

    @Test(dataProvider = "createItem")
    public void testCreateProduct(String name){
        System.out.println("创建: " + name + " | 线程: " + Thread.currentThread().getName());
        //商品创建逻辑
    }


}
