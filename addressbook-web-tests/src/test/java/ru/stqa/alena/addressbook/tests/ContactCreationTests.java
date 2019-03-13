package ru.stqa.alena.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    fillContactForm(new ContactData("Yuriy", "Andreev", "Yura", "+79999991122", "yurikk170187@yandex.ru"));
    submitContactCreation();


  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
