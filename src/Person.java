/**
 * Person.java
 *
 * A person super class for all the people (i.e. Student and Teacher)
 *
 * @author axu5 <github.com/axu5>
 * @version 16.02.2022
 */
public class Person {
  private String name;
  private String address;

  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String toString() {
    return this.name + " (" + this.address + ")";
  }
}