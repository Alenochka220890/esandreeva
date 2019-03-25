package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class ContactDeleteTests extends TestBase{
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    if (! app.getContactHelper().isThereAcontact()){
      app.getContactHelper().createConact(new ContactData("Yuriy", "Andreev", null, "+79999991122", null));
    }
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
  }
}
