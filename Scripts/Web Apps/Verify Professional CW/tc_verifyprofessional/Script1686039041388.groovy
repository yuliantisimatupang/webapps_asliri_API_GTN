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
import abstraction.customKeyword as customKeyword
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.assertEquals
import org.openqa.selenium.Keys as Keys

def slurper = new groovy.json.JsonSlurper()

def bodyInput = slurper.parseText(Input)

def expectResult = slurper.parseText(Expect)

def divideBalance = 1

String useDir = System.getProperty('user.dir')

WebUI.callTestCase(findTestCase('Web Apps/Login Web Apps/tc_loginWebApps'), [:], FailureHandling.STOP_ON_FAILURE)

if (bodyInput.files_photo != '') {
    WebUI.click(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_choose_upload_image'))

    WebUI.uploadFile(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_input_files_photo'), (useDir + 
        '/Resources/') + bodyInput.files_photo)
}

if (bodyInput.trx_id) {
    WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_trx_id'), bodyInput.trx_id)
}

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_input_name'), bodyInput.name)

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_input_birthplace'), bodyInput.birthplace)

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_input_birthdate'), bodyInput.birthdate)

WebUI.setText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_input_other'), bodyInput.other)

if (bodyInput.other_file != '') {
    WebUI.uploadFile(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_upload_other_file'), (useDir + 
        '/Resources/') + bodyInput.other_file)
}

def balanceBefore = new customKeyword().getRemainingAccess('/verify_professional')

WebUI.submit(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_form_verify_profesional'))

WebUI.verifyTextPresent(expectResult.wording, false)

if (expectResult.wording == 'Success') {
    def balanceAfter = new customKeyword().getRemainingAccess('/verify_professional')

    def tempName = WebUI.getText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_result_name'))

    def tempPDOB = WebUI.getText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_result_pdob'))

    def tempSelfie = WebUI.getText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_result_selfie_photo'))

    def tempOther = WebUI.getText(findTestObject('Object Repository/OR_WebApps/or_verify_professional/or_result_other'))

    if ((!(checkEqual(tempName, 'name')) && !(checkEqual(tempPDOB, 'pdob'))) && !(checkEqual(tempSelfie, 'selfie'))) {
        divideBalance = tempOther == '' ? 0 : 1
    } else {
        assert checkEqual(tempName, 'name')

        assert checkEqual(tempPDOB, 'pdob')

        assert checkEqual(tempSelfie, 'selfie')
    }
    
    assertEquals(balanceBefore - divideBalance, balanceAfter)
}

WebUI.closeBrowser()

def convertToDouble(def val) {
    return Double.valueOf(val.replaceAll(' %', ''))
}

def checkEqual(def val, def name) {
    def slurper = new groovy.json.JsonSlurper()

    def res = slurper.parseText(Expect)

    def equalLessThan = val != '' ? WebUI.verifyLessThanOrEqual(convertToDouble(val), res[name].max) : false

    def equalGreaterThan = val != '' ? WebUI.verifyGreaterThanOrEqual(convertToDouble(val), res[name].min) : false

    return equalLessThan && equalGreaterThan
}