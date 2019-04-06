package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().homePagetContact();
    List<ContactData> before = app.contact().list();
    app.goTo().contactPage();
    ContactData contact = new ContactData().withName("Yuriy").withSurname("Andreev");
    app.contact().fillContactForm(contact);
    app.contact().submitContactCreation();
    app.contact().homePagetContact();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}