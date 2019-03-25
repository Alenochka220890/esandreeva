package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.appmanager.ContactHelper;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
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


  }


