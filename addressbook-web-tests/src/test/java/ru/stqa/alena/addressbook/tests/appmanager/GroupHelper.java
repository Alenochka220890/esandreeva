package ru.stqa.alena.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.stqa.alena.addressbook.tests.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void deleteGroup() {
    click(By.xpath("(//input[@name='delete'])[2]"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }


  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

<<<<<<< HEAD
  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(new GroupData("test1", null, null));
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAgroup() {
    return isElementPresent(By.name("selected[]"));
  }
=======
  }

>>>>>>> 606ecf9bc9e7ee035b60536ec676e92df3f61b96

  private boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}