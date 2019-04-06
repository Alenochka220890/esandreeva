package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePagetContact();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Yuriy", "Andreev", null, null, null));
    }
  }
  @Test
  public void testContactDelete() throws Exception {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);

    Assert.assertEquals(before, after);
  }

}