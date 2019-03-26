package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.alena.addressbook.tests.appmanager.ApplicationManager;
import ru.stqa.alena.addressbook.tests.appmanager.NavigationHelper;

public class TestBase {

  public final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.getContactHelper().stop();
  }
}
