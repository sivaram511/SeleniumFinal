package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
	BufferedReader br;
	Properties p=new Properties();
	ThreadLocal<WebDriver> tl=new ThreadLocal<WebDriver>();
	public WebDriver Initialise() throws IOException {
		String proppath="C:\\Users\\swamy\\eclipse\\SeleniumDemo\\src\\main\\java\\resources\\config.properties";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\swamy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		tl.set(driver);
		br=new BufferedReader(new FileReader(proppath));
		p.load(br);
		System.out.println(p.getProperty("url"));
		tl.get().get(p.getProperty("url"));
		tl.get().manage().window().maximize();
		tl.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return tl.get();
		
		
	}

}
