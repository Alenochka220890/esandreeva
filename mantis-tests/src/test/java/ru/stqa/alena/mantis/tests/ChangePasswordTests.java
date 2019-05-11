package ru.stqa.alena.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.alena.mantis.model.MailMessage;
import ru.stqa.alena.mantis.model.User;
import ru.stqa.alena.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class ChangePasswordTests extends  TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }


      @Test
      public void changePasswordTests () throws IOException, MessagingException {
        Users before = app.db().users();
        User modifyUser = before.iterator().next();
        User user = new User().withId(modifyUser.getId()).withUsername(modifyUser.getUsername())
                .withEmail(modifyUser.getEmail()).withPassword(modifyUser.getPassword()).withCod(modifyUser.getCod());
        long now = System.currentTimeMillis();
        String passwordNew = String.format("password%s", now);
        app.session().login();
        app.goTo().userManagement();
        app.registration().selectUserData(user);
        app.registration().changePassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 30000);
        String confirmationLink = app.mail().findChangingLink(mailMessages, modifyUser.getEmail());
        app.registration().finish(confirmationLink, passwordNew);
        assertTrue(app.newSession().login(modifyUser.getUsername(), passwordNew));
      }
      @AfterMethod(alwaysRun = true)
      public void stopMailServer(){
        app.mail().stop();
      }
    }

