package testscases;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import factoryManager.ObjectRepository;
import factoryManager.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.LogListener;
import listeners.ReportListener;
import util.LoggerUtil;

@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	protected WebDriver driver;
	public static Properties test;

	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Case Execution Started ************************************");
		ObjectRepository.loadAllPropertie();
	}

	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	@BeforeMethod
	protected void setup() throws Exception {
		test = ObjectRepository
				.ObjectRepo(System.getProperty("user.dir") + "//src//test//resources//configuration//test.properties");
		EdgeOptions ops = new EdgeOptions();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverManagerFactory.setDriver(driver);

	}

	@AfterMethod
	public void wrapUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
