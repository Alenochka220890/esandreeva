package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.alena.addressbook.tests.model.ContactData;

public class ContactHelper extends HelperBase{
  public WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getSurname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNikname());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());


  }

  public void stop() {
    wd.quit();
  }

  public void submitContact() {
    wd.findElement(By.xpath("(//img[@alt='Edit'])[2]")).click();
  }

  public void submitDeleteContactCreation() {
    wd.findElement(By.xpath("(//input[@name='update'])[3]")).click();
  }

  public void homePagetContact() {
    wd.findElement(By.linkText("home")).click();
  }

  public void selectContactModification() {
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
  }
}
