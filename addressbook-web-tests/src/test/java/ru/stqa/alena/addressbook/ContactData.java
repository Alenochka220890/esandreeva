package ru.stqa.alena.addressbook;

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
}
