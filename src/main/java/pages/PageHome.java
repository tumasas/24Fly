package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHome extends BasePage {

	// Inputs
	@FindBy(id = "dep-airport")
	private WebElement inputDeparture;

	@FindBy(id = "ret-airport")
	private WebElement inputArrival;

	// Buttons
	@FindBy(id = "ifs")
	private WebElement buttonIeskoti;

	public PageHome(WebDriver driver) {
		super(driver);
	}

	public void enterIsvykimoVieta(String isvykimoVieta) {

		inputDeparture.sendKeys(isvykimoVieta);

	}

	public void enterAtvykimoVieta(String atvykimoVieta) {

		inputArrival.sendKeys(atvykimoVieta);

	}

	public void clickIeskoti() {
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ui-datepicker-div"))));
		
		buttonIeskoti.click();

	}

}
