package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final SessionHelper sessionHelper = new SessionHelper();
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;

  public void init() {
    sessionHelper.wd = new FirefoxDriver();
    sessionHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    sessionHelper.login("admin", "secret");
    contactHelper = new ContactHelper(sessionHelper.wd);
    groupHelper = new GroupHelper(sessionHelper.wd);
    navigationHelper = new NavigationHelper(sessionHelper.wd);
  }

  public boolean isElementPresent(By by) {
    try {
      sessionHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      sessionHelper.wd.switchTo().alert();
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

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
