package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("nickname"), contactData.getNikname());
    type(By.name("mobile"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());


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
  }
  public void modify(int index, ContactData contact) {
    selectContact(index);
    submitContact();
    fillContactForm(contact);
    selectContactModification();
    homePagetContact();
  }
  public void delete(int index) {
    selectContact(index);
    submitContact();
    submitDeleteContactCreation();
    homePagetContact();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//img[@alt='Edit'])"));
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("(//img[@alt='Edit'])")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements)
    {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String surname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withName(name).withSurname(surname));
    }
    return contacts;
  }
}
