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

'go to verify income grade'
WebUI.callTestCase(findTestCase('CW/Verify/Verify Income Grade/1 - Go to veriy income grade'), [:], FailureHandling.STOP_ON_FAILURE)

'Mapping Excel File'
nameTestData = 'Verify/Verify income grade'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('scenario11')

getLastRow = data.getRowNumbers()

GlobalVariable.getLastRow = getLastRow

for (int excelRow : (1..getLastRow)) {
    if (data.getValue('No', excelRow) == '') {
        break
    }
    
    'Import Sheet verify income grade'
    GlobalVariable.captureCount = 0

    GlobalVariable.noRow = (GlobalVariable.noRow + 1)

    GlobalVariable.a = 0

    GlobalVariable.excelRow = excelRow

    trx_id = data.getValue('trx_id', excelRow)

    nik = data.getValue('nik', excelRow)

    npwp = data.getValue('npwp', excelRow)
}

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income Grade/h3_Please fill out the form below'), 2, FailureHandling.STOP_ON_FAILURE)) {
    'input data nik and npwp'
    inputform()

    'close browser'
    WebUI.closeBrowser()
} else {
    'close browser'
    WebUI.closeBrowser()
}

def inputform() {
    'input form appear'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income Grade/input_trx id'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income Grade/input_nik'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income Grade/input_npwp'), 2)

    'input trx_id'
    WebUI.setText(findTestObject('Web/CWS/Verify Income Grade/input_trx id'), trx_id)

    WebUI.delay(1)

    'input nik'
    WebUI.setText(findTestObject('Web/CWS/Verify Income Grade/input_nik'), nik)

    WebUI.delay(1)

    'input npwp'
    WebUI.setText(findTestObject('Web/CWS/Verify Income Grade/input_npwp'), npwp)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify Income Grade/button_Submit'), 2)

    WebUI.delay(1)

    'button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify Income Grade/button_Submit'))

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/Verify Income Grade/button_Submit'))

    'wait result appear'
    WebUI.waitForElementPresent(findTestObject('Web/CWS/Verify Income Grade/result income grade'), 2)

    'result income grade appear'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income Grade/result income grade'), 2)
	
	WebUI.verifyTextPresent('1', false)
	

    WebUI.delay(3)
}

