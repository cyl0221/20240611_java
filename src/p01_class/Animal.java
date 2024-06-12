package p01_class;


  /*
  클래스 선언할 경우
  1) 멤버변수와 메서드가 없어도 클래스를 선언가능.
  2) 멤버변수와 메서드를 정의하려고 하면 반드시 클래스를 선언.
  3) 파일명과 일치하는 클래스에만 public 사용가능.
  4) 클래스를 사용하려면 인스턴스로 만들어야 한다.
  5) 클래스는 new를 통해 인스턴스를 생성할 수 있다.

  Pascal식 법 ==> 단어를 연결할때 단어의 첫글자는 대문자
  ex) PersonSpec
  camel ==> 단어를 표기할 때 첫 문자는 소문자로 시작하며 띄어쓰기 대신 (대문자) 로 단어를 구분.
  ex) phoneNumber, createdAt, updatedAt
  Snake ==> 단어를 표기할 때 모두 소문자로 표기하며, 띄어쓰기 대신 ( _ ) 로 표기
  ex) phone_number, created_at, updated_at
  Upper ==> 단어의 첫글자만 대문자, Java Class 파일에서 사용
  ex) User, Customer, Intro

  - API : 주로 API통신 규격에서는 Snake Case를 많이 사용한다.
  - DB : Snake Case
  - Java : Camel Case, Class파일만 UpperCase

  명명규칙
  1)영문 대소 문자와 한글을 사용할 수 있다.
  - abc(O),ABC(O),aBc(O),가나다(O)
  2)특수 문자는 밑줄(_)과 달러($)표기만 사용이 가능하다.
  - $abc(O),_abc(O),ab_c(O),$abc_(O)
  3)아라비아 숫자를 사용할 수 있다. 단, 첫 번째 글자로는 사용할 수 없다.
  - a3bc(O),ab3c(O),abc3(O),3abc(X)
  4)자바에서 사용하는 예약어는 사용할 수 없다.
  - int(X),break(X),public(X),static(X) 등등

  */
public class Animal {
  public int legs;
  String color;

  public void run() {
    System.out.println(legs);
  }
    }
class foo {
  public static void main(String[] args) {
  };
}