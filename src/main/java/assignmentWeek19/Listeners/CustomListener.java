package assignmentWeek19.Listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import assignmentWeek17.Base.TestBase;
import assignmentWeek19.Utils.Log;
import assignmentWeek19.Utils.Utils;

//A listneer for test running
//automatially invoked when running or excuting anything related to test
public class CustomListener extends TestBase implements ITestListener {

	final Logger logger = Log.getLoggerData(this.getClass().getName());

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution has started for : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test execution has passed for : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test execution failed and taking screen shot: " + result.getName());
		// System.out.println("Calling Screenshot");
		Utils.takeScreenShot(result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test execution has skipped for : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
