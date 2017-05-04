import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dragme {

	static WebDriver driver;
	
	public static void main (String args []) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/AppData/Local/Temp/Temp1_HTML.zip/HTML/DragMe.html");
		
		WebElement Box = driver.findElement(By.id("draggable"));
		
		
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(Box).moveByOffset(200, 300).release().perform();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean dragwait = true;
		
		try {
			System.out.println("Dragging...");
			dragwait = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"draggable\"]"), "Drag me around"));
		}
		catch (Exception e) {
			e.printStackTrace();
			dragwait=false;
		}
		
		if (dragwait) {
			System.out.println("Passed!");
		}
		else {
			System.out.println("Failed");
		}
		
	}
}
