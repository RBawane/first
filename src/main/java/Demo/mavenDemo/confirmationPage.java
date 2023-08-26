package Demo.mavenDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.abstractcomponents.AbstractComponents;


public class confirmationPage extends AbstractComponents {
	
	WebDriver driver;	
	
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	


	@FindBy (css = ".hero-primary")
	WebElement confirmMessage;

	public String getConfirmationMessage()
	{
		return confirmMessage.getText();
	}


}
