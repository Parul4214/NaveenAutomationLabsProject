package assignmentWeek19.Reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {

	// public ExtentHtmlReporter htmlReporter;//removed in series 5
	// extent reporter not able to instantiate

	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	public ExtentReports extent;

	// onstart method will be invoked as soona sthe listner class is invoked
	// all configurations will be done inside the on start
	@Override
	public void onStart(ITestContext testContext) {
		// Time on which report was generated
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Name of the report
		String repName = "Extent_Report_" + timeStamp + ".html";

		// Defines the location of extent report.//give relative path
		sparkReporter = new ExtentSparkReporter("./Extent Report/" + repName);

		// Loading the config XML
		try {
			sparkReporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// name of the report
		sparkReporter.config().setReportName("Regression Suite");
		// theme dark/standard
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		// some environment variables
		extent.setSystemInfo("Name of the host", "Localhost");
		extent.setSystemInfo("Tester Name", "Parul");
		extent.setSystemInfo("Env", "Prod");

	}

	// overriding the behavior of something in test listener class
	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());// get the name of the test
		// logging status PASS , markup check mark, color green, label with test name
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
