package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil extends SeWrappers {

	String filename = reportlocation + "extentreport.html";

	public void ExtentReport() {
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("PYT Automation Test report ");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Automation Report");
		extent.attachReporter(htmlReporter);
	}

	public void ExtentReportScreenshot() {
	}

}
