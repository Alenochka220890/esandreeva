package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().homePagetContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactPage();
    ContactData contact = new ContactData("Yuriy", "Andreev", null, null, null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().homePagetContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}