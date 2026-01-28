package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    public void onStart(ITestContext iTestContext) {
        // 创建报告目录
        String reportPath = "test-output/";
        File reportDir = new File(reportPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // 使用 ExtentSparkReporter（5.x 版本）
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath + "index.html");
        spark.config().setDocumentTitle("自动化测试报告");
        spark.config().setReportName("TestNG + ExtentReports 5.x");
        spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void onTestStart(ITestResult iTestResult) {
//        extent.createTest(iTestResult.getMethod().getMethodName());
        // 为每个测试方法创建一个测试节点
        ExtentTest extentTest = extent.createTest(iTestResult.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult iTestResult) {
       // extent.getTest(iTestResult.getMethod().getMethodName()).pass("✅ 测试通过");
        test.get().pass("✅ 测试通过");
    }

    public void onTestFailure(ITestResult iTestResult) {
        //extent.getTest(iTestResult.getMethod().getMethodName()).fail("❌ 测试失败: " + iTestResult.getThrowable().getMessage());
        String errorMessage = iTestResult.getThrowable() != null ?
                iTestResult.getThrowable().getMessage() : "未知错误";
        test.get().fail("❌ 测试失败: " + errorMessage);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        //extent.getTest(iTestResult.getMethod().getMethodName()).skip("⚠️ 测试跳过");
        String reason = iTestResult.getThrowable() != null ?
                iTestResult.getThrowable().getMessage() : "无具体原因";
        test.get().skip("⚠️ 测试跳过: " + reason);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }



    public void onFinish(ITestContext iTestContext) {
        if (extent != null) {
            extent.flush(); // 必须调用！否则报告不生成
        }
    }
}
