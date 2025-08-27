package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility 
{
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7Mart Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Anusha");
		extentReports.setSystemInfo("Name", "Vishnu");
		extentReports.setSystemInfo("Name", "Sreejith");
		extentReports.setSystemInfo("Name", "Varsha");
		extentReports.setSystemInfo("Name", "Reshma");
		extentReports.setSystemInfo("Name", "Ashin");
		extentReports.setSystemInfo("Name", "Jefrin");
		return extentReports;
	}
}
