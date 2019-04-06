package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.getContactHelper().homePagetContact();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, null, null));
    }
  }
  @Test
  public void testContactDelete() throws Exception {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().delefyContact(index);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);

    Assert.assertEquals(before, after);
  }

}