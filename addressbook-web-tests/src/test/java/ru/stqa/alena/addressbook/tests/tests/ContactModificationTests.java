package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
      app.getContactHelper().homePagetContact();
      if (!app.getContactHelper().isThereAContact()) {
        gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Yuriy", "Andreev", null, "+79999991122", null));
      }
      app.getContactHelper().submitContact();
      app.getContactHelper().fillContactForm(new ContactData("Yuriy", "Andreev", "Yura", null, "yurikk170187@yandex.ru"));
      app.getContactHelper().selectContactModification();
    }
  public void gotoContactPage() {
    return;
}}
