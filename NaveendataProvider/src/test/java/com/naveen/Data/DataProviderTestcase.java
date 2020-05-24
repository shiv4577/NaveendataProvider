package com.naveen.Data;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.testutil;

public class DataProviderTestcase {

	public static WebDriver driver;
@BeforeMethod
	
	public void setup() {
System.setProperty("webdriver.chrome.driver", "E:\\All Selenium Workspace\\Think-App\\ThinkAppProjectV1\\src\\test\\resources\\executables\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		
		driver.get("https://trimitiy.com/shubhavishva/");
	}


@DataProvider

public Iterator<Object[]> getData() {
	ArrayList < Object[]> testData =testutil.getdatafromexcel();
	return testData.iterator();
	
}

@Test(dataProvider="getData")

public void method2(String username,String Password) {
	
	driver.findElement(By.xpath("//*[@id=\"myHeader\"]/div/div/div/div[2]/nav/ul/li[1]/a")).click();
	driver.findElement(By.name("email")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(Password);
}


}
