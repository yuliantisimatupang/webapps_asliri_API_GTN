package uploadfile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory


import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

public class uploadphoto {

	@Keyword
	def clickUsingJS(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	@Keyword
	def uploadFile(TestObject to, String filePath) {
		WebUI.click(to)
		//clickUsingJS(to, 0)
		WebUI.delay(3)
		StringSelection ss = new StringSelection(filePath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
		Robot robot = new Robot()
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus
		robot.keyPress(KeyEvent.VK_META)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyRelease(KeyEvent.VK_META)
		robot.keyRelease(KeyEvent.VK_TAB)
		robot.delay(1500)
		//Open Goto window
		robot.keyPress(KeyEvent.VK_META)
		robot.keyPress(KeyEvent.VK_SHIFT)
		robot.keyPress(KeyEvent.VK_G)
		robot.keyRelease(KeyEvent.VK_META)
		robot.keyRelease(KeyEvent.VK_SHIFT)
		robot.keyRelease(KeyEvent.VK_G)
		robot.delay(1500)
		//Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_META)
		robot.keyRelease(KeyEvent.VK_V)
		robot.delay(1500)
		//Press Enter key to close the Goto window and Upload window
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.delay(1500)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}
	
	@Keyword
	def uploadFileJS(TestObject to, String filePath) {
		//WebUI.click(to)
		clickUsingJS(to, 0)
		WebUI.delay(3)
		StringSelection ss = new StringSelection(filePath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.delay(500)
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.delay(500)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyRelease(KeyEvent.VK_TAB)
		robot.delay(250)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyRelease(KeyEvent.VK_TAB)
		robot.delay(500)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	@Keyword
	def encodeFile(String file) {
		byte[] fileContent = FileUtils.readFileToByteArray(new File(file))
		String encodedString = Base64.getEncoder().encodeToString(fileContent)
		return encodedString
		println encodedString
	}
}
