import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static org.junit.Assert.assertEquals

WebUI.callTestCase(findTestCase('CW/Verify/AHU/SK Company Modal (Company Capital Verification)/00 - Open Company Capital Verification'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Page_Verify Data - ASLI RI/h3_Please fill out the form below'), 1, FailureHandling.STOP_ON_FAILURE)) {
	'input data'
	inputform()

	'close browser'
	WebUI.closeBrowser()
} else {
	'close browser'
	WebUI.closeBrowser()
}

def inputform() {
	'input form appear'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Modal/input_company'), 1)
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Modal/input_decreeno'), 1)
	WebUI.scrollToElement(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'), 1)

	'button submit appear'
	WebUI.verifyElementClickable(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'))
	
	def checkBalance1 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_modal')

	'click button submit'
	WebUI.click(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'))
	
	def checkBalance2 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_modal')

	'wait result appear'
	WebUI.waitForElementPresent(findTestObject('Web/CWS/AHU/SK Company Modal/div_error_company_name'), 1)
	
	'confirm alert'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Modal/div_error_company_name'), 1)
	WebUI.delay(1)
	WebUI.verifyMatch(WebUI.getText(findTestObject('Web/CWS/AHU/SK Company Modal/div_error_company_name')), 'This field is required', false)
	
	println checkBalance1
	println checkBalance2
	assertEquals(checkBalance1 - 0, checkBalance2)
}