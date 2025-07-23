package steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static utils.DataEnum.USER;
import static utils.ScenarioContext.getScenarioContext;

import com.codeborne.selenide.Selenide;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AdPage;
import pages.MainPage;
import pages.SignInPage;
import utils.ActionsHelper;

public class AdSteps {

  public static Boolean headlessBrowserTrueFalse;
  public static Boolean holdBrowserOpenTrueFalse;

  ActionsHelper actionsHelper = new ActionsHelper();
  AdPage adPage = new AdPage();
  SignInPage signInPage = new SignInPage();
  MainPage mainPage = new MainPage();

  @Given("Page {string} is opened")
  public void pageIsOpened(String url) {
    actionsHelper.navigateTo(url);
  }

  @Then("I open {string}")
  public void iOpen(String url) {
    Selenide.open(url);
  }

  @And("User enters Credentials to LogIn")
  public void userEntersCredentialsToLogIn(DataTable userTable) {
    var user = userTable.asMaps();
    var userName = user.getFirst().get("Username");
    var passWord = user.getFirst().get("Password");
    signInPage.performLogin(userName, passWord);
  }

  @Then("User selects {string} category")
  public void userSelectsCategory(String category) {
    adPage.getCategory(category);
  }

  @Then("User is adding the {string} advertisement")
  public void userIsAddingTheTiresAdvertisement(String itemName, DataTable userTable) {
    adPage.addCommercialAd(itemName, userTable);
  }

  @Given("The browser headless is {string}")
  public void theBrowserHeadlessIsTrue(String headless) {
    if (headless.equals("true")) {
      holdBrowserOpenTrueFalse = false;
      headlessBrowserTrueFalse = true;
    } else {
      holdBrowserOpenTrueFalse = true;
      headlessBrowserTrueFalse = false;
    }
  }

  @And("Submit button is {string}")
  public void submitButtonIsYes(String yesNo) {
    if (yesNo.equals("yes")) {
      adPage.getSubmitButton().click();
      adPage.getSuccessMessage().shouldBe(visible);
    }
    adPage.getSubmitButton().scrollTo();
  }

  @Then("Getting the number of notifications")
  public void getNumberOfNotifications() {
    var username = getScenarioContext().getData(USER);
    mainPage.checkNotifications(username);
  }

  @Then("the user skips the consent")
  public void theUserSkipsTheConsent() {
    adPage.skipConsent();
  }
}
