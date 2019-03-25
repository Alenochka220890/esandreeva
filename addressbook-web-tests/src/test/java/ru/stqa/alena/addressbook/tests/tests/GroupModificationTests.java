package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
<<<<<<< HEAD
=======
    app.getGroupHelper().selectGroup();
>>>>>>> 606ecf9bc9e7ee035b60536ec676e92df3f61b96
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
