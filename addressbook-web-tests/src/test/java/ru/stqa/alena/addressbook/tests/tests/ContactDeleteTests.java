package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactDeleteTests extends TestBase{
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    if (!app.getContactHelper().isThereAContact()) {
      gotoContactPage();
      app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, "+79999991122", null));
    }
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
  }

  public void gotoContactPage() {
   return;
  }
}