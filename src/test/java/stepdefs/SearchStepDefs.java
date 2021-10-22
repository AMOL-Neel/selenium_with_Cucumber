package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.SearchPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SearchStepDefs {

	WebDriver driver = null;
	String base_Url = "https://amazon.in";
	CommonPage commonPage = null;
	SearchPage searchPage = null;
	Scenario scn;

	@Before
	public void setUp(Scenario s) {
		this.scn = s;
	}

	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(base_Url);
		scn.log("navigated to Url");
	}

	@When("I search for pdocut as {string}")
	public void i_search_for_pdocut_as(String productName) {
		commonPage = new CommonPage(driver);
		commonPage.set_search_text_box(productName);
		commonPage.clickOnSearchButton();
	}

	@Then("Product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
		searchPage = new SearchPage(driver);
		searchPage.productIsDisplayCorrectlly(productName);
		searchPage.validateProductList(productName);
	}

	@After
	public void cleanUP() {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		byte[] data = screenShot.getScreenshotAs(OutputType.BYTES);
		scn.attach(data, "image/png", "The screenshot is: " + data);
		driver.quit();
		scn.log("Browser is closed");
	}

}
