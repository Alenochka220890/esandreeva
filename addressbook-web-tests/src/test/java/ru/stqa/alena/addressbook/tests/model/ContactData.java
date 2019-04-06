package ru.stqa.alena.addressbook.tests.model;

import java.util.Objects;

public class ContactData {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String name;
  private final String surname;
  private final String nikname;
  private final String phone;
  private final String email;



  @Override
  public int hashCode() {
    return Objects.hash(name, surname);
  }

  public ContactData(String name, String surname, String nikname, String phone, String email) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.surname = surname;
    this.nikname = nikname;
    this.phone = phone;
    this.email = email;
  }

  public ContactData(int id, String name, String surname, String nikname, String phone, String email) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.nikname = nikname;
    this.phone = phone;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getNikname() {
    return nikname;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }
}
