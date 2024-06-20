package p05_Inherit;

import java.sql.SQLOutput;

// 객체의 확장
public class Ex02Object {
  public static void main(String[] args) {
  /*Foo foo = new Foo();*/
    Member m1 = new Member("LGH","010-3446-7374");
  String str = new String("hello");
    /*System.out.println(foo);*/
    System.out.println(str);
    System.out.println(m1);
    System.out.println(m1 instanceof Object);
    System.out.println(m1 instanceof Member); //instanceof  상속 관계인지 아닌지 확인해 볼 수 있다.
    /*System.out.println(m1 instanceof String);*/ //오류
  }
}
/*class Foo{
  // Object 메서드는 9가지

// tos.. 이렇게 검색하면 아래 내용이 자동으로 입력된다.
  @Override
  public String toString() {
    return "Foo"; //super는 조상 인 object를 가르킨다.
  }
}*/

//모든 클래스는 Object 를 상속받는다. extend object는 안써도됨

class Member extends Object {
  String name, mobile; // string을 따로 주지않고 옆에처럼 같이 쓰기도 한다.

  public Member(String name, String mobile) {
    this.name = name;
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return String.format(
        "%s , %s", name, mobile
    );
  }
}

class Phone{}
class Computer{}
/*class SmartPhone extends Phone, Computer{}
// 오류 자바는 다중상속을 허용하지 않음 /자바의 특성(명확한특성)때문에//*/

