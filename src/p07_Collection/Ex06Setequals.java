package p07_Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class Ex06Setequals {
  public static void main(String[] args) {
    Set set = new HashSet();
    set.add(new Person("LGH","user1"));
    set.add(new Person("LGH","user1"));
    System.out.println(set);

  }
}
class Person {
  String name, id;

  public String toString() {
    return String.format("Name=%s, Id=%s",name,id);
  }

  public Person(String name, String id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person p = (Person) obj;
      return name.equals(p.name) && id.equals(p.id);
    }
    return super.equals(obj);
  }
}
