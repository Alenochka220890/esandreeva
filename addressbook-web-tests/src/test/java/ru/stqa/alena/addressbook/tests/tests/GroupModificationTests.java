package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
