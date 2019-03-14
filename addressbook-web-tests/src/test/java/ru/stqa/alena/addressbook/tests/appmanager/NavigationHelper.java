package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  public WebDriver wd;

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
