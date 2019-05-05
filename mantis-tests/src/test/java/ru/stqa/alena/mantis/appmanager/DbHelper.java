package ru.stqa.alena.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.alena.mantis.model.UserData;
import ru.stqa.alena.mantis.model.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;
  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

  }

  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from User where access_level = '25'").list();
    for (UserData user : result) {
      System.out.println(user);
    }
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

  public UserData getUserById(int id){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    UserData user  = (UserData) session.createQuery(   // new ContactGeneral().withId(id)
            "from User where id = '" + id +"'").uniqueResult();

    session.getTransaction().commit();
    session.close();
    return user;
  }
  public UserData getAdmin(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    UserData user  = (UserData) session.createQuery(   // new ContactGeneral().withId(id)
            "from User where access_level = '90'").uniqueResult();

    session.getTransaction().commit();
    session.close();
    return user;
  }
}

