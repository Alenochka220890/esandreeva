package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final NavigationHelper navigationHelper = new NavigationHelper();
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;

  public void init() {
    navigationHelper.wd = new FirefoxDriver();
    navigationHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
    contactHelper = new ContactHelper(navigationHelper.wd);
    groupHelper = new GroupHelper(navigationHelper.wd);
  }

  public void login(String username, String password) {
    navigationHelper.wd.get("http://localhost/addressbook/group.php");
    navigationHelper.wd.findElement(By.name("user")).click();
    navigationHelper.wd.findElement(By.name("user")).clear();
    navigationHelper.wd.findElement(By.name("user")).sendKeys(username);
    navigationHelper.wd.findElement(By.name("pass")).clear();
    navigationHelper.wd.findElement(By.name("pass")).sendKeys(password);
    navigationHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public boolean isElementPresent(By by) {
    try {
      navigationHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      navigationHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {

    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
