package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;
import ru.stqa.alena.addressbook.tests.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withFirstname("firstname 1").withLastname("lastname 1").withNikname("nickname 1")
            .withHomePhone("home 1").withMobilePhone("mobile 1").withWorkPhone("work 1").withEmail("email 1")
            .withEmail2("email2 1").withEmail3("email3 1")});
    list.add(new Object[]{new ContactData().withFirstname("firstname 2").withLastname("lastname 2").withNikname("nickname 2")
            .withHomePhone("home 2").withMobilePhone("mobile 2").withWorkPhone("work 2").withEmail("email 2")
            .withEmail2("email2 2").withEmail3("email3 2")});
    list.add(new Object[]{new ContactData().withFirstname("firstname 3").withLastname("lastname 3").withNikname("nickname 3")
            .withHomePhone("home 3").withMobilePhone("mobile 3").withWorkPhone("work 3").withEmail("email 3")
            .withEmail2("email2 3").withEmail3("email3 3")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
    app.contact().homePagetContact();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    File photo = new File("src/test/resources/1.jpg");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() throws Exception {
    app.contact().homePagetContact();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    ContactData contact = new ContactData().withFirstname("Yuriy'").withLastname("Andreev'");
    app.contact().create(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}