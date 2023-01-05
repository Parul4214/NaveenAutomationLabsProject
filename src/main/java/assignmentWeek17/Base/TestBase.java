package assignmentWeek17.Base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import assignmentWeek18.Browser.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// making web driver static, once changed it remain same
	public static WebDriver driver;

	// import enum class and select browser want to use
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

	// to launch browser
	public void launchBrowser() {
		// switch case to choose the web browser
		switch (DEFAULT_BROWSER) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Invalid Web Browser");
			break;
		}
		// to manage time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// to maximize window size
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		// launch web page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	// method to quit browser
	public void quitBrowser() {

		driver.quit();
	}

}
