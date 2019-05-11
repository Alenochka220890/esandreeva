package ru.stqa.alena.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.alena.mantis.model.User;


public class RegistrationHelper extends HelperBase{


  public RegistrationHelper(ApplicationManager app) {
    super(app);

  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
    click(By.cssSelector("input[type='submit']"));
    Wait<WebDriver> wait = new WebDriverWait(wd, 35);
    wait.until((ExpectedConditions.visibilityOf(wd.findElement(By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Продолжить']")))));

  }

  public void selectUserData(User user){
    click(By.linkText(user.getUsername()));
  }
  public void changePassword(){
    click(By.xpath("//input[@value='Сбросить пароль']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//button[@type='submit']"));
  }
}
