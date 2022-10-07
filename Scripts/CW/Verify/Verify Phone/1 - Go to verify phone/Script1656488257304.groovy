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

'login'
WebUI.callTestCase(findTestCase('CW/Login/login valid data'), [:], FailureHandling.STOP_ON_FAILURE)

'scroll to verify phone'
WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Checkbox Verify Phone'), 2)

WebUI.delay(1)

if (WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Verify Phone'), 2, FailureHandling.STOP_ON_FAILURE)) {
    'go to verify phone'
    gotoverifyphone()
} else {
    'close browser'
    WebUI.closeBrowser()
}

def gotoverifyphone() {
    WebUI.delay(1)

    'click verify phone'
    WebUI.check(findTestObject('Web/CWS/Verify/Checkbox Verify Phone'))

    'verify element checked'
    WebUI.verifyElementChecked(findTestObject('Web/CWS/Verify/Checkbox Verify Phone'), 2)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 2)

    WebUI.delay(1)

    'click agreement'
    WebUI.check(findTestObject('Web/CWS/Verify/Checkbox Agreement'))

    'verify agreement checked'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 2)

    WebUI.delay(1)

    'scroll to button submit'
    WebUI.scrollToElement(findTestObject('Web/CWS/Verify/button_Submit'), 1)

    'verify button submit appear'
    WebUI.verifyElementClickable(findTestObject('Web/CWS/Verify/button_Submit'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    'click button submit'
    WebUI.click(findTestObject('Web/CWS/Verify/button_Submit'))

    WebUI.delay(3)
}

