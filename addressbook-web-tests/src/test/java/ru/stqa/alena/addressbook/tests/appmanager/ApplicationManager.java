package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public final SessionHelper sessionHelper = new SessionHelper();
  public final String browser;
  private final Properties properties;
  public NavigationHelper navigationHelper;
  public ContactHelper contactHelper;
  public GroupHelper groupHelper;
  private DbHelper dbHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new DbHelper();

    if (browser.equals(BrowserType.FIREFOX)) {
      sessionHelper.wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      sessionHelper.wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE))
      sessionHelper.wd = new InternetExplorerDriver();

    sessionHelper.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    sessionHelper.wd.get(properties.getProperty("web.baseUrl"));
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
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

  public GroupHelper group() {

    return groupHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public DbHelper db() {
    return dbHelper;
  }

  }

