package ru.stqa.alena.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.TestBase;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();

  }

}








