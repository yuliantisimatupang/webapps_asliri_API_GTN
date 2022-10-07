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

WebUI.callTestCase(findTestCase('CW/Verify/ASLI FAST/1 - Go to verify ASLI FAST'), [:], FailureHandling.STOP_ON_FAILURE)

'Mapping Excel File'
nameTestData = 'Verify/Verify ASLI FAST'

GlobalVariable.noRow = 0

TestData data = findTestData(nameTestData)

data.changeSheet('scenario7')

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

    trx_id = data.getValue('trx_id', excelRow)

    nik = data.getValue('nik', excelRow)

    name = data.getValue('name', excelRow)

    birthplace = data.getValue('birthplace', excelRow)

    birthdate = data.getValue('birthdate', excelRow)

    address = data.getValue('address', excelRow)
}

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/input_notransaksi'), 2, FailureHandling.STOP_ON_FAILURE)) {
    'input data nik and npwp'
    inputform()

    'close browser'
    WebUI.closeBrowser()
} else {
    'close browser'
    WebUI.closeBrowser()
}

def inputform() {
    WebUI.delay(2)

    'input form appear'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/input_notransaksi'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/input_nik'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/input_name'), 2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/input_birthplace'), 2)

    'input trx_id'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_notransaksi'), trx_id)

    WebUI.delay(1)

    'input nik'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_nik'), nik)

    WebUI.delay(1)

    'input name'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_name'), name)

    WebUI.delay(1)

    'input birthplace'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_birthplace'), birthplace)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/ASLI FAST/input_birthdate'), 2)

    WebUI.delay(1)

    'input birthdate'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_birthdate'), birthdate)

    WebUI.delay(1)

    'input address'
    WebUI.setText(findTestObject('Web/CWS/ASLI FAST/input_address'), address)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/ASLI FAST/button_Submit'), 2)

    WebUI.delay(1)

    'button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/ASLI FAST/button_Submit'))

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/ASLI FAST/button_Submit'))

    'wait result appear'
    WebUI.waitForElementPresent(findTestObject('Web/CWS/ASLI FAST/result ASLI FAST'), 2)

    'result ASLI FAST '
    WebUI.verifyElementPresent(findTestObject('Web/CWS/ASLI FAST/result ASLI FAST'), 2)

    WebUI.delay(3)
}

