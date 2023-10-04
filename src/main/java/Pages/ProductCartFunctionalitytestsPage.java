package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductCartFunctionalitytestsPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public ProductCartFunctionalitytestsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement filterDropLocator;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement shoppingCartLinkLocator;
	@FindBy(xpath = "//span[@class='title']")
	private WebElement pageNameLocator;
	@FindBy(xpath = "//button[@id='continue-shopping']")
	private WebElement continueShoppingLocator;
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkOutLocator;
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstNameField;
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement zipCodeField;
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancelButtonLocator;
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessageLocator;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButtonLocator;
	@FindBy(xpath = "//button[@id='finish']")
	private WebElement finishButton;
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement succussMessageLocator;
	@FindBy(xpath = "//button[@id='back-to-products']")
	private WebElement backToHomeLocator;

	// Validate Product Page filter Functionality
	public void applyFilterandvalidate(String value) {
		wait.until(ExpectedConditions.visibilityOf(filterDropLocator));
		Select sc = new Select(filterDropLocator);
		sc.selectByVisibleText(value);

	}

	// Validate first item is visible
	public void validateFirstItem(String value) {
		WebElement item = driver.findElement(By.xpath("//div[normalize-space()='" + value + "']"));
		Assert.assertEquals(true, item.isDisplayed());

	}

	// Clicking on add to cart button
	public void addToCartProduct(String item) {
		WebElement itemName = driver.findElement(By.xpath("//button[@id='add-to-cart-" + item + "']"));
		itemName.click();
	}

	// Clicking on Cart Button
	public void clickOnCartbutton() {
		wait.until(ExpectedConditions.visibilityOf(shoppingCartLinkLocator));
		shoppingCartLinkLocator.click();

	}

	// Validate Page Title
	public void validateUserIn(String pageName) {
		wait.until(ExpectedConditions.visibilityOf(pageNameLocator));
		String actualText = pageNameLocator.getText();
		Assert.assertEquals(true, actualText.equals(pageName));

	}

	// Validating item is added to cart
	public void validateProductAddedTocart(String name) {
		WebElement item = driver.findElement(By.xpath("//div[normalize-space()='" + name + "']"));
		Assert.assertEquals(true, item.isDisplayed());

	}

	// Validating Remove Item option
	public void removeFromCart(String item) {
		WebElement itemName = driver.findElement(By.xpath("//button[@id='remove-" + item + "']"));
		itemName.click();

	}

	// Clicking on Continue Button
	public void clickOnContinueShopping() {
		wait.until(ExpectedConditions.visibilityOf(continueShoppingLocator));
		continueShoppingLocator.click();

	}

	// Clicking on Checkout option
	public void clickOnCheckout() {
		wait.until(ExpectedConditions.visibilityOf(checkOutLocator));
		checkOutLocator.click();

	}

	// Entering First Name
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(firstNameField));
		firstNameField.sendKeys(firstName);

	}

	// Entering Last Name
	public void enterLastName(String lastname) {
		wait.until(ExpectedConditions.visibilityOf(lastNameField));
		lastNameField.sendKeys(lastname);

	}

	// Entering Zip Code
	public void enterZipCode(String code) {
		wait.until(ExpectedConditions.visibilityOf(zipCodeField));
		zipCodeField.sendKeys(code);

	}

	// Clicking on Cancel Button
	public void clickOnCancel() {
		wait.until(ExpectedConditions.visibilityOf(cancelButtonLocator));
		cancelButtonLocator.click();

	}

	// Clicking on Continue Button
	public void clickOnContinue() {
		wait.until(ExpectedConditions.visibilityOf(continueButtonLocator));
		continueButtonLocator.click();

	}

	// Validate OverView Information
	public void validateOverViewPageInfo(String message) {
		WebElement infoText = driver.findElement(By.xpath("//div[normalize-space()='" + message + "']"));
		Assert.assertEquals(true, infoText.isDisplayed());
	}

	// Clicking on Finish Button
	public void clickOnFinishButton() {
		wait.until(ExpectedConditions.visibilityOf(finishButton));
		finishButton.click();

	}

	// Validating order success Message
	public void validateOrderSuccussMessage(String expectedMessage) {
		wait.until(ExpectedConditions.visibilityOf(succussMessageLocator));
		String actualText = succussMessageLocator.getText();
		Assert.assertEquals(true, expectedMessage.equals(actualText));

	}

	// Clicking On back to home button
	public void clickOnBacktoHome() {
		wait.until(ExpectedConditions.visibilityOf(backToHomeLocator));
		backToHomeLocator.click();

	}
   //Validating Error Message
	public void ValidateErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessageLocator));
		Assert.assertEquals(true, errorMessageLocator.isDisplayed());
		
	}

}
