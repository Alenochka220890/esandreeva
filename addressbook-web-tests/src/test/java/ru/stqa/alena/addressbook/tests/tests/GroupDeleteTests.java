package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage();
    app.selectGroup();
    app.deleteGroup();
    returnToGroupPage();
  }

  public void returnToGroupPage() {
    app.returnToGroupPage();
  }

  public void gotoGroupPage() {
    app.gotoGroupPage();
  }


  public boolean isElementPresent(By by) {
    return app.isElementPresent(by);
  }

  }


