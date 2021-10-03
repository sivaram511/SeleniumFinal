package resources;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static Logger log=LogManager.getLogger(ExtentReportNG.class);
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		log.info("system path is "+System.getProperty("user.dir"));
		reporter.config().setReportName("Sivaram AUtomation");
		reporter.config().setDocumentTitle("Test Results sivaram");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sivaram");
		return extent;
		
	}
}

