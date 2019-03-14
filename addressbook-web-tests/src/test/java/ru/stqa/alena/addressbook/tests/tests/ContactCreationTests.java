package ru.stqa.alena.addressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Yuriy", "Andreev", "Yura", "+79999991122", "yurikk170187@yandex.ru"));
    app.getContactHelper().submitContactCreation();


  }

  public boolean isElementPresent(By by) {
    return app.isElementPresent(by);
  }

}
