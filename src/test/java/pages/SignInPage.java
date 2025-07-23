package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static utils.ActionsHelper.defaultWait;

import com.codeborne.selenide.SelenideElement;

public class SignInPage {

    private final SelenideElement emailField = $("[placeholder='Introduceți login sau e-mail']");
    private final SelenideElement passwordField = $("[placeholder='Introduceți cel puțin șase simboluri']");
    private final SelenideElement logInButton = $("[data-test-id='login']");
    private final SelenideElement submitButton = $("[type='submit']");
    private final SelenideElement submitButton2 = $("[data-sentry-component='Button']");
    private final SelenideElement exitButton = $("[class*='styles_exitButton']");
    private final SelenideElement recaptcha = $("[title='reCAPTCHA']");
    private final SelenideElement signButton = $("body > div > div > div > a > button");

    public void performLogin(String email, String password) {

        logInButton.click();
        if(exitButton.isDisplayed()) {
            exitButton.click();
        }
        defaultWait(5000);
        emailField.shouldBe(visible).setValue(email);
        passwordField.shouldBe(visible).setValue(password);
        submitButton.shouldBe(visible).click();

        signButton.shouldBe(visible).click();
    }
}
