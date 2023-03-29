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

def checkBalance1 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/verify_biometric_plus')

'Mapping Excel File'
nameTestData = 'Verify/Verify Biometric Plus'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('Sheet5')

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
	
	other = data.getValue('other', excelRow)

	name = data.getValue('name', excelRow)
	
	birthdate = data.getValue('birthdate', excelRow)
	
	birthplace = data.getValue('birthplace', excelRow)
	
	address = data.getValue('address', excelRow)
	
	mother_name = data.getValue('mother_name', excelRow)
	
	selfie_photo = data.getValue('selfie_photo', excelRow)
	
	files_photo = data.getValue('files_photo', excelRow)
}


WebUI.callTestCase(findTestCase('CW/Verify/Verify Biometric Plus/00 - Open Biometric Plus Verification'), [:], FailureHandling.STOP_ON_FAILURE)

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
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_other'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_name'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_dob'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_pob'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_address'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_mother_name'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/button_Webcam'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/button_Selfie_photo'), 0)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/input_files_photo'), 0)
	
	WebUI.click(findTestObject('Web/CWS/Verify Biometric Plus/button_Selfie_photo'))
	
	//WebUI.delay(1)
	
	String useDir = System.getProperty("user.dir")
	
	WebUI.uploadFile(findTestObject('Web/CWS/Verify Biometric Plus/input_selfie_photo'), useDir + selfie_photo)
	
	FilePath = WebUI.getAttribute(findTestObject('Web/CWS/Verify Biometric Plus/input_selfie_photo'), 'value')
	
	WebUI.verifyMatch(FilePath, 'C:\\fakepath\\jeli.png', false)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_name'), name)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_pob'), birthplace)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_dob'), birthdate)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_address'), address)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_mother_name'), mother_name)
	
	WebUI.setText(findTestObject('Web/CWS/Verify Biometric Plus/input_other'), other)
	
	WebUI.uploadFile(findTestObject('Web/CWS/Verify Biometric Plus/input_files_photo'), useDir + files_photo)
	
	FilePath2 = WebUI.getAttribute(findTestObject('Web/CWS/Verify Biometric Plus/input_files_photo'), 'value')
	
	WebUI.verifyMatch(FilePath2, 'C:\\fakepath\\ektp.png', false)
	
	'button submit appear'
	WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify Biometric Plus/button_Submit'))
	
	WebUI.scrollToElement(findTestObject('Web/CWS/Verify Biometric Plus/button_Submit'), 0)

	'click button submit'
	WebUI.click(findTestObject('Web/CWS/Verify Biometric Plus/button_Submit'))

	'wait result appear'
	WebUI.waitForElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/Result/result Verify Biometric Plus'), 1)
	
	WebUI.scrollToElement(findTestObject('Web/CWS/Verify Biometric Plus/Result/div_2023 PT. ASLI RI'), 1)
	
	'confirm result'
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/Result/span_99'), 1)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/Result/span_100'), 1)
	
	WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Biometric Plus/Result/span_JL. TBT BRT RY N.20'), 1)
	
	WebUI.delay(2)
	
	Integer rtn = CustomKeywords."dialog.DialogKeyword.showConfirmationDialog"("Apakah case ini PASS?", "Konfirmasi")
	
	if (rtn == 0) {
		assert true : "pass"
	} else {
		WebUI.closeBrowser()
		assert false : "fail"
	}
	
}

def checkBalance2 = CustomKeywords.'abstraction.customKeyword.getRemainingAccess'('/verify_biometric_plus')

println checkBalance1
println checkBalance2
assertEquals(checkBalance1 - 1, checkBalance2)