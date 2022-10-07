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

'go to verify workplace'
WebUI.callTestCase(findTestCase('CW/Verify/Verify Workplace/1 - Go to verify workplace'), [:], FailureHandling.STOP_ON_FAILURE)

'Mapping Excel File'
nameTestData = 'Verify/Verify workplace'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('scenario4')

getLastRow = data.getRowNumbers()

GlobalVariable.getLastRow = getLastRow

for (int excelRow : (1..getLastRow)) {
    if (data.getValue('No', excelRow) == '') {
        break
    }
    
    'Import Sheet verify workplace'
    GlobalVariable.captureCount = 0

    GlobalVariable.noRow = (GlobalVariable.noRow + 1)

    GlobalVariable.a = 0

    GlobalVariable.excelRow = excelRow

    nik = data.getValue('nik', excelRow)

    name = data.getValue('name', excelRow)

    company_name = data.getValue('company_name', excelRow)

    company_phone = data.getValue('company_phone', excelRow)
}

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/h3_Please fill out the form below'), 2, FailureHandling.STOP_ON_FAILURE)) {
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
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/input_nik'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/input_name'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/input_company name'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/input_company phone'), 2)

    'input nik'
    WebUI.setText(findTestObject('Web/CWS/Verify Workplace/input_nik'), nik)

    WebUI.delay(1)

    'input name'
    WebUI.setText(findTestObject('Web/CWS/Verify Workplace/input_name'), name)

    WebUI.delay(1)

    'input company name'
    WebUI.setText(findTestObject('Web/CWS/Verify Workplace/input_company name'), company_name)

    WebUI.delay(1)

    'input company phone'
    WebUI.setText(findTestObject('Web/CWS/Verify Workplace/input_company phone'), company_phone)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify Workplace/button_Submit'), 2)

    WebUI.delay(1)

    'button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify Workplace/button_Submit'))

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/Verify Workplace/button_Submit'))

    'wait result appear'
    WebUI.waitForElementPresent(findTestObject('Web/CWS/Verify Workplace/Verify Workplace result'), 2)

    'result verify workplace'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/Verify Workplace result'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Workplace/icon -'), 2)

    WebUI.delay(3)
}

