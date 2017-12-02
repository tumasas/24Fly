import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.PageFlights;
import pages.PageHome;
import pages.PagePassengerInformation;
import pages.PagePaymentMethod;
import pages.PagePaysera;

public class TestRunner {

	WebDriver driver;

	@Before
	public void before() {

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://24fly.com/");

	}

	@After
	public void after() {

		driver.close();

	}

	@Test
	public void checkPayseraAmount() throws Exception {

		PageHome pageHome = new PageHome(driver);
		PageFlights pageFlights = new PageFlights(driver);
		PagePassengerInformation pagePassengerInformation = new PagePassengerInformation(driver);
		PagePaymentMethod pagePaymentMethod = new PagePaymentMethod(driver);
		PagePaysera pagePaysera = new PagePaysera(driver);
		Properties testData = DataFileHandler.getData("Flight");

		pageHome.enterIsvykimoVieta(testData.getProperty("Departure"));
		pageHome.enterAtvykimoVieta(testData.getProperty("Arrival"));
		pageHome.clickIeskoti();

		String priceAfterSearch = pageFlights.getFirstPricePerPerson();
		String currencyAfterSearch = pageFlights.getFirstPriceCurrency();

		pageFlights.clickBookFirst();
		pagePassengerInformation.enterFirstName(testData.getProperty("FirstName"));
		pagePassengerInformation.enterLastName(testData.getProperty("LastName"));
		pagePassengerInformation.selectBirthDate();
		pagePassengerInformation.selectTitle(testData.getProperty("Title"));
		pagePassengerInformation.enterName(testData.getProperty("PassengerName"));
		pagePassengerInformation.enterEmailAddress(testData.getProperty("PassengerEmail"));
		pagePassengerInformation.enterPhoneNumber(testData.getProperty("PassengerPhone"));
		pagePassengerInformation.clickAcceptRules();
		pagePassengerInformation.clickProceedToCheckout();
		pagePaymentMethod.clickPaysera();
		pagePaymentMethod.clickPayNow();

		Assert.assertEquals("Total amount in Paysera is the same as amount in search results", priceAfterSearch,
				pagePaysera.getAmount());
		Assert.assertEquals("Currency in Paysera is the same as amount in search results", currencyAfterSearch,
				pagePaysera.getCurrency());

	}

}
