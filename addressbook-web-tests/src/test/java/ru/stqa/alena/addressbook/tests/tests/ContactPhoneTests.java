package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePagetContact();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withHomePhone("11-11")
              .withMobilePhone("22 22").withWorkPhone("3(3)3"));
    }
  }
  @Test
  public void testContactPhones() {
    app.contact().homePagetContact();
    ContactData contact = app.contact().allPhone().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));

  }
  public String cleaned (String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}