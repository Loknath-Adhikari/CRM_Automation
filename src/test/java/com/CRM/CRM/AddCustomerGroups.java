package com.CRM.CRM;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.*;

public class AddCustomerGroups extends SetUp{

	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		loadConfig();
		driver = browser(prop.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void valid_data() throws InterruptedException{
		//login into CRM website
		driver.findElement(By.id("email")).sendKeys("admin@dev.com");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[3]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div[2]/div[2]/form/div[4]/button")).click();
		Thread.sleep(3000);
		//After entering into website
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[3]/section/div[1]/div/a")).click();
		Thread.sleep(3000);
		//Form open
		WebElement customerName = driver.findElement(By.id("name"));
		customerName.click();
		customerName.sendKeys("Anil Adhikari");
		//Making all text bold
		driver.findElement(By.xpath("//*[@id=\"addNewForm\"]/div/div[2]/div[2]/div/div[2]/div[1]/button[1]")).click();
		WebElement description = driver.findElement(By.xpath("//*[@id=\"addNewForm\"]/div/div[2]/div[2]/div/div[3]/div[3]/p"));
		description.click();
		description.sendKeys("Automated Description");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
	}
	
	@AfterMethod
	public void endTest() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
}
