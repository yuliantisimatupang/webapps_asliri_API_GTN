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

WebUI.callTestCase(findTestCase('CW/Verify/Company Revenue Verification/1 - Go to Company Revenue Verification'), [:], FailureHandling.STOP_ON_FAILURE)

'Mapping Excel File'
nameTestData = 'Verify/Verify Company Revenue Verification'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('scenario6')

getLastRow = data.getRowNumbers()

GlobalVariable.getLastRow = getLastRow

for (int excelRow : (1..getLastRow)) {
    if (data.getValue('No', excelRow) == '') {
        break
    }
    
    'Import Sheet'
    GlobalVariable.captureCount = 0

    GlobalVariable.noRow = (GlobalVariable.noRow + 1)

    GlobalVariable.a = 0

    GlobalVariable.excelRow = excelRow

    company_npwp = data.getValue('company_npwp', excelRow)

    company_income = data.getValue('company_income', excelRow)
}

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Company Revenue Verification/h3_Please fill out the form below'), 
    2, FailureHandling.STOP_ON_FAILURE)) {
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
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Company Revenue Verification/input_npwp company'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Company Revenue Verification/input_company income'), 2)

    'input company npwp\r\n'
    WebUI.setText(findTestObject('Web/CWS/Company Revenue Verification/input_npwp company'), company_npwp)

    WebUI.delay(1)

    'input company income\r\n'
    WebUI.setText(findTestObject('Web/CWS/Company Revenue Verification/input_company income'), company_income)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Company Revenue Verification/button_Submit'), 2)

    WebUI.delay(1)

    'button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/Company Revenue Verification/button_Submit'))

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/Company Revenue Verification/button_Submit'))

    'wait result appear'
    WebUI.waitForElementPresent(findTestObject('Web/CWS/Company Revenue Verification/result Company Revenue Verification'), 
        2)

    'result company revenue verification\r\n'
    WebUI.verifyTextPresent('invalid', false)

    WebUI.delay(3)
}

