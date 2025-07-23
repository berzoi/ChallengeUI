package pages;

import static com.codeborne.selenide.Selenide.webdriver;
import static steps.AdSteps.headlessBrowserTrueFalse;
import static steps.AdSteps.holdBrowserOpenTrueFalse;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {

  public BasePage(String url) {
    Configuration.browser = "chrome";
    ChromeOptions options = new ChromeOptions();

    options.addArguments("--disable-extensions");
    options.addArguments("--incognito");

    Configuration.holdBrowserOpen = holdBrowserOpenTrueFalse;
    Configuration.headless = headlessBrowserTrueFalse;
    Configuration.timeout = 10000;
    Configuration.pageLoadStrategy = "eager";
    Selenide.open(url);
    webdriver().driver().getWebDriver().manage().window().maximize();
  }
}
