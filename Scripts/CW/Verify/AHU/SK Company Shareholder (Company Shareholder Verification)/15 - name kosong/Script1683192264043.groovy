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

'Mapping Excel File'
nameTestData = 'Verify/SK Company Shareholder'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('Sheet15')

getLastRow = data.getRowNumbers()

GlobalVariable.getLastRow = getLastRow

for (int excelRow : (1..getLastRow)) {
	if (data.getValue('No', excelRow) == '') {
		break
	}
	
	'Import Sheet verify phone total'
	GlobalVariable.captureCount = 0
	GlobalVariable.noRow = (GlobalVariable.noRow + 1)
	GlobalVariable.a = 0
	GlobalVariable.excelRow = excelRow

	company_name = data.getValue('company_name', excelRow)
	nik = data.getValue('nik', excelRow)
	name = data.getValue('name', excelRow)
}


WebUI.callTestCase(findTestCase('CW/Verify/AHU/SK Company Shareholder (Company Shareholder Verification)/00 - Open Company Shareholder Verification'), [:], FailureHandling.STOP_ON_FAILURE)

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
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_company'), 1)	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_nik'), 1)	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_name'), 1)
	
	WebUI.setText(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_company'), company_name)
	WebUI.setText(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_nik'), nik)
	WebUI.setText(findTestObject('Web/CWS/AHU/SK Company Shareholder/input_name'), name)

	'button submit appear'
	WebUI.verifyElementClickable(findTestObject('Web/CWS/AHU/SK Company Shareholder/button_Submit'))
	WebUI.scrollToElement(findTestObject('Web/CWS/AHU/SK Company Shareholder/button_Submit'), 1)
	
	def checkBalance1 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_shareholder')

	'click button submit'
	WebUI.click(findTestObject('Web/CWS/AHU/SK Company Shareholder/button_Submit'))
	
	def checkBalance2 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_shareholder')

	'wait result appear'
	WebUI.waitForElementPresent(findTestObject('Web/CWS/AHU/Result/result Company Shareholder Verification'), 1)
	
	'confirm result'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/Result/icon_company_name'), 1)
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Web/CWS/AHU/Result/icon_company_name'), 'class'), 'mdi mdi-check match', false)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/Result/icon_decree_no'), 1)
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Web/CWS/AHU/Result/icon_decree_no'), 'class'), 'mdi mdi-check match', false)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/Result/icon_decree_date'), 1)
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Web/CWS/AHU/Result/icon_decree_date'), 'class'), 'mdi mdi-minus', false)

	println checkBalance1
	println checkBalance2
	assertEquals(checkBalance1 - 1, checkBalance2)
}