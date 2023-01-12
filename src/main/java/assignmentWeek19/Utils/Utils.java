package assignmentWeek19.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import assignmentWeek17.Base.TestBase;

public class Utils extends TestBase {

	public static int getRandominteger(int length) {

		Random random = new Random();
		return random.nextInt(length);// whatever the length we want we can pass in the arguments
	}

	public static String getRandomString(int length) {
		// Random random=new Random(); //we donot need after importing the randomUtil
		// class from apache commons
		// get random utils from apache commons and artifact Id commons.lang3
		return RandomStringUtils.random(length); // returns the random string whose length is number of charcater
	}

	public static String getRandomEmail() {
		String suffix = RandomStringUtils.random(5);
		return "testemail_" + suffix + "@gmail.com";// will generate a random email of length 5
	}

	public static String getRandomPassword() {
		return "Password" + new Random().nextInt(2);
	}

	public static Date getCurrentTime() {
		return new Date();
	}

	public static void sleep(long timer) {
		try {
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void takeScreenShot(String testName) {
		// this format will give the current time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// wrap our driver with take screenshot interface
		// there is a method called get screenshot
		// and the type of out we want,we need to pass that type of output in the
		// arguments
		// can be FILE or BASE.64
		// save it in ref var of type File because getscreenshot File return type

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// screenshot taken
		// need to copy and paste in some location
		try {
			// copy the file(source and destination)
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestScreenShots\\" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
		}
	}

}
