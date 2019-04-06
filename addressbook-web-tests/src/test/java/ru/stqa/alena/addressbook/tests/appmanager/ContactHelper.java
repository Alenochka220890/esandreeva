package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNikname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    attach(By.name("photo"), contactData.getPhoto());
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void stop() {
    wd.quit();
  }

  public void submitContact() {
    click(By.xpath("(//img[@alt='Edit'])"));
  }

  public void submitDeleteContactCreation() {
    click(By.xpath("(//input[@name='update'])[3]"));
  }

  public void homePagetContact() {
    click(By.linkText("home"));
  }

  public void selectContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void gotoContactPage() {
    click(By.linkText("add new"));
  }

  public void create(ContactData contact) {
    gotoContactPage();
    fillContactForm(contact);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    submitContact();
    fillContactForm(contact);
    selectContactModification();
    contactCache = null;
    homePagetContact();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    submitContact();
    submitDeleteContactCreation();
    contactCache = null;
    homePagetContact();
  }


  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//img[@alt='Edit'])"));
  }

  public int count() {
    return wd.findElements(By.xpath("(//img[@alt='Edit'])")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String surname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(name).withLastname(surname));
    }
    return new Contacts(contactCache);
  }

  public Set<ContactData> allPhone() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones));
    }
    return contacts;

  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home)
            .withMobilePhone(mobile).withWorkPhone(work);
  }


  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }


  public Set<ContactData> allMail() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allMails = cells.get(4).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllMails(allMails));
    }
    return contacts;
  }

  public ContactData infoFromEditFormMail(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withEmail(email)
            .withEmail2(email2).withEmail3(email3);
  }
}