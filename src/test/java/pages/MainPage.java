package pages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;
import static utils.ActionsHelper.defaultWait;
import static utils.ActionsHelper.scrollToTheTop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class MainPage {

  private final SelenideElement firstAddedItem = $("[data-test-id='ads-list-item-0']");
  private final SelenideElement firstAddedItemIcon = $("[data-test-id='ads-list-item-0'] a");
  private final SelenideElement cabinetLogo = $("[data-sentry-component='CabinetDropdown']");
  private final SelenideElement cabinetAddsButton = $("[data-test-id='cabinet-ads']");
  private final SelenideElement deleteCheckedItemsButton = $("[data-test-id='multiactions-delete']");
  private final SelenideElement deleteButton = $x(" //footer/button[text() ='Ştergere']");
//  private final SelenideElement cabinetSettingsIcon = $(" [class*='cabinet__settings__icon']");
//  private final SelenideElement cabinetSettingsEditButton = $(" [data-test-id='ads-settings-edit']");
//  private final SelenideElement cabinetSettingsYesButton = $x(" //button[text() ='Da']");
  private final SelenideElement notifications = $("[data-test-id='nav-chat']");
  private final SelenideElement notificationsCount = $("[data-test-id='nav-chat'] span");
  private final SelenideElement topItem = $("[class*='styles_ads']");
  private final SelenideElement editAdButton = $("[data-test-id='multiactions-edit']");

  public SelenideElement getItem(String itemName) {
    return $x("//a[text() ='" + itemName + "']");
  }

  public ElementsCollection sameItemsCheckbox(String itemName) {
    return $$x("//a[contains(text(), '" + itemName +"')]/../../..//input[@type ='checkbox']");
  }

  public void getAddForm() {
    firstAddedItemIcon.click();
    editAdButton.click();
  }

  public void checkNotifications(Object user) {
    System.out.println("========================");
    System.out.println("---> Data for " + user);
    notifications.shouldBe(visible);
    takeScreenShot(notifications);

    defaultWait(5000);
    if (!notificationsCount.exists()) {
      System.out.println("Notifications = 0");
    } else {
      System.out.println("-------------------------------------------> There are notifications for " + user + "\nNotifications = " + parseInt(
          notificationsCount.text()));
    }
    System.out.println("========================\n");
  }
}
