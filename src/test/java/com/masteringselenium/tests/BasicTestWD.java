package com.masteringselenium.tests;

import com.masteringselenium.DriverFactory;
import com.masteringselenium.page_objects.pages.IndexPage;
import com.masteringselenium.page_objects.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory {

	private final String BASE_URL = CONFIGURATION.getBaseURL();
	private final String USER_ID = CONFIGURATION.getUserId();
	private final String USER_PASS = CONFIGURATION.getUserPassword();
	private LoginPage loginPage;
	private IndexPage indexPage;

	@BeforeTest
	private void setUp() {
		loginPage = new LoginPage(DriverFactory.getDriver(), BASE_URL);
	}

	@Test
	public void aUserLoginsWithValidCredentials() {
		loginPage.open() // instead of driver.get(BASE_URL);
				.enterEmail(USER_ID)
				.enterPassword(USER_PASS)
				.clickSubmitButton();

		indexPage = loginPage.getIndexPage();
		indexPage.open(); //throws exception
	}

	@Test
	public void loginFormIsVisibleWhenLoginPageIsOpened() {
		loginPage.open();
	}

	@Test
	public void userDirectoryIsNotOpenedIfLogedInWithInvalidEmail() {
		loginPage.open()
				.login("Test", USER_PASS);
	}

	@Test
	public void userDirectoryIsNotOpenedIfLogedInWithInvalidPassword() {
		loginPage.open()
				.login(USER_ID, "12345");
	}

	/*private static final String baseURL = //"http://automationpractice.com";

	private void searchOnIndexPage(String query) {

		WebDriver driver = DriverFactory.getDriver();

		driver.get(baseURL +"/index.php");

		WebElement searchField = driver.findElement(IndexPage.searchField);
		searchField.clear();
		searchField.sendKeys(query);
		searchField.submit();

		System.out.println("Page title is: " + driver.getTitle());

		new WebDriverWait(driver, 10)
				.until((ExpectedCondition<Boolean>) driverObject ->
						driverObject.getTitle().toLowerCase().startsWith("Search".toLowerCase()));
	}

	@Test
	public void indexPageSearchExample() {
		searchOnIndexPage("Blouse");
	}

	@Test
	public void loginExample() {
		SignInPage signInPage = new SignInPage();

		getDriver().get(baseURL + "/index.php?controller=authentication&back=my-account");
		signInPage.enterEmail("test@test.com")
				.enterPassword("12345");

		assertThat(signInPage.alertMessageIsNotDisplayed()).isTrue();

		signInPage.clickLoginButton();

		assertThat(signInPage.getAlertMessage(0).getText()).contains("Authentication failed.");
	}

	@Test
	public void testThatAboutPageHasButtonsInTheHeader() {
		getDriver().get(baseURL);

		indexPage = new IndexPage();
		assertThat(indexPage.headingButtonsAreDisplayed()).isTrue();
		assertThat(indexPage.menuButtonsAreDisplayed()).isTrue();

		aboutUsPage = indexPage.footer.goToAboutUsPage();
		assertThat(aboutUsPage.headingButtonsAreDisplayedOnAboutUsPage()).isTrue();
	}

	@Test
	public void testActions() throws Exception {
		getDriver().get(baseURL);

		//Actions does not chain waits
		Actions advancedActions = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), 5, 100);

		WebElement womenMenu = getDriver().findElement(By.cssSelector("#block_top_menu a[title='Women']"));
		WebElement blousesSubMenu = getDriver().findElement(By.cssSelector("a[title='Blouses']"));

		//hover
		advancedActions.moveToElement(womenMenu)
				.perform();

		wait.until(ExpectedConditions.visibilityOf(blousesSubMenu));

		advancedActions.moveToElement(blousesSubMenu)
				.click()
				.perform();

		new WebDriverWait(getDriver(), 10)
				.until((ExpectedCondition<Boolean>) driverObject ->
						driverObject.getTitle().toLowerCase().startsWith("Blouses".toLowerCase()));

		assertThat(getDriver().getTitle()).contains("Blouses");

//		//test for drag and drop
//		getDriver().get("https://html5demos.com/drag/");

//		WebElement boxTwo = getDriver().findElement(By.id("two"));
//		WebElement bin = getDriver().findElement(By.id("bin"));
//
//		//drag and drop (1px right, 1px down from the left corner of the element)
//		advancedActions.moveToElement(boxTwo, 1, 1)
//				.clickAndHold()
//				.moveToElement(bin)
//				.release()
//				.perform();
	}*/

}
