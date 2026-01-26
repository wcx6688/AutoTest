package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    //提供多组测试数据
    @DataProvider(name="createProduct")
    public Object[][] createProductData(){
        return new Object[][]{
                { "商品A", "simple", 10.0, true },   // 名称, 模式, 价格, 是否上架
                { "商品B", "professional", 25.5, false },
                { "清真套餐", "professional", 30.0, true }

        };
    }

    // 使用 dataProvider 执行多次
    @Test(dataProvider="createProduct")
    public void testCreateProduct(String name, String mode, double price, boolean isOnSale){
        System.out.println("创建商品: " + name + ", 模式: " + mode + ", 价格: " + price);
        // 调用商品创建逻辑
        // assert 结果
    }

}
