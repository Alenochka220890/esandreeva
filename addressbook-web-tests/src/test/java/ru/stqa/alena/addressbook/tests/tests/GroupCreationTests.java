package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
<<<<<<< HEAD
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
=======
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

>>>>>>> 606ecf9bc9e7ee035b60536ec676e92df3f61b96
  }
}
