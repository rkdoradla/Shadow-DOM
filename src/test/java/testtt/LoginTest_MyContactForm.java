package testtt;

import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;

public class LoginTest_MyContactForm {

	private static String baseURL;
	private static NLWebDriver driver;

	public static void main(String[] args) throws Exception {
		baseURL = "https://www.mycontactform.com";
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		final ChromeDriver WebDriver = new ChromeDriver(addProxyCapabilitiesIfNecessary(new DesiredCapabilities()));
		final String projectPath = "C:\\Users\\u1102238\\OneDrive - IQVIA\\Documents\\NeoLoad Projects\\Test\\Test.nlp";

		driver = NLWebDriverFactory.newNLWebDriver(WebDriver, "SeleniumTest", projectPath);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.findElement(By.id("user")).sendKeys("ramtesting");
		driver.findElement(By.id("pass")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("btnSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'New Form Wizard')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();
	}
}
