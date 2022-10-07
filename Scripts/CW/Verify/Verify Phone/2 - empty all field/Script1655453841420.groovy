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

try {
    'go to input form verify phone'
    WebUI.callTestCase(findTestCase('CW/Verify/Verify Phone/1 - Go to verify phone'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone/h3_Please fill out the form below'), 2)

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify Phone/button_Submit'), 3)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone/button_Submit'), 1)

    WebUI.check(findTestObject('Web/CWS/Verify Phone/button_Submit'))

    WebUI.delay(2)

    WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Phone/button_Submit'), 2)

    WebUI.delay(2)

    WebUI.verifyTextPresent('This field is required', false)

    WebUI.delay(3)

    WebUI.scrollToElement(findTestObject('Web/CWS/Verify Phone/button_Submit'), 3)

    WebUI.delay(2)

    WebUI.closeBrowser()
}
catch (Exception e) {
    GlobalVariable.status = 'Failed empty all field'
} 

