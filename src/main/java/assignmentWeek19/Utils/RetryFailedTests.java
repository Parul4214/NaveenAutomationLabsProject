package assignmentWeek19.Utils;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import assignmentWeek17.Base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {

	Logger log = Log.getLoggerData(this.getClass().getName());
	int testRunCounter = 0;
	int maxCounter = 2;

	@Override
	// whether want to retry the test case
	public boolean retry(ITestResult result) {

		if (testRunCounter < maxCounter) {
			testRunCounter++;
			log.info("Running a failed test " + testRunCounter + " times");
			return true;
		}

		return false;
	}

}
