package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);


  }

  public SessionHelper() {
    super();
  }

  public void login(String username, String password) {
    wd.get("http://localhost/addressbook/group.php");
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.xpath("//input[@value='Login']"));
  }

  protected By selectedModGroup() {
    return By.name("selected[]");
  }
}
