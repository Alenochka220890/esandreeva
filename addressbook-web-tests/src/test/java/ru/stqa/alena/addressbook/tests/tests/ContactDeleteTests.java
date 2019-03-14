package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().homePagetContact();
    app.getContactHelper().submitContact();
    app.getContactHelper().submitDeleteContactCreation();
  }
}
