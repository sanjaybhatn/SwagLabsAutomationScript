package testscases;

import org.testng.annotations.Test;

import Pages.LoginFunctionalitytestsPage;
import Pages.ProductCartFunctionalitytestsPage;
import factoryManager.PageinstancesFactory;

public class ProductCartFunctionalityTests extends BaseTest {

	@Test(testName = "TC 06 Validate Product Page Item Filter Functionality")
	public void validateAllOptionsInMenuAreVisibleFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.applyFilterandvalidate("Name (Z to A)");
		productPageFunction.validateFirstItem("Test.allTheThings() T-Shirt (Red)");
		productPageFunction.applyFilterandvalidate("Name (A to Z)");
		productPageFunction.validateFirstItem("Sauce Labs Backpack");
		productPageFunction.applyFilterandvalidate("Price (low to high)");
		productPageFunction.validateFirstItem("Sauce Labs Onesie");
		productPageFunction.applyFilterandvalidate("Price (high to low)");
		productPageFunction.validateFirstItem("Sauce Labs Fleece Jacket");

	}

	@Test(testName = "TC 07 Validate Product Page Item Adding to the cart functionality")
	public void validateProductPageItemAddingToTheCartFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");

	}

	@Test(testName = "TC 08 Validate Cart Page Item removing from the cart functionality")
	public void validateCartPageItemRemovingFromTheCartFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.removeFromCart("sauce-labs-backpack");
		productPageFunction.removeFromCart("sauce-labs-bike-light");

	}

	@Test(testName = "TC 09 Validate Cart Page Continue Shopping functionality")
	public void validateCartPageContinueShoppingfunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.clickOnContinueShopping();
		loginFunction.validateUserIsinHomePage();
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.removeFromCart("sauce-labs-backpack");
		productPageFunction.removeFromCart("sauce-labs-bike-light");

	}

	@Test(testName = "TC 10 Validate Cart Page Checkout functionality")
	public void ValidateCartPageCheckoutFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.enterZipCode(test.getProperty("zipcode"));
		productPageFunction.clickOnContinue();

	}

	@Test(testName = "TC 11 Validate Cart Page Checkout error message functionality")
	public void ValidateCartPageCheckoutErrorMessageFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.clickOnContinue();
		productPageFunction.ValidateErrorMessage();
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.ValidateErrorMessage();
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.ValidateErrorMessage();

	}

	@Test(testName = "TC 12 Validate Cart Page cancel button functionality")
	public void ValidateCartPageCancelButtonFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.enterZipCode(test.getProperty("zipcode"));
		productPageFunction.clickOnCancel();
		productPageFunction.validateUserIn("Your Cart");

	}
	@Test(testName = "TC 13 Validate CheckOut Overview Page functionality")
	public void ValidateCheckoutOverviewPageFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.enterZipCode(test.getProperty("zipcode"));
		productPageFunction.clickOnContinue();
		productPageFunction.validateUserIn("Checkout: Overview");
		productPageFunction.validateOverViewPageInfo("Payment Information");
		productPageFunction.validateOverViewPageInfo("Shipping Information");
		productPageFunction.validateOverViewPageInfo("Price Total");

	}

	@Test(testName = "TC 13 Validate CheckOut Overview Page Finish functionality")
	public void ValidateCheckoutOverviewPageFinishFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.enterZipCode(test.getProperty("zipcode"));
		productPageFunction.clickOnContinue();
		productPageFunction.validateUserIn("Checkout: Overview");
		productPageFunction.validateOverViewPageInfo("Payment Information");
		productPageFunction.validateOverViewPageInfo("Shipping Information");
		productPageFunction.validateOverViewPageInfo("Price Total");
		productPageFunction.clickOnFinishButton();
		productPageFunction.validateOrderSuccussMessage("Thank you for your order!");
		productPageFunction.clickOnBacktoHome();

	}
	

	@Test(testName = "TC 14 Validate order functionality")
	public void ValidateOrderFunctionality() throws Exception {
		LoginFunctionalitytestsPage loginFunction = PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		loginFunction.enterURl(test.getProperty("url"));
		loginFunction.validateHomePage("Swag Labs");
		loginFunction.enterUsername(test.getProperty("username"));
		loginFunction.enterPassword(test.getProperty("password"));
		loginFunction.clickOnLoginButton();
		loginFunction.validateUserIsinHomePage();
		ProductCartFunctionalitytestsPage productPageFunction = PageinstancesFactory
				.getInstance(ProductCartFunctionalitytestsPage.class);
		productPageFunction.addToCartProduct("sauce-labs-backpack");
		productPageFunction.addToCartProduct("sauce-labs-bike-light");
		productPageFunction.clickOnCartbutton();
		productPageFunction.validateUserIn("Your Cart");
		productPageFunction.validateProductAddedTocart("Sauce Labs Backpack");
		productPageFunction.validateProductAddedTocart("Sauce Labs Bike Light");
		productPageFunction.clickOnCheckout();
		productPageFunction.validateUserIn("Checkout: Your Information");
		productPageFunction.enterFirstName(test.getProperty("firstname"));
		productPageFunction.enterLastName(test.getProperty("lastname"));
		productPageFunction.enterZipCode(test.getProperty("zipcode"));
		productPageFunction.clickOnContinue();
		productPageFunction.validateUserIn("Checkout: Overview");
		productPageFunction.validateOverViewPageInfo("Payment Information");
		productPageFunction.validateOverViewPageInfo("Shipping Information");
		productPageFunction.validateOverViewPageInfo("Price Total");
		productPageFunction.clickOnFinishButton();
		productPageFunction.validateOrderSuccussMessage("Thank you for your order!");
		productPageFunction.clickOnBacktoHome();
		productPageFunction.validateUserIn("Products");
		


	}
}
