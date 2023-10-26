package com.Runners;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.Helper;

public class TTd extends Helper {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zaman\\eclipse-workspace\\RoboticBDD\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://robotsparebinindustries.com");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'Order your robot!')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		String tt = driver.findElement(By.xpath("//h2[contains(text(),'Build and order your robot!')]")).getText();
		System.out.println(tt);
		Select se = new Select(driver.findElement(By.xpath("//select[@id='head']")));
		se.selectByIndex(1);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div["+2+"]/label[1]")).click();
		Thread.sleep(1000);
		
	driver.findElement(By.xpath("//input[@type='number']")).sendKeys("2");
	driver.findElement(By.xpath("//input[@id='address']")).sendKeys("4012 12th strr");
	WebElement we = driver.findElement(By.xpath("//button[@id='preview']"));
 
	safeJavaScriptClick(we);

			
//	boolean customizedRobot = driver.findElement(By.xpath("//div[@id='robot-preview-image']")).isDisplayed();
//	Assert.assertEquals(customizedRobot, true, "Robot Not created!!");
//	System.err.println("Robot is created : "+customizedRobot);
//	driver.findElement(By.xpath("//button[@id='order']")).click();
//	String ll = driver.findElement(By.xpath("//div[@id='receipt']")).getText();
//	System.out.println(ll);
//	String yy = driver.findElement(By.xpath("//div[@id='parts']")).getText();
//	System.out.println("Parts Details: \n"+yy);
//	String hh = driver.findElement(By.xpath("//p[@class='badge badge-success']")).getText();
//	System.out.println("Order id: \n"+hh);
//	//driver.findElement(By.xpath(hh))
//	

	}
	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
}
/*
 * String head = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]";
		String middle = "/div[";
		String ends = "]/label[1]";
		List<WebElement> redioButton = driver.findElements(By.xpath(head));
		for (int i = 1; i < redioButton.size(); i++) {
			String dd = driver.findElement(By.xpath(head + middle + i + ends)).getText();

			// System.out.println(redioButton.get(i).getText());

			r
		}
 * */

//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]
//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/label[1]
//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[ 4 ]/label[1]