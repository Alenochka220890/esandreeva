package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
    app.getContactHelper().homePagetContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);

    Assert.assertEquals(before, after);
  }
}