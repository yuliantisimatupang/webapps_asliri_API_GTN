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

WebUI.callTestCase(findTestCase('CW/Verify/Verify Phone Identity/1 - Go to verify phone identity'), [:], FailureHandling.STOP_ON_FAILURE)

'Mapping Excel File'
nameTestData = 'Verify/Verify phone identify'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('scenario6')

getLastRow = data.getRowNumbers()

GlobalVariable.getLastRow = getLastRow

for (int excelRow : (1..getLastRow)) {
    if (data.getValue('No', excelRow) == '') {
        break
    }
    
    'Import Sheet verify phone number'
    GlobalVariable.captureCount = 0

    GlobalVariable.noRow = (GlobalVariable.noRow + 1)

    GlobalVariable.a = 0

    GlobalVariable.excelRow = excelRow

    name = data.getValue('name', excelRow)

    birthdate = data.getValue('birthdate', excelRow)

    phone = data.getValue('phone', excelRow)
}

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone Identity/h3_Please fill out the form below'), 2, FailureHandling.STOP_ON_FAILURE)) {
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
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone Identity/input_name'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone Identity/input_birthdate'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone Identity/input_phone number'), 2)

    'input name'
    WebUI.setText(findTestObject('Web/CWS/Verify Phone Identity/input_name'), name)

    WebUI.delay(1)

    'input birthdate'
    WebUI.setText(findTestObject('Web/CWS/Verify Phone Identity/input_birthdate'), birthdate)

    WebUI.delay(1)

    'input phone'
    WebUI.setText(findTestObject('Web/CWS/Verify Phone Identity/input_phone number'), phone)

    WebUI.delay(1)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify Basic Plus/button_Submit'), 2)

    WebUI.delay(1)

    'button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify Basic Plus/button_Submit'))

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/Verify Phone Identity/button_Submit'))

    'wait result appear'
    WebUI.waitForElementPresent(findTestObject('Web/CWS/Verify Phone Identity/result Verify Phone Identity'), 2)

    'result verify phone identify'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone Identity/result Verify Phone Identity'), 2)

    WebUI.delay(3)
}

