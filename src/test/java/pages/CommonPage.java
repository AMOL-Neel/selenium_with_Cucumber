package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CommonPage {

	WebDriver driver;
	Scenario scn;

	private By search_text_Box = By.xpath("//input[@id='twotabsearchtextbox']");
	private By search_btn = By.xpath("//span[@id='nav-search-submit-text']");

	public CommonPage(WebDriver driver, Scenario s) {
		this.driver = driver;
		this.scn = s;
	}

	public void set_search_text_box(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement  element= wait.until(ExpectedConditions.elementToBeClickable(search_text_Box));
		element.sendKeys(text);

		// if we want to tak screen shot of exact webelement
//		TakesScreenshot screenShot = (TakesScreenshot) element;
//		File data1 = screenShot.getScreenshotAs(OutputType.FILE);
//		scn(data1, "image/png", "The screenshot is: " + data1);

	}

	public void clickOnSearchButton() {
		WebElement searchBtn = driver.findElement(search_btn);
		searchBtn.click();
	}

}
