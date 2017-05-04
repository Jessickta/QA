import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Chrome {

	static WebDriver driver;
	
	public static void main(String args[]) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\geckodriver.exe");
	
	driver = new ChromeDriver();
	driver.get("https://www.google.co.uk");;
	
	Boolean result = true;
	
	try {
		driver.findElement(By.name("q"));
	}
	catch (NoSuchElementException e) {
		System.out.println(e);
		result = false;
	}
	finally {
		driver.close();
	}
	
	if(result) {
		System.out.println("Passed");
	}
	else {
		System.out.println("Failed");
	}
	}
}