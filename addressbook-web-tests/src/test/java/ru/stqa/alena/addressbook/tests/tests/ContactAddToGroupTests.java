package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;
import ru.stqa.alena.addressbook.tests.model.GroupData;
import ru.stqa.alena.addressbook.tests.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class ContactAddToGroupTests extends TestBase {

  @BeforeMethod

    public void ensurePreconditions() {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
      }

      if (app.db().contacts().size() == 0) {
        app.goTo().addContactPage();
        app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withEmail("yurik@mail.ru")
                , true);
      }
    }

    @Test
    public void testContactAddToGroup() {
      app.contact().homePagetContact();
      Contacts contactsFromDB = app.db().contacts();
      ContactData oneContact = contactsFromDB.iterator().next();
      Groups groupsFromBD = app.db().groups();
      GroupData oneGroup = groupsFromBD.iterator().next();
      app.contact().addToGroup(oneContact, oneGroup);
      app.db().refresh(oneContact);
      assertThat(oneContact.getGroups(), hasItem(oneGroup));

    }
  }

