package utils;

import static com.codeborne.selenide.Selenide.screenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class StepHooks {

  @AfterStep
  public void afterStep(Scenario scenario) {
    screenshot("Step_" + scenario.getName().replaceAll(" ", "_"));
  }
}
