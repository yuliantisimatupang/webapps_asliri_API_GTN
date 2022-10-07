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

WebUI.openBrowser(GlobalVariable.url_cw)

WebUI.maximizeWindow()

CustomKeywords.'abstraction.loginCW.login'(GlobalVariable.username, GlobalVariable.password)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Verify Personal Tax Extra'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Checkbox Verify Personal Tax Extra'))

WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 0)

//WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 0)
WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Checkbox Agreement'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Checkbox Agreement'))

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Submit_btn'))

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), '132432784211')

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), GlobalVariable.nik)

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), 'Jelita Septriasa')

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), 'Jakarta')

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), '01-09-1989')

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income and NPWP (Personal)/npwp_textField'), 0)

WebUI.setText(findTestObject('Web/CWS/Verify Income and NPWP (Personal)/npwp_textField'), '341823102482')

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify Income and NPWP (Personal)/personalincome_textField'), 0)

WebUI.setText(findTestObject('Web/CWS/Verify Income and NPWP (Personal)/personalincome_textField'), '5000000')

WebUI.scrollToElement(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.verifyElementPresent(findTestObject('Web/CWS/Verify/Submit_btn'), 0)

WebUI.click(findTestObject('Web/CWS/Verify/Submit_btn'))

WebUI.delay(3)

WebUI.closeBrowser()

