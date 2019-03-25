package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public final SessionHelper sessionHelper = new SessionHelper();
  public final String browser;
  public NavigationHelper navigationHelper;
  public ContactHelper contactHelper;
  public GroupHelper groupHelper;

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

    sessionHelper.wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    sessionHelper.login("admin", "secret");
    contactHelper = new ContactHelper(sessionHelper.wd);
    groupHelper = new GroupHelper(sessionHelper.wd);
    navigationHelper = new NavigationHelper(sessionHelper.wd);
  }

  public boolean isElementPresent(By by) {
    try {
      sessionHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException ex) {
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

