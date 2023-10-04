package factoryManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReportManager {

	
	private static ExtentReports extentReports;


	private static Map<Long, ExtentTest> map = new HashMap<>();

	
	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports(ConstantsManager.REPORT_DIRECTORY);
			extentReports.assignProject(ConstantsManager.PROJECT_NAME);
			extentReports.loadConfig(new File(ConstantsManager.EXTENT_CONFIG_PATH));
		}
		return extentReports;
	}


	public synchronized static void startTest(String testName, String desc) {
		ExtentTest test = getExtentReports().startTest(testName, desc);
		map.put(Thread.currentThread().getId(), test);
	}

	public synchronized static ExtentTest getCurrentTest() {
		return map.get(Thread.currentThread().getId());
	}

	public synchronized static void endCurrentTest() {
		getExtentReports().endTest(getCurrentTest());
	}
}
