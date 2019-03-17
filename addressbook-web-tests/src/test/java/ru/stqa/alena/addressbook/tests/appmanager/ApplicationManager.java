package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final SessionHelper sessionHelper = new SessionHelper();
  private final String browser;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)){
      sessionHelper.wd = new FirefoxDriver();
    }else if (browser.equals(BrowserType.CHROME)) {
      sessionHelper.wd = new ChromeDriver();
    }else if (browser.equals(BrowserType.IE))
      sessionHelper.wd = new InternetExplorerDriver();

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
