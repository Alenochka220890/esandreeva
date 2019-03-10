package ru.stqa.alena.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
  private WebDriver wd;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactCreationTests() throws Exception {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
    wd.findElement(By.linkText("add new")).click();
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Yuriy");
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Andreev");
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("Yura");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("+79999991122");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("yurikk170187@yandex.ru");
    wd.findElement(By.xpath("//input[21]")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();

    }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


    }

