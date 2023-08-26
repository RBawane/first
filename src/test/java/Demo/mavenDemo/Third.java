package Demo.mavenDemo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.baseTest;

public class Third extends baseTest {
	
	
		String productName = "ZARA COAT 3";
		
		@Test (dataProvider= "getData" , groups= {"PurchaseOrder"})
		
		//public void third(String email, String password, String productName) throws IOException, InterruptedException {
		public void third(HashMap<String, String> input) throws IOException, InterruptedException {

			
			
			//ProductListingPage plp = launchApplication().loginApplication("shraddha1@test.com", "Test@123");
			//ProductListingPage plp = launchApplication().loginApplication(email, password);
			productListingPage plp = launchApplication().loginApplication(input.get("email"), input.get("password"));

			List <WebElement> products =plp.getProductList(); 
			//plp.addproductToCart(productName);
			plp.addproductToCart(input.get("productName"));

			CartPage cartpage = plp.goToCartPage();
			//Boolean match = cartpage.VerifyProductDisplay(productName);
			Boolean match = cartpage.VerifyProductDisplay("productName");
			Assert.assertTrue(match);
			CheckeoutPage checkoutPage = cartpage.goToCheckout();
			checkoutPage.selectCountry("India");
			confirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
			
		}
		
		@Test(dependsOnMethods = {"third"})
		public OrderPage OrderHistoryTest () throws InterruptedException, IOException {
			productListingPage plp = launchApplication().loginApplication("shraddha1@test.com", "Test@123");
			OrderPage ordersPage = plp.goToOrdersPage();
			ordersPage.VerifyOrderDisplay(productName);
			Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
			return ordersPage;	
		}
		
		public String getScreenshot(String testCaseName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File (System.getProperty("user.dir")+ "//reports" + testCaseName + ".png");
			FileUtils.copyFile(source,file);	
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		}
		
		@DataProvider
		public Object[][] getData () {
			
			HashMap <String, String> map= new HashMap <String, String> ();
			map.put("email", "shraddha1@test.com");
			map.put("password", "Test@123");
			map.put("productName", "ZARA COAT 3");
			
			map.put("email", "shraddha@test.com");
			map.put("password", "Test@123");
			map.put("productName", "ADIDAS ORIGINAL");
			
			return new Object [] [] { {map}, {"shraddha1@test.com", "Test@123"}, {"shraddha@test.com", "Test@123"}, {"ADIDAS ORIGINAL"}};
		}


}
