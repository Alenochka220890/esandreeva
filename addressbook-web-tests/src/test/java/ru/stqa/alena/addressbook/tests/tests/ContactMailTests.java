package ru.stqa.alena.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.alena.addressbook.tests.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactMailTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePagetContact();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Yuriy").withLastname("Andreev").withEmail("yurik@mail.ru")
              .withEmail2("alenka@gmail.com").withEmail3("bobo@ya.ru"),true);
    }
  }

  @Test
  public void testContactMails() {
    app.contact().homePagetContact();
    ContactData contact = app.contact().allMail().iterator().next();
    ContactData contactInfoFromEditFormMail = app.contact().infoFromEditFormMail(contact);

    assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditFormMail)));
  }

  private String mergeMails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactMailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String mail) {
    return mail.replaceAll("\\s", "").replaceAll("[-()]", "");

  }
}