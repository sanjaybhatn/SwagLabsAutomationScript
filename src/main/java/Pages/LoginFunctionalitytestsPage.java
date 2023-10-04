package Pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.BasePage;

public class LoginFunctionalitytestsPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public LoginFunctionalitytestsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='login_logo']")
	private WebElement homePageLogo;
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement usernameTextFieldLocator;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextFieldLocator;
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginButtonLocotor;
	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement homePageTextLogo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement menuFieldLocator;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutButtonLocator;
	@FindBy(xpath = "//button[@id='react-burger-cross-btn']")
	private WebElement menuCloseButtonLocator;
	@FindBy(xpath = "//img[@src='/images/logo.svg']")
	private WebElement aboutOptionLogo;
	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	private WebElement signInButtonLocator;

	// Entering webSite Url
	public void enterURl(String url) {
		driver.get(url);

	}

	// Valiadting Page Title
	public void validateHomePage(String pageTitle) {
		wait.until(ExpectedConditions.visibilityOf(homePageLogo));
		if (homePageLogo.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		String actualTitle = driver.getTitle();
		if (pageTitle.equals(actualTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// Entering Username
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernameTextFieldLocator));
		usernameTextFieldLocator.sendKeys(username);
	}

	// Entering Password
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordTextFieldLocator));
		passwordTextFieldLocator.sendKeys(password);
	}

	// Clicking on login Button
	public void clickOnLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButtonLocotor));
		loginButtonLocotor.click();
	}

	// Validating user successfully logged in
	public void validateUserIsinHomePage() {
		wait.until(ExpectedConditions.visibilityOf(homePageTextLogo));
		Assert.assertEquals(true, homePageTextLogo.isDisplayed());
	}

	// Clicking On menu
	public void clickOnMenu() {
		wait.until(ExpectedConditions.visibilityOf(menuFieldLocator));
		menuFieldLocator.click();

	}

	// Clicking on Logout link
	public void clickOnLogout() {
		wait.until(ExpectedConditions.visibilityOf(logoutButtonLocator));
		logoutButtonLocator.click();
	}

	// Clicking on Menu Close Button
	public void clickOnMenuCloseButton() {

		wait.until(ExpectedConditions.visibilityOf(menuCloseButtonLocator));
		logoutButtonLocator.click();

	}

	// Validating all option are visible in Menu
	public void validateOptionIsAvailableInMenu(String option) {
		wait.until(ExpectedConditions.visibilityOf(menuCloseButtonLocator));
		WebElement option_Menu = driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
		Assert.assertEquals(true, option_Menu.isDisplayed());

	}

	// Clicking on Menu Options
	public void ClickOnOption(String option) {
		wait.until(ExpectedConditions.visibilityOf(menuCloseButtonLocator));
		WebElement option_Menu = driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
		option_Menu.click();

	}

	// Validating About Page
	public void validatetheAboutPage() {
		wait.until(ExpectedConditions.visibilityOf(signInButtonLocator));
		Assert.assertEquals(true, signInButtonLocator.isDisplayed());
		System.out.println(driver.getTitle());
		String expectedTitle = driver.getTitle();
		String actualTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
		Assert.assertEquals(true, expectedTitle.equals(actualTitle));

	}

}
