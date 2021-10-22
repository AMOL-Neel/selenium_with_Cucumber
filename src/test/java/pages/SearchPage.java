package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class SearchPage {
	WebDriver driver;

	private By appearProduct = By.xpath(
			"//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(@class,'a-color-state a-text-bold')]");
	
	private By productList = By.xpath("//div[@data-asin='B09F3QDFQQ']//following::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[contains(text(),'Dell')]");
	

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void productIsDisplayCorrectlly(String text) {
		WebElement productName = driver.findElement(appearProduct);
		String actualProductName = productName.getText();

		if (actualProductName.contains(text)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse("product not correctly displayed in the search result", false);
		}
	}
	
	public void validateProductList(String text){
		List<WebElement> listProducts = driver.findElements(productList);
		
		for(int i=0;i<listProducts.size();i++){
			if(listProducts.get(i).getText().toLowerCase().contains(text.toLowerCase())){
				Assert.assertTrue(true);
			}else{
				Assert.fail("Product not correctly displayed in the search result. product at index ::"+(i+1));
			}
			
		}
	}

}
