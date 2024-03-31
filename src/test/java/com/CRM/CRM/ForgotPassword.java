package com.CRM.CRM;

import org.testng.annotations.Test;

import base.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ForgotPassword extends SetUp{
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException{
		loadConfig();
		driver = browser(prop.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void forgot_password() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[2]/div[1]/div/a")).click();
		driver.findElement(By.id("email")).sendKeys("adhikari530@gmail.com");
	}
	
	@AfterMethod
	public void end() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
}
