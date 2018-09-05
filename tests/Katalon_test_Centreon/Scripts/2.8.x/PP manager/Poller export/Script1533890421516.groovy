import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def config = TestDataFactory.findTestData('Configuration')

WebUI.openBrowser(config.getValue('url', 1))

//**************************************************************Login**************************************************************//

WebUI.setText(findTestObject('General/Login/input_useralias'), config.getValue('login', 1))

WebUI.setText(findTestObject('General/Login/input_password'), config.getValue('password', 1))

WebUI.click(findTestObject('General/Login/input_submitLogin'))

//********************************************************go to pollers page*******************************************************//

CustomKeywords.'custom.NavigationConfiguration.accessPollers'()

//*****************************************************Export the configuration****************************************************//

WebUI.delay(1)

WebUI.click(findTestObject('Configuration/Poller export/input_select1'))

WebUI.click(findTestObject('Configuration/Poller export/input_apply_configuration'))

WebUI.waitForElementClickable(findTestObject('Configuration/Poller export/input_move'), 3)

WebUI.click(findTestObject('Configuration/Poller export/input_move'))

WebUI.click(findTestObject('Configuration/Poller export/input_restart'))

WebUI.selectOptionByLabel(findTestObject('Configuration/Poller export/select_Restart'), 'Restart', true)

WebUI.click(findTestObject('Configuration/Poller export/input_submit'))

//Wait for the export to finish
WebUI.delay(3)

WebUI.click(findTestObject('Old menu/a_Logout'))

WebUI.closeBrowser()
