package ru.stqa.alena.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.stqa.alena.mantis.tests.TestBase.app;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);

  }

  public SessionHelper() {
    super();
  }

  public void login(String property, String propertiesProperty) {

    wd.get(app.getProperty("web.baseUrl") + "login_page.php");
    type(By.name("username"), app.getProperty("web.adminLogin")); //administrator
    click(By.xpath("//input[@value='Войти']"));
    type(By.name("password"), app.getProperty("web.adminPassword"));// root
    click(By.xpath("//input[@value='Войти']"));
  }
}
