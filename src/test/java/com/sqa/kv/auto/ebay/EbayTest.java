package com.sqa.kv.auto.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.kv.util.helper.SelUtil;
import com.sqa.kv.util.helper.SelUtil.STRATEGY;

public class EbayTest
{
	private WebDriver driver;
	private final String BASE_URL = "http://www.ebay.com";

	@AfterClass
	public void afterClass()
	{
		this.driver.close();
	}

	@BeforeClass
	public void beforeClass()
	{
		WebDriver driver = new FirefoxDriver();
	}

	@DataProvider
	public Object[][] dp()
	{
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@Test
	public void ebayTest()
	{
		WebDriver driver = new FirefoxDriver();
		this.driver.get(this.BASE_URL + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.id("userid")).clear();
		this.driver.findElement(By.id("userid")).sendKeys("mallaprechristian@gmail.com");
		this.driver.findElement(By.id("pass")).clear();
		this.driver.findElement(By.id("pass")).sendKeys("dummy123");
		SelUtil.gotoAndClick(driver, "csi");
		SelUtil.superClick(
				driver,
				"csi:sgnBt:gh-cart-i:Fossil Dean Chronograph Black Dial Men's Brown Leather Watch FS4828:gh-eb:My eBay:a.vip.item-title:gh-eb:My eBay:Wish list:ttl_172102243053:html"
						.split(":"), new SelUtil.STRATEGY[] { STRATEGY.ID, STRATEGY.ID,
						STRATEGY.ID, STRATEGY.TEXT, STRATEGY.ID, STRATEGY.TEXT, STRATEGY.CSS,
						STRATEGY.ID, STRATEGY.TEXT, STRATEGY.TEXT, STRATEGY.ID, STRATEGY.CSS });
	}
}
