package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
   click(By.linkText("groups"));  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected By selectedModGroup() {
    return By.name("selected[]");
  }
}
