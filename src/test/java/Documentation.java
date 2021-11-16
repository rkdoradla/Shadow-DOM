import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
public class Documentation {
	private static final String CHROME_DRIVER_PATH = ".\\drivers\\chromedriver.exe";
		
	static {
		final File file = new File(CHROME_DRIVER_PATH);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		// Replace <apiKey> with an API Key defined in Controller General Settings REST API or Project Settings if authentication is required.
		System.setProperty("nl.api.key", "<apiKey>");
	}
		
	@Rule
	public TestName testName = new TestName();
		
	NLWebDriver driver;
	
	@Before
	public void beforeTest() {
		final ChromeDriver webDriver = new ChromeDriver(addProxyCapabilitiesIfNecessary(new DesiredCapabilities()));
		final String projectPath = "C:\\Users\\u1102238\\OneDrive - IQVIA\\Documents\\NeoLoad Projects\\Test\\Test.nlp";
		driver = NLWebDriverFactory.newNLWebDriver(webDriver, testName.getMethodName(), projectPath);
	}
	
	@Test
	public void testSubmit() {
		driver.startTransaction("home");
		driver.get("http://ushahidi.demo.neotys.com/");
		driver.stopTransaction();
		driver.startTransaction("reports");
	driver.findElement(By.id("mainmenu")).findElements(By.tagName("a")).get(1).click();
		driver.stopTransaction();
		driver.startTransaction("submit");
		driver.findElement(By.partialLinkText("SUBMIT")).click();
		driver.stopTransaction();
	}
	
	//@Test
	public void testGetAlerts() {
		driver.startTransaction("home");
		driver.get("http://ushahidi.demo.neotys.com/");
		driver.stopTransaction();
		driver.startTransaction("alerts");
		driver.findElement(By.partialLinkText("GET ALERTS")).click();
		driver.stopTransaction();
	}
	
	//@Test
	public void testSubmitIncident(){
		driver.startTransaction("home");
		driver.get("http://ushahidi.demo.neotys.com/");
		driver.stopTransaction();
		
		driver.startTransaction("submit-incident");
		driver.findElement(By.className("submit-incident")).click();
		driver.findElement(By.id("incident_title")).sendKeys("Title");
		driver.findElement(By.id("incident_description")).sendKeys("Description");
		driver.findElement(By.id("location_name")).sendKeys("Gémenos, France");
		driver.findElement(By.cssSelector("input[type='checkbox'][value='2']")).click();
		driver.findElement(By.className("btn_submit")).click();
		driver.stopTransaction();
	}
	
	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}
