package abstraction

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class loginCW {

	@Keyword
	def login (String username, String password) {
		//WebUI.setText(findTestObject('Web/CWS/Login/email_textField'), GlobalVariable.username)
		WebUI.setText(findTestObject('Web/CWS/Login/email_textField'), username)
		//WebUI.setText(findTestObject('Web/CWS/Login/password_textField'), GlobalVariable.password)
		WebUI.setText(findTestObject('Web/CWS/Login/password_textField'), password)
		WebUI.click(findTestObject('Web/CWS/Login/login_btn'), FailureHandling.STOP_ON_FAILURE)
		//WebUI.delay(2)
	}
}


