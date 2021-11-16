package testtt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NuxeoDemoUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://3.129.73.164:8080/nuxeo/login.jsp?requestedUrl=ui%2F");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rama");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//input[@class='login_button']")).click();
		Thread.sleep(6000);

		String workSpaceFolderPath = "http://3.129.73.164:8080/nuxeo/ui/#!/browse/default-domain/workspaces/Ram%20Automation/Demo%20Test";
		driver.get(workSpaceFolderPath);
		Thread.sleep(6000);
		WebElement editBtn = (WebElement)((JavascriptExecutor) driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#browser').shadowRoot.querySelector('nuxeo-page > div:nth-child(1) > div > nuxeo-actions-menu > nuxeo-document-edit-button').shadowRoot.querySelector('nuxeo-document-form-button').shadowRoot.querySelector('#edit-button').shadowRoot.querySelector('#icon')");
		editBtn.click();
		Thread.sleep(3000);
		WebElement closeBtn = (WebElement)((JavascriptExecutor) driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#browser').shadowRoot.querySelector('nuxeo-page > div:nth-child(1) > div > nuxeo-actions-menu > nuxeo-document-edit-button').shadowRoot.querySelector('nuxeo-document-form-button').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#form > form > div.actions > paper-button.secondary')");
		closeBtn.click();
		Thread.sleep(6000);
		WebElement uploadLink = (WebElement)((JavascriptExecutor) driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#browser').shadowRoot.querySelector('#nxContent > iron-pages > nuxeo-document-page').shadowRoot.querySelector('div > div.side > div.scroller > div:nth-child(2) > nuxeo-document-metadata').shadowRoot.querySelector('nuxeo-document-layout').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#container > nuxeo-file-metadata-layout').shadowRoot.querySelector('nuxeo-document-attachments').shadowRoot.querySelector('nuxeo-dropzone').shadowRoot.querySelector('#container > a')");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", uploadLink);
		uploadFile();

//		WebElement CancelBtnInPopUp = (WebElement)((JavascriptExecutor) driver).executeScript(
//				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('iron-pages > div.vertical.layout.flex.iron-selected > div.buttons.horizontal.end-justified.layout > div > paper-button')");
//		Thread.sleep(30000);
//		CancelBtnInPopUp.click();
		driver.close();
	}

	public static void uploadFile() throws InterruptedException, AWTException {
		
			Robot robot = new Robot();
			String filePath = "C:\\Users\\u1102238\\eclipse-workspace\\oce-demo\\AutoIT\\uploadFiles\\test.txt";
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			}
}
