package Demo.mavenDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class productListingPage extends AbstractComponents {
	
	WebDriver driver;
	
public productListingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css = ".mb-3")
	List <WebElement> products;
	
	@FindBy (css = ".ng-animating")
	WebElement spinner;
	
	@FindBy (css = "#toast-container")
	WebElement toastMessage;
	
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear (productsBy);
		return products;
	}
	
	public WebElement getProductByName (String productName) {
		WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		return prod;
	}
	
	public void addproductToCart (String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
		waitForElementToDisappear(toastMessage);
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

	public OrderPage goToOrdersPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
