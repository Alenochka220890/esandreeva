package ru.stqa.alena.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePagetContact();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Yuriy", "Andreev", null, null, null));
    }
  }

  @Test
  public void testContactModification() throws Exception {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "Yuriy", "Andreev", null, null, null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
