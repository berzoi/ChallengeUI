package utils;

import static com.codeborne.selenide.Selenide.screenshot;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class StepHooks {

  @BeforeStep
  public void beforeStep(Scenario scenario) {
    screenshot("Step_" + scenario.getName().replaceAll(" ", "_"));
  }
}
