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

public class NuxeoDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://3.129.73.164:8080/nuxeo/login.jsp?requestedUrl=ui%2F");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rama");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//input[@class='login_button']")).click();
		Thread.sleep(6000);
		
		WebElement browseBtn = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector(\"body > nuxeo-app\").shadowRoot.querySelector(\"#menu > nuxeo-menu-icon:nth-child(1)\").shadowRoot.querySelector(\"#button\")");
		Thread.sleep(6000);
		browseBtn.click();
		Thread.sleep(3000);
		String folderpath = "http://3.129.73.164:8080/nuxeo/ui/#!/browse/default-domain/workspaces/Ram%20Automation";
		String workSpaceFolderPath = "http://3.129.73.164:8080/nuxeo/ui/#!/browse/default-domain/workspaces/Ram%20Automation";
		//driver.get(workSpaceFolderPath);
		// WebElement abc =
		// (WebElement)((JavascriptExecutor)driver).executeScript("return
		// document.querySelectorAll(\"nuxeo-app\").shadowRoot.querySelector(\"nuxeo-menu-icon[1]\")");
		// abc.click();

		// WebElement test =
		// (WebElement)((JavascriptExecutor)driver).executeScript("return
		// document.querySelector('nuxeo-app').shadowRoot.querySelector(\"nuxeo-menu-icon:nth-child(1)\").shadowRoot.querySelector(\"#button\").shadowRoot.querySelector(\"#icon\")");
		// WebElement browse =
		// (WebElement)((JavascriptExecutor)driver).executeScript("return
		// document.querySelector('nuxeo-app').shadowRoot.querySelector('nuxeo-menu-icon.selected').shadowRoot.querySelector('#button').shadowRoot.querySelector('#icon')");
		WebElement abc = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('nuxeo-document-create-button').shadowRoot.querySelector('paper-fab').shadowRoot.querySelector('iron-icon')");
		WebElement cancelBtn = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('iron-pages > div.vertical.iron-selected > div.buttons.horizontal.end-justified.layout > div > paper-button')");
		WebElement root = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#navTree').shadowRoot.querySelector('div.content > div.parents > a.layout.horizontal > span.parent')");
		WebElement rootExpand = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#navTree').shadowRoot.querySelector('div.content > div.parents > a > span:nth-child(1) > iron-icon')");
		WebElement domain = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('body > nuxeo-app').shadowRoot.querySelector('#navTree').shadowRoot.querySelector('#root > div > span > a')");
		WebElement workspace = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#navTree').shadowRoot.querySelector('div.content > div.parents > a:nth-child(3) > span.parent')");
//	             ((JavascriptExecutor)driver).executeScript("arguments[0].click();", rootExpand);
//	             Thread.sleep(3000);
//	             ((JavascriptExecutor)driver).executeScript("arguments[0].click();", domain);
//	             Thread.sleep(3000);
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		// workspace);
		// Thread.sleep(5000);
		abc.click();
		Thread.sleep(3000);

		/* Create Pop-Up */
		WebElement fileBtn = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('iron-pages > div.vertical.iron-selected > div.container > paper-dialog-scrollable > div > paper-button:nth-child(4) > div')");
		fileBtn.click();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(parentWindow);
			}
		}

		/* Content Creation Window */
		/* Title TxtBox */
           JavascriptExecutor jse = (JavascriptExecutor)driver;
           WebElement titleTxtBox = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('#document-create').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#container > nuxeo-file-create-layout').shadowRoot.querySelector('nuxeo-input').shadowRoot.querySelector('#paperInput')");
           Thread.sleep(6000);
           titleTxtBox.sendKeys("Test Doc");
           Thread.sleep(3000);
           //            String js = "arguments[0].setAttribute('value', 'Test Content')";
//            ((JavascriptExecutor)driver).executeScript(js,titleTxtBox);
//	        Thread.sleep(3000);
		
	        /* Description TxtBox */
//	             WebElement descriptionTxtBox = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('#document-create').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#container > nuxeo-file-create-layout').shadowRoot.querySelector('nuxeo-textarea').shadowRoot.querySelector('#paperTextarea').shadowRoot.querySelector('#input-68').shadowRoot.querySelector('#textarea')");
//	             descriptionTxtBox.sendKeys("Test");

		WebElement uploadLink = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('#document-create').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#container > nuxeo-file-create-layout').shadowRoot.querySelector('nuxeo-dropzone').shadowRoot.querySelector('#container > a')");
		uploadLink.click();
		Thread.sleep(5000);
		uploadFile();
//	             /*Nature Dropdown*/
//	             WebElement natureDropdown = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('#document-create').shadowRoot.querySelector('#layout').shadowRoot.querySelector('#container > nuxeo-file-create-layout').shadowRoot.querySelector('nuxeo-directory-suggestion:nth-child(5)').shadowRoot.querySelector('#s2').shadowRoot.querySelector('#input > div > iron-icon')");
//	             natureDropdown.click();
		WebElement CancelBtnInPopUp = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('nuxeo-app').shadowRoot.querySelector('#importPopup').shadowRoot.querySelector('#simpleCreation').shadowRoot.querySelector('iron-pages > div.vertical.layout.flex.iron-selected > div.buttons.horizontal.end-justified.layout > div > paper-button')");
		Thread.sleep(30000);
		CancelBtnInPopUp.click();
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
