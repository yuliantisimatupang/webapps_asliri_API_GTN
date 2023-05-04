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

WebUI.callTestCase(findTestCase('CW/Verify/Verify Company Ownership/00 - Open Company Ownership Verification'), [:], FailureHandling.STOP_ON_FAILURE)

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
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Company Ownership/input_npwp'), 1)
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Company Ownership/input_name'), 1)
	
	'button submit appear'
	WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify Company Ownership/button_Submit'))
	WebUI.scrollToElement(findTestObject('Web/CWS/Verify Company Ownership/button_Submit'), 1)

	def checkBalance1 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/verify_company_ownership')

	'click button submit'
	WebUI.click(findTestObject('Web/CWS/Verify Company Ownership/button_Submit'))
	
	def checkBalance2 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/verify_company_ownership')

	'wait result appear'
	WebUI.waitForElementPresent(findTestObject('Web/CWS/Verify Company Ownership/div_error_npwp'), 1)
	
	'confirm alert'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Company Ownership/div_error_npwp'), 1)
	WebUI.delay(1)
	WebUI.verifyMatch(WebUI.getText(findTestObject('Web/CWS/Verify Company Ownership/div_error_npwp')), 'This field is required', false)
	
	println checkBalance1
	println checkBalance2
	assertEquals(checkBalance1 - 0, checkBalance2)	
}