package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.SearchPage;

public class SearchStepDefs {

	WebDriver driver = null;
	String base_Url = "https://amazon.in";
	CommonPage commonPage = null;
	SearchPage searchPage = null;

	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(base_Url);
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
	public void cleanUP(){
		driver.quit();
	}

}
