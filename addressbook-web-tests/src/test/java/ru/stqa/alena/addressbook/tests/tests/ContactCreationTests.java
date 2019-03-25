package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Yuriy", "Andreev", null, "+79999991122", null));
    app.getContactHelper().submitContactCreation();


  }


  public void gotoContactPage() {
    gotoContactPage();}
}
