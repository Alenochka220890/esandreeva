package ru.stqa.alena.mantis.tests;

import org.openqa.selenium.remote.BrowserType;


import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import ru.stqa.alena.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {


  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.IE));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    //app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    //app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    return !app.soap().getStatus(issueId).equals("closed");

  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}