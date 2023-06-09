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

WebUI.openBrowser(GlobalVariable.base_url)

WebUI.maximizeWindow()

CustomKeywords.'abstraction.loginCW.login'(GlobalVariable.username, GlobalVariable.password)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Verify Selfie'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Checkbox Verify Selfie'))

WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 0)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Checkbox Agreement'))

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Submit_btn'))

WebUI.verifyElementPresent(findTestObject('null'), 0)

CustomKeywords.'uploadfile.uploadphoto.clickUsingJS'(findTestObject('null'), 0)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Professional/choosephoto_btn'), 0)

CustomKeywords.'uploadfile.uploadphoto.uploadFile'(findTestObject('Web/CWS/Verify Professional/choosephoto_btn'), GlobalVariable.selfie)

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), '132432784211')

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), '3175044109890002')

WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Submit_btn'))

WebUI.scrollToElement(findTestObject('Web/CWS/Verify Selfie/verifyselfie_label'), 0)

WebUI.delay(3)

WebUI.closeBrowser()

