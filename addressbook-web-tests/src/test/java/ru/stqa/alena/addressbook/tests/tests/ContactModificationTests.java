package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getContactHelper().homePagetContact();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContact();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Yuriy", "Andreev", null, null, null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().selectContactModification();
    app.getContactHelper().homePagetContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}