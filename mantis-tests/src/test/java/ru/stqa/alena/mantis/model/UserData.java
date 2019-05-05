package ru.stqa.alena.mantis.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
@XStreamAlias("user")
public class UserData {
    @XStreamOmitField
    @Id
    private int id = Integer.MAX_VALUE;
    // @Expose
    @Column(name = "username")
    private String username;
    @Column(name = "realname")
    private String realname;
    @Column(name = "email")
    //@Type(type = "text")
    private String email1;
    @Column(name = "password")
    // @Type(type = "text")
    private String password;
    @Column(columnDefinition = "SMALLINT", name = "access_level")
    private String cod;

    public int getId() {
      return id;
    }
    public String getUsername() {
      return username;
    }
    public String getEmail() {
      return email1;
    }
    public String getPassword() {
      return password;
    }
    public String getCod(){return  cod;}

    public UserData withUsername(String username) {
      this.username = username;
      return this;
    }
    public UserData withId(int id) {
      this.id = id;
      return this;
    }
    public UserData withEmail(String email) {
      this.email1 = email;
      return this;
    }
    public UserData withPassword(String password) {
      this.password = password;
      return this;
    }
    public UserData withCod (String cod) {
      this.cod = cod;
      return  this;
    }

    @Override
    public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", email1='" + email1 + '\'' +
              ", password='" + password + '\'' +
              ", cod='" + cod + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserData user = (UserData) o;
      return id == user.id &&
              Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, username);
    }
  }

