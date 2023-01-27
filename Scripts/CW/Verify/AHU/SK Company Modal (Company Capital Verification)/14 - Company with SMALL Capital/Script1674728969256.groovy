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

def checkBalance1 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_modal')

'Mapping Excel File'
nameTestData = 'Verify/SK Company Modal'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('Sheet14')

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

	sk_ahu = data.getValue('sk_ahu', excelRow)
}


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
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company/input_company'), 1)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/SK Company/input_decreeno'), 1)
	
	//WebUI.delay(1)
	
	WebUI.setText(findTestObject('Web/CWS/AHU/SK Company/input_company'), company_name)
	
	WebUI.setText(findTestObject('Web/CWS/AHU/SK Company/input_decreeno'), sk_ahu)

	'button submit appear'
	WebUI.verifyElementClickable(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'))
	
	WebUI.scrollToElement(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'), 1)

	'click button submit'
	WebUI.click(findTestObject('Web/CWS/AHU/SK Company Modal/button_Submit'))

	'wait result appear'
	WebUI.waitForElementPresent(findTestObject('Web/CWS/AHU/Result/result Company Capital Verification'), 1)
	
	'confirm result'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/Result/icon centang'), 1)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/AHU/Result/span_SMALL'), 1)
	
	Integer rtn = CustomKeywords."dialog.DialogKeyword.showConfirmationDialog"("Apakah case ini PASS?", "Konfirmasi")
	
	if (rtn == 0) {
		assert true : "pass"
	} else {
		WebUI.closeBrowser()
		assert false : "fail"
	}
	
}

def checkBalance2 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/sk_company_modal')

println checkBalance1
println checkBalance2
assertEquals(checkBalance1 - 1, checkBalance2)