package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeleteTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePagetContact();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Yuriy").withSurname("Andreev"));
    }
  }
  @Test
  public void testContactDelete() throws Exception {

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);

    Assert.assertEquals(before, after);
  }

}