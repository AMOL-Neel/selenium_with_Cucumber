package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	
	WebDriver driver;
	
	
	private By search_text_Box = By.xpath("//input[@id='twotabsearchtextbox']");
	private By search_btn = By.xpath("//span[@id='nav-search-submit-text']");
	
	
	public CommonPage(WebDriver driver){
		this.driver= driver;
	}
	
	public void set_search_text_box(String text){
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement textBox =wait.until(ExpectedConditions.elementToBeClickable(search_text_Box));
		textBox.sendKeys(text);
	}
	
	public void clickOnSearchButton(){
		WebElement searchBtn =driver.findElement(search_btn);
		searchBtn.click();
	}
	
	
	

}
