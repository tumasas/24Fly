package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFlights extends BasePage {

	// Buttons
	@FindBy(xpath = "(//div[@class = 'panel-body'])[1]//a[contains(@class, 'btn')]")
	private WebElement buttonBookFirst;

	// Loaders
	@FindBy(xpath = "//div[contains(@class, 'search-results-preloader')]")
	private WebElement loaderSearchResults;
	
	// Text
	@FindBy(xpath = "((//div[@class = 'panel-body'])[1]//span[@class = 'price-value _EUR']//span)[1]")
	private WebElement textFirstPriceEuros;
	
	@FindBy(xpath = "((//div[@class = 'panel-body'])[1]//span[@class = 'price-value _EUR']//span)[2]")
	private WebElement textFirstPriceCents;

	@FindBy(xpath = "(//div[@class = 'panel-body'])[1]//span[@class = 'price-value _EUR']//i")
	private WebElement textFirstCurrency;

	public PageFlights(WebDriver driver) {
		super(driver);
	}

	public void clickBookFirst() {

		buttonBookFirst.click();

	}

	public String getFirstPricePerPerson() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(loaderSearchResults));

		return textFirstPriceEuros.getText() + ',' + textFirstPriceCents.getText();
		
	}

	public String getFirstPriceCurrency() throws Exception {
		
		switch (textFirstCurrency.getText()) {
		case "€":
			return "EUR";
		default:
			throw new Exception("Currency is not supported");
		}
		
	}

}
