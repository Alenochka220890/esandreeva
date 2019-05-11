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
      // если  нет ни одной группы - создаём её
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
      }

      // если  нет ни одного  контакта - создаём его
      if (app.db().contacts().size() == 0) {
        app.goTo().addContactPage();
        //File photo = new File("src/test/resources/inner.jpg");

        app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withEmail("yurik@mail.ru")
                , true);
      }
    }


    /**
     * Тест проверяет корректность добавления контакта в групу
     */
    @Test
    public void testContactAddToGroup() {
      app.contact().homePagetContact();
      logger.info("Формируется список контактов и групп");
      Contacts contactsFromDB = app.db().contacts();
      ContactData oneContact = contactsFromDB.iterator().next();
      Groups groupsFromBD = app.db().groups();
      GroupData oneGroup = groupsFromBD.iterator().next();

      logger.info("Выбор контакта и добавление его к группе");
      app.contact().addToGroup(oneContact, oneGroup);
      app.db().refresh(oneContact);

      logger.info("Проверяем, что контакт успешно добавлен к группе");
      assertThat(oneContact.getGroups(), hasItem(oneGroup));

    }
  }

