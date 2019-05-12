package ru.stqa.alena.addressbook.tests.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")

@XStreamAlias("contact")
public class ContactData {
  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  @Expose
  private String firstname;

  @Column(name = "lastname")
  @Expose
  private String lastname;

  @Column(name = "nickname")
  @Expose
  private String nikname;

  @Column(name = "home")
  @Type(type = "text")
  @Expose
  private String homePhone;

  @Column(name = "mobile")
  @Type(type = "text")
  @Expose
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  @Expose
  private String workPhone;

  @Transient
  @Expose
  private String allPhones;

  @Column(name = "email")
  @Type(type = "text")
  @Expose
  private String email;

  @Column(name = "email2")
  @Type(type = "text")
  @Expose
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  @Expose
  private String email3;

  @Transient
  @Expose
  private String allMails;



  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Column(name = "photo")
  @Type(type = "text")
  @Expose
  private String photo;


  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  private Set<GroupData> groups = new HashSet<GroupData>();

  public String getEmail2() {
    return email2;
  }

  public String getAllMails() {
    return allMails;
  }

  public ContactData setAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNikname() {
    return nikname;
  }

  public String getEmail() {
    return email;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public Set<GroupData> getGroups() {
    return new Groups(groups);
  }


    public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNikname(String nikname) {
    this.nikname = nikname;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  @Override
    public boolean equals (Object o){
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ContactData that = (ContactData) o;
      return id == that.id &&
              Objects.equals(firstname, that.firstname) &&
              Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode () {
      return Objects.hash(id, firstname, lastname);
    }
  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}

