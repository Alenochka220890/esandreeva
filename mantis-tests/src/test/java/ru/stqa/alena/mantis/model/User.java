package ru.stqa.alena.mantis.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("user")
@Entity
@Table(name = "mantis_user_table")
public class User {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "username")
    private String username;
    @Expose
    @Column(name = "realname")
    private String realname;
    @Expose
    @Column(name = "email")
    private String email;
    @Expose
    @Column(name = "password")
    private String password;
    @Expose
    @Column(columnDefinition = "SMALLINT", name = "access_level")
    private String cod;

    public int getId() {
      return id;
    }
    public String getUsername() {
      return username;
    }
    public String getEmail() {
      return email;
    }
    public String getPassword() {
      return password;
    }
    public String getCod(){return  cod;}

    public User withUsername(String username) {
      this.username = username;
      return this;
    }
    public User withId(int id) {
      this.id = id;
      return this;
    }
    public User withEmail(String email) {
      this.email = email;
      return this;
    }
    public User withPassword(String password) {
      this.password = password;
      return this;
    }
    public User withCod (String cod) {
      this.cod = cod;
      return  this;
    }

    @Override
    public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", email1='" + email + '\'' +
              ", password='" + password + '\'' +
              ", cod='" + cod + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, username);
    }
  }

