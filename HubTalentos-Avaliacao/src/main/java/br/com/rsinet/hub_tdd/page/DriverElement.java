package br.com.rsinet.hub_tdd.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverElement {
	static WebDriver driver;

	
	public static WebDriver getChromeDriver(){

		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(800, 600));
		return driver;
	}

	public static void quitDriver(WebDriver driver) {
		if(driver != null)
			driver.quit();
	}
}
