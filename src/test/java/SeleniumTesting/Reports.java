package SeleniumTesting;

import resources.Base;
import resources.ExtentReportNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Reports extends Base implements ITestListener {
	ExtentTest et;
	ExtentReports er=ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();
	WebDriver driver;
	ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		et=er.createTest(result.getMethod().getMethodName());
		tl.set(et);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			dr.set(driver);
			tl.get().log(Status.PASS,"Test Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.get().close();
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		tl.get().fail(result.getThrowable());
		try {
		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		dr.set(driver);
		} catch(Exception e) {
			e.printStackTrace();
		}
		TakesScreenshot ts=(TakesScreenshot)dr.get();
		File source =ts.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ld=LocalDateTime.now();
		String formt=dt.format(ld);
		String destinationFile = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getMethod().getMethodName()+"-"+formt+".png";
		try {
			FileUtils.copyFile(source,new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tl.get().addScreenCaptureFromPath(destinationFile,result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.get().close();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
		
	}
	

}
