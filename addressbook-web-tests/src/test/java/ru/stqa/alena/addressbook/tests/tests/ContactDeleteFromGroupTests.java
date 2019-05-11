package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;
import ru.stqa.alena.addressbook.tests.model.GroupData;
import ru.stqa.alena.addressbook.tests.model.Groups;

import static javax.management.Query.not;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    // 1) если  нет ни одной группы - создаём её
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }

    // 2) если  нет ни одного  контакта - создаём его
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      Groups groups = app.db().groups();
      app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withEmail("yurik@mail.ru").
              inGroup(groups.iterator().next()), true);
    }

    // 3) находим первый контакт, у которого есть группа, добавляем его в список контактов и выходим из цикла
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
    // 3.1) если список контактов с группами пуст, то добавляем контакт к группе
    if (contacts.size() == 0) {
      Groups groups = app.db().groups();
      app.contact().addToGroup(contactsFromDB.iterator().next(), groups.iterator().next());

    }

  }

  /**
   * Тест проверяем корректность удаления контакста из группы
   */
  @Test
  public void testContactDeletionFromGroup() {
    app.contact().homePagetContact();;

    logger.info("Формируется список контактов и групп");

    // ищем не пустую группу (в составе которой есть хотя бы один контакт)
    Groups groupsFromBD = app.db().groups();
    GroupData choosingGroup = new GroupData();
    for (GroupData group : groupsFromBD) {
      if (group.getContacts().size() > 0) {
        choosingGroup = group;
        break;
      }
    }
    // выбираем в фильтре наименование не пустой группы
    app.goTo().groupFilter(choosingGroup);

    // контакт вытаскиваем из группы
    ContactData choosingContact = choosingGroup.getContacts().iterator().next();

    logger.info("Уудаление контакта из группы");
    app.contact().removeContactFromGroup(choosingContact);

    app.db().refresh(choosingContact);

    logger.info("Проверка, что контакт успешно удалён из группы");
    assertThat(choosingContact.getGroups(), not(hasItem(choosingGroup)));
  }
}

