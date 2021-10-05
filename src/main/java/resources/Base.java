package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	BufferedReader br;
	Properties p=new Properties();
	
	public WebDriver Initialise() throws IOException {
		String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties";
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\swamy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		br=new BufferedReader(new FileReader(proppath));
		p.load(br);
		System.out.println(p.getProperty("url"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
		
		
	}

}
