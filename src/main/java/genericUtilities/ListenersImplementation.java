package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementsation to ITestListners interface
 * @author SRIROJARAM
 */
public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//for every @test-->Test method
	String methodName = result.getMethod().getMethodName();
	System.out.println(methodName+"********Test Execution Started**************");
	
	//initimate  of test execution to extent report
	test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		//for @test is passed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"********Test PASSED**************");
		
		//log the test status ao PASS
		test.log(Status.PASS, methodName+"********Test PASSED**************");	
	}

	public void onTestFailure(ITestResult result) {
		//for @test is failed
				String methodName = result.getMethod().getMethodName();
				System.out.println(methodName+"********Test FAILED**************");
				
				//print the exception for failure
				System.out.println(result.getThrowable());
				
				//LOG the test status as FAILin extent report
				test.log(Status.FAIL, methodName+"********Test Failed**************");
				test.log(Status.INFO, result.getThrowable());
				
				
				//for capturing the screenshot
				SeleniumUtility s = new SeleniumUtility();
				JavaUtility j = new JavaUtility();
				String screenshotName = methodName+"-"+j.getSystemDate()
;				try {
				String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
					
					//attach to extent report
					test.addScreenCaptureFromPath(path);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void onTestSkipped(ITestResult result) {
		//for @test is skipped
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"********Test Skipped**************");
		
		//print the exception for failure
		System.out.println(result.getThrowable());
		
		//log tge status tas SKIP in extent reports
		test.log(Status.SKIP,methodName+"********Test Skipped**************");
		test.log(Status.INFO, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {

	System.out.println("********Suite Execution started**************");
	
	//basic configuration of extent reports
	ExtentSparkReporter htmlRep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
//	ExtentSparkReporter htmlRep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
	htmlRep.config().setDocumentTitle("Execution Report");	
	htmlRep.config().setTheme(Theme.DARK);
	htmlRep.config().setReportName("VTiger Execution Report");
	
	//set system info inside extent reports
	report=new ExtentReports();
	report.attachReporter(htmlRep);
	report.setSystemInfo("base platform", "windows");
	report.setSystemInfo("base browser", "edge");
	report.setSystemInfo("base environment", "testing");
	report.setSystemInfo("reporter name", "roja");
	
}

	public void onFinish(ITestContext context) {
		System.out.println("********Suite Execution finished**************");
		
		//generate extent report
		report.flush();
		
	}
	

}
