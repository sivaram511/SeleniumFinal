package SeleniumTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.RedBusLogin;
import resources.Base;

public class Validation extends Base {
	public static final Logger logger=LogManager.getLogger(Validation.class.getName());
	RedBusLogin rlogin;
	WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)
	public void Before() throws InterruptedException, IOException {
		driver=Initialise();
		
		
		logger.info("driver initialized");
	}
	@AfterMethod(alwaysRun=true,enabled=true)
	public void After() {
		//driver.close();
	}
	@Test(groups= {"abc"})
	public void sel() throws InterruptedException {
		rlogin=new RedBusLogin(driver);
		rlogin.From().sendKeys("hyderabad");
		Thread.sleep(2000);
		Assert.assertTrue(true);
		rlogin.To().sendKeys("vijayawada");
		Thread.sleep(2000);
		rlogin.onWardDate().click();
		Thread.sleep(1000);
		rlogin.enterDate().click();
		Thread.sleep(1000);
		rlogin.Search().click();
		Thread.sleep(10000);
		logger.info("returning busses");
		logger.error("error");
		logger.warn("warning");
		Assert.assertFalse(true);
	
	}
	
	@Test(groups= {"abc"})
	public void sell() throws InterruptedException {
		rlogin=new RedBusLogin(driver);
		rlogin.From().sendKeys("hyderabad");
		Thread.sleep(2000);
		rlogin.To().sendKeys("vijayawada");
		Thread.sleep(2000);
		rlogin.onWardDate().click();
		Thread.sleep(1000);
		rlogin.enterDate().click();
		Thread.sleep(1000);
	}	
	
	@Test(dataProvider="sam",groups={"abc"})
	public void Samp(String a,String b,String c) {
	       System.out.println("string a is: "+a+" String b is: "+b);
		
	}
	
	
	
	@Test()
	public void samp2() {
		System.out.println("2");
		
	}
	
	@Test()
	public void samp1() {
		System.out.println("1");
	}
	
	@DataProvider(name="sam")
	public Object[][] sample() throws FileNotFoundException, IOException{
		XSSFWorkbook book=new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx"));
		XSSFSheet sheet=book.getSheetAt(0);
		Object[][] a=new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				a[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}		
		
		return a;
	
		
	}

}
