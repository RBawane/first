package FirstProjectstepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor.Base;

import BaseTest.baseTest;
import Demo.mavenDemo.CartPage;
import Demo.mavenDemo.CheckeoutPage;
import Demo.mavenDemo.LoinPage;
import Demo.mavenDemo.productListingPage;

public class StepDefinition extends baseTest {

	
		
		public LoinPage loginPage;
		public productListingPage plp;
		public confirmationPage confirmationPage;
		
		@Given("I landed on Ecommerce page")
		public void I_landed_on_Ecommerce_Page() throws IOException
		{
			launchApplication();
		}
		
	    @Given ("Logged in with username (.+) and password (.+)$")
	    public void logged_in_username_and_password(String username, String password) throws IOException
	    {
	    	plp = launchApplication().loginApplication(username, password);
	    }

	    @When ("^I add produt (.+) to Cart$")
	    public void i_add_product_to_cart(String productName) throws InterruptedException
	    {
	    	List <WebElement> products = plp.getProductList();
	    	plp.addproductToCart(productName);
	    }
	    
	    @When ("^Checkout (.+) and submit the order$")
	    public void checkout_submit_order(String productName)
	    {
	    	CartPage cartPage = plp.goToCartPage();
	    	Boolean match = CartPage.VerifyProductDisplay("productName");
			Assert.assertTrue(match);
			CheckeoutPage checkoutPage = CartPage.goToCheckout();
			checkoutPage.selectCountry("India");
			confirmationPage = checkoutPage.submitOrder();
	    }
	    @Then ("{string} message is displayed on ConfirmationPage")
	    public void message_dispalyed_confirmationPage (String string)
	    {
	    	String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	    }
}
