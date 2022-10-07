package basic

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

import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.logging.KeywordLogger

import internal.GlobalVariable

public class keyword {
	@Keyword
	def getRemainingAccess(String text) {
		def url = GlobalVariable.url
		RequestObject verifyBalance = findTestObject('API/Basic/check_balance')
		verifyBalance.setRestUrl("$url/remaining_access")
		ArrayList<TestObjectProperty> HTTPHeader = new ArrayList<TestObjectProperty>()
		HTTPHeader.add(new TestObjectProperty('token', ConditionType.EQUALS, GlobalVariable.token))
		HTTPHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
		verifyBalance.setHttpHeaderProperties(HTTPHeader)
		'send request'
		def responseVerifyBalance = WS.sendRequest(verifyBalance)
		'verify status code'
		WS.verifyResponseStatusCode(responseVerifyBalance, 200)
		def slurper = new groovy.json.JsonSlurper()
		def result = slurper.parseText(responseVerifyBalance.getResponseBodyContent())
		println result
		def textStatus = text
		def index = result.data.findIndexOf{it.url == textStatus}
		//		println index
		def remainingAccess = result.data[index].remainingAccess
		return remainingAccess
	}
}
