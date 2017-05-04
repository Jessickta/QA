import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\geckodriver.exe");
		
	driver = new ChromeDriver();
	driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1493804795&rver=6.7.6643.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f&lc=2057&id=292841&mkt=en-gb&cbcxt=out&fl=wld");
	
	final String userName = "jt-ashley@hotmail.co.uk";
	final String password = "rickyt89";
	
	WebElement usernameBox = driver.findElement(By.name("loginfmt"));
	WebElement saveBtn = driver.findElement(By.id("idSIButton9"));
	
	usernameBox.sendKeys(userName);
	saveBtn.click();
	
	//Wait timeout of 5 seconds unless successful
	WebDriverWait wait = new WebDriverWait(driver, 5);
	boolean testElement = false;
	
	try {
		System.out.println("Searching...");
		testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("loginHeader"), "Enter password"));
	}
	catch (Exception e) {
		e.printStackTrace();
		testElement = false;
	}
	
	if (testElement) {
		System.out.println("Passed!");
	}
	else {
		System.out.println("Failed");
	}
	
	

	WebElement passwordBox = driver.findElement(By.name("passwd"));
	WebElement signinBtn = driver.findElement(By.id("idSIButton9"));
	
	passwordBox.sendKeys(password);
	signinBtn.click();
	
	//Wait timeout of 5 seconds unless successful
	WebDriverWait wait2 = new WebDriverWait(driver, 5);
	boolean testElement2 = false;
	
	try {
		System.out.println("Searching...");
		testElement2 = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("folderHeaderLabel"), "Inbox"));
	}
	catch (Exception e) {
		e.printStackTrace();
		testElement2 = false;
	}
	
	if (testElement2) {
		System.out.println("Passed!");
	}
	else {
		System.out.println("Failed");
	}
	
		driver.close();
		System.exit(0);
	
	}
}
