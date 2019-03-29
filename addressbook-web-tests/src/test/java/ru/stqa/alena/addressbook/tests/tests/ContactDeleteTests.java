package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactDeleteTests extends TestBase {
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, "+79999991122", null));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}