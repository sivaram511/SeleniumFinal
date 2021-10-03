package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedBusLogin {

WebDriver driver;
By from=By.xpath("//*[@id=\"src\"]");
By to=By.xpath("//*[@id=\"dest\"]");
By onwarddate=By.xpath("//*[@id=\"search\"]/div/div[3]/div/label");
By date=By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[4]/td[@class=\"current day\"]");
By search=By.xpath("//*[@id=\"search_btn\"]");
public RedBusLogin(WebDriver driver) {
	this.driver=driver;
}
public WebElement From() {
	return driver.findElement(from);
}
public WebElement To() {
	return driver.findElement(to);
}
public WebElement onWardDate() {
	return driver.findElement(onwarddate);
}
public WebElement enterDate() {
	return driver.findElement(date);
}
public WebElement Search() {
	return driver.findElement(search);
}


}
