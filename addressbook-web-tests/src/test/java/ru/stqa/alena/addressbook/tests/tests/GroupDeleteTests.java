package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage();
<<<<<<< HEAD
    if (! app.getGroupHelper().isThereAgroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
=======
>>>>>>> 606ecf9bc9e7ee035b60536ec676e92df3f61b96
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    returnToGroupPage();
  }

  public void returnToGroupPage() {
    app.getGroupHelper().returnToGroupPage();
  }

  public void gotoGroupPage() {
    app.getNavigationHelper().gotoGroupPage();
  }


  public boolean isElementPresent(By by) {
    return app.isElementPresent(by);
  }

  }


