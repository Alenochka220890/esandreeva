package ru.stqa.alena.mantis.appmanager;

import org.openqa.selenium.WebDriver;

import static ru.stqa.alena.mantis.tests.TestBase.app;

public class RegistrationHelper {
  private final ApplicationManager app;
  private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    this.app = app;
    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
  }
}
