package Demo.mavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class LoinPage extends AbstractComponents {
	
	WebDriver driver;

public LoinPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//WebElement userElement= driver.findElement(By.id("userEmail"));
	
	//Page factory
	@FindBy(id= "userEmail") // WebElement userEmail = driver.findElement(By.id("userEmail"));
	WebElement userEmail;
	
	@FindBy(id= "userPassword")
	WebElement userPassword;
	
	@FindBy(id= "login")
	WebElement submit;
	
	public productListingPage loginApplication (String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		productListingPage plp = new productListingPage(driver);
		return plp;
	}
	
	public void goToSite () {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
