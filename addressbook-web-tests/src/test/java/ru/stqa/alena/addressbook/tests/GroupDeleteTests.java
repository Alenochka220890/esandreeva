package ru.stqa.alena.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }


  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  }


