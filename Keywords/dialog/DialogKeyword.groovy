package dialog

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.awt.Font
import java.lang.Integer

import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.UIManager
import javax.swing.filechooser.FileSystemView

import com.kms.katalon.core.annotation.Keyword

public class DialogKeyword {

	@Keyword
	public static int showConfirmationDialog(String message, String title="title") {
		int returnValue = 0;
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		JFrame frame = new JFrame(title)
		frame.setAlwaysOnTop(true)
		frame.requestFocus()
		return JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
	}

	@Keyword
	public static Tuple showFileChooser(String filePath, String title="title"){
		int returnValue = 0;
		JFrame frame = new JFrame(title)
		frame.setAlwaysOnTop(true)
		frame.requestFocus()
		File file=new File(filePath)
		JFileChooser chooser = new JFileChooser(file, FileSystemView.getFileSystemView())
		Integer ret = chooser.showOpenDialog(frame)
		return new Tuple(ret, chooser.getSelectedFile())
	}
}