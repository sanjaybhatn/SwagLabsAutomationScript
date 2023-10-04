package testscases;

import org.testng.annotations.Test;

import Pages.LoginFunctionalitytestsPage;
import factoryManager.*;

public class LoginFunctionalityTests extends BaseTest {

	@Test(testName = "TC 01 Log in Functionality Test")
	public void logInFunctionalityTest() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
	}

	@Test(testName = "TC 02 Log out Functionality Test")
	public void logOutFunctionalityTest() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		loginFunction.clickOnMenu();
		loginFunction.clickOnLogout();
		loginFunction.validateHomePage("Swag Labs");

	}

	@Test(testName = "TC 03 Validate Menu Closing Button Functionality")
	public void validateMenuClosingButtonFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		loginFunction.clickOnMenu();
		loginFunction.clickOnMenuCloseButton();

	}

	@Test(testName = "TC 04 Validate all options in Menu are visible Functionality")
	public void validateAllOptionsInMenuAreVisibleFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		loginFunction.clickOnMenu();
		loginFunction.validateOptionIsAvailableInMenu("All Items");
		loginFunction.validateOptionIsAvailableInMenu("About");
		loginFunction.validateOptionIsAvailableInMenu("Logout");
		loginFunction.validateOptionIsAvailableInMenu("Reset App State");

	}

	@Test(testName = "TC 05 Validate About Page is loading Functionality")
	public void validateAboutPageisLoadingFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		loginFunction.clickOnMenu();
		loginFunction.validateOptionIsAvailableInMenu("About");
		loginFunction.ClickOnOption("About");
		loginFunction.validatetheAboutPage();

	}
}