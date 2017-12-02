package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePaysera extends BasePage {

	@FindBy(xpath = "//span[@class = 'bigblue']")
	private WebElement textAmount;

	public PagePaysera(WebDriver driver) {
		super(driver);
	}

	public String getAmount() {

		return getAmountAndCurrency()[0];

	}

	public String getCurrency() {

		return getAmountAndCurrency()[1];

	}
	
	private String[] getAmountAndCurrency() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(textAmount));

		String[] amountAndCurrency = new String[2];
		amountAndCurrency = textAmount.getText().split(" ");

		return amountAndCurrency;
		
	}

}
