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

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_email'), 'yulianti@mail.com')

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_password'), 'Yulianti23*')

WebUI.submit(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_firstForm'))

WebUI.check(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_checkbox_vp'))

WebUI.check(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_checkbox_agree'))

WebUI.submit(findTestObject('Object Repository/OR_WebApps/or_loginWebApps/or_secondForm'))

WebUI.delay(10)

