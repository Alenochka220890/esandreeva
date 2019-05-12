package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;
import ru.stqa.alena.addressbook.tests.model.GroupData;
import ru.stqa.alena.addressbook.tests.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      Groups groups = app.db().groups();
      app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withEmail("yurik@mail.ru").
              inGroup(groups.iterator().next()), true);
    }

    Contacts contactsFromDB = app.db().contacts();
    Contacts contacts = new Contacts();
    for (ContactData contact : contactsFromDB) {
      if (contact.getGroups().size() > 0) {
        contacts.add(contact);
        if (contacts.size() > 0) {
          break;
        }
      }
    }
    if (contacts.size() == 0) {
      Groups groups = app.db().groups();
      app.contact().addToGroup(contactsFromDB.iterator().next(), groups.iterator().next());
    }
  }
  @Test
  public void testContactDeletionFromGroup() {
    app.contact().homePagetContact();;
    Groups groupsFromBD = app.db().groups();
    GroupData choosingGroup = new GroupData();
    for (GroupData group : groupsFromBD) {
      if (group.getContacts().size() > 0) {
        choosingGroup = group;
        break;
      }
    }
    app.goTo().groupFilter(choosingGroup);
    ContactData choosingContact = choosingGroup.getContacts().iterator().next();
    app.contact().removeContactFromGroup(choosingContact);
    app.db().refresh(choosingContact);
    assertThat(choosingContact.getGroups(), not(hasItem(choosingGroup)));
  }
}

