package Rahultext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject () {
		String path = System.getProperty("user.dir") + "\\reportes\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result"); // report name
		reporter.config().setDocumentTitle("Results");
		
		ExtentReports extent = new ExtentReports ();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Shraddha");
		return extent;
	}

}
