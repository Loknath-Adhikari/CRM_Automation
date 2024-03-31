package com.CRM.CRM;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.*;

public class Login extends SetUp{

	WebDriver driver;
	String login_button = "//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[4]/button";
	
	@BeforeMethod
	public void setup() throws IOException {
		loadConfig();
		driver = browser(prop.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void invalid_data() {
		driver.findElement(By.id("email")).sendKeys(utils.Email_Generator.email_generator());
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.xpath(login_button)).click();
		String message = driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[1]")).getText();
		AssertJUnit.assertTrue(message.contains("These credentials do not match our records."));
	}
	
	@Test(priority = 2)
	public void valid_data() {
		driver.findElement(By.id("email")).sendKeys("admin@dev.com");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[3]/div/label")).click();
		driver.findElement(By.xpath(login_button)).click();
		AssertJUnit.assertTrue(driver.getTitle().contains("Dashboard | CRM"));
	}
	
	@AfterMethod
	public void endTest() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
}
