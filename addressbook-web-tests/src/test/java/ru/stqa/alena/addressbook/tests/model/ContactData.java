package ru.stqa.alena.addressbook.tests.model;

import java.util.Objects;

public class ContactData {
  private final String name;
  private final String surname;
  private final String nikname;
  private final String phone;
  private final String email;

  public ContactData(String name, String surname, String nikname, String phone, String email) {
    this.name = name;
    this.surname = surname;
    this.nikname = nikname;
    this.phone = phone;
    this.email = email;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname) &&
            Objects.equals(phone, that.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, phone);
  }
}
