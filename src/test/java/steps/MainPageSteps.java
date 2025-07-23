package steps;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static utils.ActionsHelper.scrollToTheTop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AdPage;
import pages.MainPage;

public class MainPageSteps {

  AdPage adPage = new AdPage();
  MainPage mainPage = new MainPage();


  @Then("the main page is opened")
  public void theMainPageIsOpened() {
    adPage.saveToDraft();

  }

  @And("the draft {string} item is displayed")
  public void theDraftItemIsDisplayed(String itemName) {
    mainPage.getCabinetLogo().hover();
    mainPage.getCabinetAddsButton().click();
    mainPage.getFirstAddedItem().shouldHave(text(itemName));
  }

  @Then("the user removes the draft {string} items")
  public void theUserRemovesTheDraftItems(String itemName) {
    ElementsCollection itemsCheckbox = mainPage.sameItemsCheckbox(itemName);
    scrollToTheTop();
    for (SelenideElement checkbox : itemsCheckbox) {
      checkbox.click();
    }
    scrollToTheTop();
    mainPage.getDeleteCheckedItemsButton().scrollTo().click();
    mainPage.getDeleteButton().scrollTo().click();

  }

  @And("User is checking no {string} are displayed")
  public void userIsChecksNoAreDisplayed(String itemName) {
    mainPage.getItem(itemName).shouldNot(Condition.visible);
  }

  @Then("the user is editing the title of the draft {string} item to {string}")
  public void theUserIsEditingTheTitleOfTheDraftItemTo(String oldTitle, String newTitle) {
    mainPage.getAddForm();
    adPage.editTitle(newTitle);

    scrollToTheTop();

    adPage.getTitleField().shouldNotHave(attribute("value", oldTitle));
    adPage.getTitleField().shouldHave(attribute("value", newTitle));

    adPage.submitEditedForm();
    adPage.getTitleField().shouldHave(text(newTitle));

    adPage.getSuccessEditMessage().shouldBe(Condition.visible);
    adPage.getSuccessEditMessage().shouldHave(text("Anunțul a fost editat cu succes"));

  }
}
