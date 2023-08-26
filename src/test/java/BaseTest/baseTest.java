package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Demo.mavenDemo.LoinPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	
	public WebDriver driver;
	// public LoinPage loinapge; add when before annotation is used 
	
	public WebDriver initializeDriver () throws IOException {
		
		Properties prop = new Properties ();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalProperties.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) 
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			// edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LoinPage launchApplication () throws IOException {
		driver = initializeDriver();
		LoinPage loginpge = new LoinPage(driver);
		loginpge.goToSite();
		return loginpge;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File (System.getProperty("user.dir")+ "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source,file);	
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	@AfterMethod
	public void close () {
		driver.close();
	}
}
