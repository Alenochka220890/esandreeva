package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().homePagetContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactPage();
    ContactData contact = new ContactData("Yuriy", "Andreev", null, "+79999991122", null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().homePagetContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}