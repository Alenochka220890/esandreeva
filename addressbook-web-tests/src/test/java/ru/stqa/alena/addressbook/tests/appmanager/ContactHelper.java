package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactHelper extends HelperBase {
  public WebDriver wd;
  public boolean creation;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("nickname"), contactData.getNikname());
    type(By.name("mobile"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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

  protected By selectedModGroup() {
    return By.name("selected[]");
  }

  public void fillContactForm(ContactData contactData) {
  }

  public void createAContact(ContactData contact) {
    fillContactForm(contact);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//img[@alt='Edit'])"));
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }

  }
}

