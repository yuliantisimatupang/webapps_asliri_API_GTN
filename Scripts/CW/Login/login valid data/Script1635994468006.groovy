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
    'open browser'
    WebUI.openBrowser('')

    'navigate to url'
    WebUI.navigateToUrl(GlobalVariable.base_url)

    WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

    'Mapping Excel File'
    nameTestData = 'Login/login to cw'

    GlobalVariable.noRow = 0

    TestData data = findTestData(nameTestData)

    //data.changeSheet("Sheet2")
    getLastRow = data.getRowNumbers()

    GlobalVariable.getLastRow = getLastRow

    for (int excelRow : (1..getLastRow)) {
        if (data.getValue('No', excelRow) == '') {
            break
        }
        
        'Import Sheet LOGIN'
        GlobalVariable.captureCount = 0

        GlobalVariable.noRow = (GlobalVariable.noRow + 1)

        GlobalVariable.a = 0

        GlobalVariable.excelRow = excelRow

        email = data.getValue('email', excelRow)

        password = data.getValue('password', excelRow)
    }
    
    'email field appear'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Login/email_textField'), 0)

    WebUI.delay(2)

    'input valid email'
    WebUI.setText(findTestObject('Web/CWS/Login/email_textField'), email)

    WebUI.delay(2)

    'password field appear'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Login/password_textField'), 0)

    WebUI.delay(2)

    'input valid password'
    WebUI.setText(findTestObject('Web/CWS/Login/password_textField'), password)

    WebUI.delay(2)

    'click button login'
    WebUI.click(findTestObject('Web/CWS/Login/login_btn'))

    'wait for loading '
    WebUI.waitForPageLoad(1)

    'success login'
    WebUI.verifyElementPresent(findTestObject('Web/CWS/Menu/div_ASLI RI header'), 2)

    WebUI.delay(3)

    //WebUI.closeBrowser()
    GlobalVariable.status = 'PASSED'
}
catch (Exception e) {
    GlobalVariable.status = 'FAILED'
} 

