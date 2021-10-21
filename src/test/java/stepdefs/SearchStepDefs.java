package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchStepDefs {
	
	
	WebDriver driver = null;
	String base_Url = "https://amazon.in";

	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.get(base_Url);
	}

	@When("I search for pdocut as {string}")
	public void i_search_for_pdocut_as(String productName) {
		WebElement searchBox =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys(productName);
		
		WebElement searchBtn = driver.findElement(By.xpath("//span[@id='nav-search-submit-text']"));
		searchBtn.click();

	}

	@Then("Product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
		WebElement product_Name =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(@class,'a-color-state a-text-bold')]"));
		String actualProductName = product_Name.getText();
		
		if(actualProductName.contains(productName)){
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse("product not correctly displayed in the search result",false);
		}

	}

}
