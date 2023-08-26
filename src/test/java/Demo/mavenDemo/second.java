package Demo.mavenDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class second {

	public static void main (String [] args ) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		LoinPage loginpge = new LoinPage(driver);
		
		loginpge.goToSite(); // driver.get("https://rahulshettyacademy.com/client");
		productListingPage plp = loginpge.loginApplication("shraddha1@test.com", "Test@123");
		List <WebElement> products =plp.getProductList();
		plp.addproductToCart(productName);
		CartPage cartpage = plp.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckeoutPage checkoutPage = cartpage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
		
	}


	}

