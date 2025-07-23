package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Integer.parseInt;
import static utils.ActionsHelper.defaultWait;
import static utils.Constants.TAGS;
import static utils.Constants.LOGITECH_M170_TITLE;
import static utils.Constants.LOGITECH_M175_TITLE;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import java.io.File;
import java.util.List;
import lombok.Getter;
import utils.ActionsHelper;
import utils.ConfigReader;

@Getter
public class AdPage {

  ConfigReader configReader = new ConfigReader();
  ActionsHelper actionsHelper = new ActionsHelper();

  private final SelenideElement addAdButton = $("[id='js-add-ad']");
  private final SelenideElement author = $("[name='#795.value']");
  private final SelenideElement transportCategory = $("[href*='transport']");
  private final SelenideElement pcCategory = $("[href*='computers-and-office-equipment']");
  private final SelenideElement titleField = $("[name='#12.value.ro'], [name='#12.value.ru']");
  private final SelenideElement descriptionFiled = $("[name*='#13.value']");
  private final SelenideElement price = $("[name='#2.value.value']");
  private final SelenideElement type = $(
      "[name='#686.value'], [name='#724.value'], [name='1460'], [name='620'], [name='#1311.value'], [name='1397']" +
          ", [name='673'], [name='#1021.value'], [name='1297'], [name='#1330.value'], [name='#2245.value']");
  private final SelenideElement formFactor = $("[name='951']");
  private final SelenideElement brand = $("[name='632'], [name='672'], [name='1461'], [name='#691.value'], " +
      "[name='#723.value'], [name='693'], [name='722'], [name='#685.value'], [name='#589.value']");
  private final SelenideElement ssdCapacity = $("[name='950'], [name='677'], [name='872']");
  private final SelenideElement ssdInterface = $("[name='952']");
  private final SelenideElement uploadPictureButton = $("[id='upload-photo']");
  private final SelenideElement agreeButton = $("[id='agreement']");
  private final SelenideElement submitButton = $x("(//button[@type='submit']) [2]");
  private final SelenideElement successMessage = $("[class='success_icon']");
  private final SelenideElement memoryRom = $("[name='#678.value']");
  private final SelenideElement usedOrNew = $("[name='#593.value']");
  private final SelenideElement currencyType = $("[name='#2.value.unit']");
  private final SelenideElement tagField = $("[name*='#1404.value']");
  private final SelenideElement usernameButton = $("[data-sentry-component='CabinetDropdown']");
  private final SelenideElement logOutButton = $("[data-test-id='cabinet-exit']");
  private final SelenideElement socketType = $("[name='#960.value']");
  private final SelenideElement region = $("[name='#7.value']");
  private final SelenideElement phoneSwitcherChecker = $("[data-sentry-component='ChatBlock'] [data-test-status]");
  private final SelenideElement phoneCheckbox = $("input[id*='phone_']");
  private final SelenideElement phoneConfirmed = $("[class*='phone__body__confirmed']");
  private final SelenideElement model = $("[name='#2285.value']");
  private final SelenideElement destination = $("[name='#792.value']");
  private final SelenideElement ramFrequency = $("[name='959']");
  private final SelenideElement connectionType = $("[name='#962.value']");
  private final SelenideElement interfaceType = $("[name='#952.value']");
  private final SelenideElement moreSalesCloseButton = $("[class='introjs-tooltipbuttons'] a");
  private final SelenideElement tipDispozitiv = $("[name='#1331.value']");
  private final SelenideElement connectionInterface = $("[name='#1798.value']");
  private final SelenideElement skipConsentButton = $("button[class*='consent fc-primary-button']");
  private final SelenideElement consentDialog = $("div[class='fc-dialog fc-choice-dialog']");
  private final SelenideElement simpalsLogo = $("img[alt='999 Logo']");
  private final SelenideElement saveForLaterButton = $x("//button[text() =' Continuați mai târziu']");
  private final SelenideElement saveButtonFromEditView = $("[data-test-id='ad-form-submit']");
  private final SelenideElement successEditMessage = $("[data-sentry-component='SuccessPageNew']");

  public void performLogOut() {
    usernameButton.click();
    logOutButton.click();
  }

  public void getCategory(String category) {
    addAdButton.click();

    switch (category) {
      case "Transport" -> transportCategory.click();
      case "Computers" -> pcCategory.click();
      default -> throw new RuntimeException("Category not found");
    }
  }

  public void addCommercialAd(String itemName, DataTable userTable) {
    String priceText;
    List<String> filePaths;
    String filePath1;


    switch (itemName) {

      case "M170" -> {
        open(configReader.getProperty("mouseUrl"));
        moreSalesCloseButton.click();

        titleField.setValue(LOGITECH_M170_TITLE);
        tagField.setValue(TAGS);
        region.selectOptionByValue("12900");
        priceText = userTable.asMaps().getFirst().get("Price");
        price.setValue(priceText);
        currencyType.selectOptionByValue("UNIT_MDL");
        brand.selectOptionByValue("41581");
        usedOrNew.selectOptionByValue("6371");
        connectionType.selectOptionByValue("20820");

        filePath1 = "src/test/resources/Files/Mouse/M170.jpg";
        filePaths = List.of(filePath1);
        filePaths.forEach(filePath -> {
          uploadPictureButton.uploadFile(new File(filePath));
          defaultWait(1000);
        });
      }

      case "M175" -> {
        open(configReader.getProperty("mouseUrl"));
        moreSalesCloseButton.click();

        titleField.setValue(LOGITECH_M175_TITLE);
        tagField.setValue(TAGS);
        region.selectOptionByValue("12900");
        priceText = userTable.asMaps().getFirst().get("Price");
        price.setValue(priceText);
        currencyType.selectOptionByValue("UNIT_MDL");
        brand.selectOptionByValue("41581");
        usedOrNew.selectOptionByValue("6371");
        connectionType.selectOptionByValue("20820");

        filePath1 = "src/test/resources/Files/Mouse/M175.jpg";
        filePaths = List.of(filePath1);
        filePaths.forEach(filePath -> {
          uploadPictureButton.uploadFile(new File(filePath));
          defaultWait(1000);
        });
      }

    }
    defaultWait(2000);
  }

  public void skipConsent() {

    if (skipConsentButton.isDisplayed()) {
      skipConsentButton.scrollTo().click();
      consentDialog.shouldBe(disappear);
    }
  }

  public void saveToDraft() {
    simpalsLogo.scrollTo().click();
    saveForLaterButton.scrollTo().click();
  }

  public void editTitle(String newTitle) {
    titleField.scrollTo().setValue(newTitle);
  }

  public void submitEditedForm() {
    submitButton.click();
    saveButtonFromEditView.click();
  }
}