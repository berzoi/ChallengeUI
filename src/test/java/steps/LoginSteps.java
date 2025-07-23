package steps;

import static utils.DataEnum.USER;
import static utils.ScenarioContext.getScenarioContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AdPage;
import pages.SignInPage;

public class LoginSteps {

  AdPage adPage = new AdPage();

  SignInPage signInPage = new SignInPage();

  @And("User is logged in")
  public void userUserIsLoggedIn(String user) {

    switch (user) {
      case "brinkc" -> signInPage.performLogin("likahi4611@brinkc.com", "brinkc");
      case "brinkc2" -> signInPage.performLogin("brinkc2", "Thurmankovacek253$");

    }
    getScenarioContext().saveData(USER, user);
  }

  @Then("User is logging out")
  public void userIsLoggingOut() {
    adPage.performLogOut();
  }
}
