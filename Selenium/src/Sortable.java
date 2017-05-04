import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sortable {
	
	static WebDriver driver;

	public static void main (String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/AppData/Local/Temp/Temp1_HTML.zip/HTML/Sortable.html");
		
		Actions builder = new Actions(driver);
		
		builder.moveByOffset(200,20).clickAndHold().moveByOffset(120,0).release().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean movewait = true;
		
		try {
			System.out.println("Moving...");
			movewait = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"sortable\"]/li[3]"), "3"));
		}
		catch (Exception e) {
			e.printStackTrace();
			movewait = false;
			
		}
		
		if (movewait) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed!");
		}
		
		driver.close();
		System.exit(0);
	}
	
}
