import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cookies {

static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main (String args []) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\geckodriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.graze.com/uk/login");
		
		final String username = "jt-ashley@hotmail.co.uk";
		final String password = "rickyt89";
		
		WebElement userBox = driver.findElement(By.id("email"));
		WebElement passBox = driver.findElement(By.id("password"));
		WebElement remember = driver.findElement(By.id("autologin"));
		WebElement loginBtn = driver.findElement(By.id("login"));
		
		userBox.sendKeys(username);
		passBox.sendKeys(password);
		remember.click();
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean testElement = false;
		
		try {
			System.out.println("Logging in...");
			testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("home-snacks"), "hey Jessica"));
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
		
		File f = new File("browser.data");
		f.delete();
		f.createNewFile();
		
		FileWriter fwrite = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fwrite);
		
		for(Cookie ck : driver.manage().getCookies()) { 
			b.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
			b.newLine();
		}
		
		b.close();
		fwrite.close();
		
		WebElement namelink = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/ul/li[4]/a"));
		namelink.click();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/p/a"));
		logout.click();
	
	WebDriverWait waitout = new WebDriverWait(driver, 5);
	boolean testElementout = false;
	
	try {
		System.out.println("Logging out...");
		testElementout = waitout.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div/p"), "You've been successfully logged out."));
	}
	catch (Exception e) {
		e.printStackTrace();
		testElementout = false;
	}	
	if (testElementout) {
		System.out.println("Logged out!");
	}
	else {
		System.out.println("Failed Logout");
	}
	
	//driver.close();
	driver.get("https://www.google.co.uk/?gfe_rd=cr&ei=x-oKWYPmI8vO8geuq5OgBA&gws_rd=ssl");
	driver.get("https://www.graze.com/uk/");
	
	//try {
	File f2 = new File("browser.data");
	
	FileReader fread = new FileReader(f2);
	BufferedReader br = new BufferedReader(fread);
	String line;
	
	while ((line=br.readLine())!=null) {
		
		System.out.println(line);
		StringTokenizer str = new StringTokenizer(line,";");
		while(str.hasMoreTokens()) {
			String name = str.nextToken();
			String value = str.nextToken();
			String domain = str.nextToken();
			String path = str.nextToken();
			Date expiry = null;
			String dt;
			
			if (!(dt=str.nextToken()).equals("null")) {
				expiry = new Date(dt);
			}
			
			boolean isSecure = new Boolean(str.nextToken()).booleanValue();
			Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
		
			driver.manage().addCookie(ck);
		}
	}
	
	//catch (Exception ex) {
	//ex.printStackTrace();	
	
	
		//br.close();
		
		//driver.get("https://www.google.co.uk/?gfe_rd=cr&ei=x-oKWYPmI8vO8geuq5OgBA&gws_rd=ssl");
		driver.get("https://www.graze.com/uk/");
	}
}



