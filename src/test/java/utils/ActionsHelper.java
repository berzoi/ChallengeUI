package utils;


import static com.codeborne.selenide.Selenide.actions;
import org.openqa.selenium.Keys;
import pages.BasePage;
import pages.MainPage;

public class ActionsHelper {

  public void navigateTo(String url) {
    new BasePage(url);
  }

  public static void defaultWait(int timeToWait) {
    try {
      Thread.sleep(timeToWait);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void scrollToTheTop() {
    new MainPage().getTopItem().click();
    actions().sendKeys(Keys.HOME).perform();
  }
}