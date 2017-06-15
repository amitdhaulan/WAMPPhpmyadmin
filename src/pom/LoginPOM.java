package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPOM {
	public static WebDriver driver;
	public static WebElement element;

	public static ExtentReports extent;
	public static ExtentTest extentTest;

	String reportFile = System.getProperty("user.dir") + "\\reportFile.html";

	public LoginPOM() {
		extent = new ExtentReports(reportFile, false);
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://172.16.4.153:90/phpmyadmin/");
	}

	public void closeApp() {
		Screen screen = new Screen();
		Pattern image = new Pattern("D:\\amit\\Java_programs\\WAMPPhpmyAdmin\\lib\\images\\closeApp.PNG");
		try {
			screen.click(image);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public void setUsername(String username) {
		element = driver.findElement(By.xpath("//input[@id='input_username']"));
		element.sendKeys(username);
	}

	public void setPassword(String password) {
		element = driver.findElement(By.xpath("//input[@id='input_password']"));
		element.sendKeys(password);
	}

	public void clickGoButton() {
		element = driver.findElement(By.xpath("//input[@id='input_go']"));
		element.click();
	}
}
