package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactDeleteTests extends TestBase{
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createAContact(new ContactData("Yuriy", "Andreev", null, "+79999991122", null, "test1", true));
    }
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
  }
}
