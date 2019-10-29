package com.last.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tech {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "E://avan//chromedriver_win32//chromedriver.exe"); // <– Change
																											// this path
		System.setProperty("webdriver.chrome.driver","E://tools//chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.setBinary("/path/to/other/chrome/binary");
		// chromeOptions.addArguments("start-maximized"); // open Browser in maximized
		// mode
		chromeOptions.addArguments("disable-infobars"); // disabling infobars
		chromeOptions.addArguments("--disable-extensions"); // disabling extensions
		chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
		chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
		// chromeOptions.addArguments("--headless");
		// chromeOptions.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * driver.get("http://www.gmail.com/"); driver.manage().window().maximize();
		 * driver.findElement(By.id("identifierId")).sendKeys("PotterHead");
		 * Thread.sleep(2000); driver.findElement(By.className("CwaK9")).click();
		 * Thread.sleep(2000);
		 */

		/*
		 * driver.get(
		 * "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
		 * ); driver.findElement(By.id("identifierId")).clear();
		 * driver.findElement(By.id("identifierId")).sendKeys("PotterHead");
		 * Thread.sleep(2000); driver.findElement(By.
		 * xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn more'])[1]/following::span[1]"
		 * )).click(); Thread.sleep(2000);
		 */
		
		driver.get("http://jenkins.avangrid.net:8080/");
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys("PotterHead");
		//driver.findElement(By.className("submit formRow")).click();
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		
		String at = driver.getTitle();
		String et = "PotterHead";// expected title
		driver.close();
		driver.quit();

		// establish test condition

		if (at.equalsIgnoreCase(et)) {
			System.out.println("Test Successfull");
		} else {
			System.out.println("Test Failed");
		}
	}
}

