package com.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.Base.Helper;
import com.Utils.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoboticStepDef extends Helper {
	// public WebDriver driver;
	static Helper helper = new Helper();
	static Utilities utils = new Utilities();

	/*
	 * Scenatio01: login with Valid credentias
	 */
	// @Given("User already on login page")
	public void user_already_on_login_page() {
		initialization();

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zaman\\eclipse-workspace\\RoboticBDD\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://robotsparebinindustries.com");
//		driver.manage().window().maximize();
//		driver.navigate().refresh();
	}

	@When("User already on login page with Valid credentias")
	public void user_already_on_login_page_with_valid_credentias() {
		user_already_on_login_page();
		String title = driver.getTitle();
		System.out.println("Page Title is : " + title);
		String text = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.println("Login page Text : " + text);

	}

	@Then("Enter Valid {string} and {string} in appropriate field")
	public void enter_valid_and_in_appropriate_field(String userName, String pass) {
		user_already_on_login_page();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pass);

	}

	@Then("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}

	@Then("Validate Display User name on the home page")
	public void validate_display_user_name_on_the_home_page() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String names = driver.findElement(By.xpath("//span[contains(text(),'maria')]")).getText();
		System.out.println("Display name found as : [ " + names + " ]");
	}

	/*
	 * Scenario 002: Validat Actual Sales functionalities againest of targeted salse
	 */

	@Given("I enter Sales person data with {string} and {string} and Actual Sales amount as {string}")
	public void i_enter_sales_person_data_with_and_and_actual_sales_amount_as(String fn, String ln, String amt) {

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fn);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(ln);
		driver.findElement(By.xpath("//input[@id='salesresult']")).sendKeys(amt);

	}

	@When("I click on Submit button")
	public void i_click_on_submit_button() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	}

	@Then("I am able to see the details appeares")
	public void i_am_able_to_see_the_details_appeares() {
		String details = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.print("Salse Details: " + details.toString());
	}

	/*
	 * Scenario: Validate targeted sales
	 */

	@Given("Targated salse validation")
	public void targated_salse_validation() {
		System.out.println("Tergated salse ");
		WebElement divs = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[2]"));
		System.out.println("Todays sales : " + divs.getText());

	}

	@When("I click on show performance")
	public static void i_click_on_show_performance() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.xpath("//button[contains(text(),'Show performance')]"));
		utils.safeJavaScriptClick(we);
//		if (we.isDisplayed() == true) {
//			System.out.println("Displayed... ");
//			we.click();
//		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("I must see {string} particuler Message for me based on my salse")
	public void i_must_see_particuler_message_for_me_based_on_my_salse(String msg) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Locate Table
		WebElement mainTable = driver.findElement(By.xpath("//*[@id='sales-results']/table"));

		// Locate Rows of the table
		List<WebElement> totalRow = mainTable.findElements(By.tagName("tr"));

		// new work
		for (WebElement rr : totalRow) {
			System.out.println(rr.getText());
			break;
		}
		for (int i = 0; i < totalRow.size(); i++) {
			System.out.println("Index : " + totalRow.get(2).getText());
			break;
		}
		String we = driver.findElement(By.xpath("//tbody/tr[2]/td[1]/span")).getText();
		System.out.print("Boss Message for salse performance:- ");
		System.err.print(we + "\n");

		// Until here

		/*
		 * //Total Number of Row int rowCount=totalRow.size();
		 * 
		 * //Loop will execute till last row of the table for(int row=0; row<rowCount;
		 * row++) {
		 * 
		 * //Find the column of the specific row List<WebElement> column_row =
		 * totalRow.get(row).findElements(By.tagName("td"));
		 * 
		 * //Find number of column in the specific row int colCount = column_row.size();
		 * System.out.println("Total number of Column in Row"+row+" are "+colCount);
		 * 
		 * //Loop will execute till last row of the table for(int col=0; col<colCount;
		 * col++) {
		 * 
		 * //To Retrieve specific Column value String colText =
		 * column_row.get(col).getText();
		 * System.out.println("Column Value of Row Number "+row+" and Column Number "
		 * +colCount+" is "+colText);
		 * 
		 * } System.out.println(
		 * "-------------------------------------------------------------------");
		 * 
		 * }
		 */
//		System.err.println(mainTable.getText()+"	");

//		Integer in = Integer.parseInt(we);
//		if (in <= 2001) {
//			System.out.println("Message from the Boss as : " + msg);
//		} else {
//			System.out.println("Message from the Boss as : " + msg);
//		}
		WebElement deletEntries = driver.findElement(By.xpath("//button[contains(text(),'Delete all sales entries')]"));
		//deletEntries.click();

	}
	// --

	@Given("I am completed my validation and I will close the current browser")
	public void i_am_completed_my_validation_and_i_will_close_the_current_browser() {
		driver.manage().deleteAllCookies();
		driver.close();

	}

}
