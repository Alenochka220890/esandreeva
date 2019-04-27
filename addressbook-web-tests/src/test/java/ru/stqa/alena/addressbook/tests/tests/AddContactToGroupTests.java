package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Groups;

public class AddContactToGroupTests extends TestBase{

@Test
        public void testAddContactToGroup(){
  Groups groups = app.db().groups();
  ContactData newContact = new ContactData().withFirstname("test_name")
          .withLastname("test_surname").inGroup(groups.iterator().next());
  app.contact().fillContactForm(newContact, true);


}

}



