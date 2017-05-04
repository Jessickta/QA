import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {

static WebDriver driver;
	
	public static void main (String args []) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Administrator/AppData/Local/Temp/Temp1_HTML.zip/HTML/Window.html");
		
		String window1 = driver.getWindowHandle();
		System.out.println("First Handle is: "+ window1);
		
		WebElement link = driver.findElement(By.linkText("Google Search"));
		link.click();
		//Actions builder = new Actions(driver);
		
		//builder.contextClick(link).moveByOffset(10,30).perform();
		
		String window2 = driver.getWindowHandle();
		System.out.println("Second Handle is: " + window2);
		System.out.println("Handles so far: " + driver.getWindowHandles().size());
		
		driver.switchTo().defaultContent();
	
	}
}
