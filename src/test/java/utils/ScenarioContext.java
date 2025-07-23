package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ScenarioContext {

  public static final ScenarioContext INSTANCE = new ScenarioContext();
  private Map<DataEnum, Object> context;

  private ScenarioContext() {
    this.context = new HashMap<DataEnum, Object>();
  }

  public static ScenarioContext getScenarioContext() {
    return INSTANCE;
  }

  public void saveData(DataEnum key, Object data) {
    context.put(key, data);
  }

  public <T> T getData(DataEnum key) {
    if (!context.containsKey(key)) {
      throw new NoSuchElementException("Key does not exist");
    }
    return (T) context.get(key);
  }
}
