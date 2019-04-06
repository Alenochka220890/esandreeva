package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.alena.addressbook.tests.model.ContactData;
import ru.stqa.alena.addressbook.tests.model.Contacts;
import ru.stqa.alena.addressbook.tests.model.Groups;

import java.util.ArrayList;
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

  public int getContactCount() {
    return wd.findElements(By.xpath("(//img[@alt='Edit'])")).size();
  }

  private Contacts contactCache = null;

    public Contacts all() {
      if (contactCache != null) {
        return new Contacts(contactCache);
      }
      contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements)
    {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String surname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withSurname(surname));
    }
      return new Contacts(contactCache);
  }


}
