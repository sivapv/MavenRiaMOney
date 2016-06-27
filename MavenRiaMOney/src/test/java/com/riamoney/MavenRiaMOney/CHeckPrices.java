package com.riamoney.MavenRiaMOney;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class CHeckPrices {
	WebDriver dr;
	String exRate = "67.37";
	String AppRate ="0";
	@BeforeTest
	public void testsetup(){
		dr = new FirefoxDriver();
		dr.get("https://www.riamoneytransfer.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void CheckPriceMethod(){		
		
		
		dr.findElement(By.xpath("//a[contains(text(),'Check')]")).click();		
		new Select(dr.findElement(By.cssSelector("#countriesDDL"))).selectByVisibleText("India");
		AppRate =  dr.findElement(By.cssSelector("#exchangeRate")).getText();
		Assert.assertTrue(AppRate.equalsIgnoreCase(exRate), "Prices Matched");
		System.out.println("App Rate : "+AppRate );
	}
	@AfterTest
	public void TestClose(){
		//dr.quit();
	}
}
