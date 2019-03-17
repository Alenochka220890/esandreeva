package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
      app.getContactHelper().homePagetContact();
      app.getContactHelper().submitContact();
      app.getContactHelper().fillContactForm(new ContactData("Yuriy", "Andreev", "Yura", null, "yurikk170187@yandex.ru"));
      app.getContactHelper().selectContactModification();
    }
}
