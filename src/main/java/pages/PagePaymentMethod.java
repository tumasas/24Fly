package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePaymentMethod extends BasePage {

	// Text
	@FindBy(xpath = "//li/a[@href = '#wallet']")
	private WebElement textPaysera;

	// Buttons
	@FindBy(xpath = "//button[@data-id = 'wallet']")
	private WebElement buttonPayNow;

	public PagePaymentMethod(WebDriver driver) {
		super(driver);
	}

	public void clickPaysera() {

		WebDriverWait wait = new WebDriverWait(driver, 3);

		try {
			wait.until(ExpectedConditions.visibilityOf(textPaysera));
		} catch (NoSuchElementException e) {
			PagePassengerInformation pagePassengerInformation = new PagePassengerInformation(driver);
			pagePassengerInformation.clickThanksButNo();
		}
		
		textPaysera.click();

	}

	public void clickPayNow() {

		buttonPayNow.click();

	}

}
