package p01_class;


  /*
  클래스 선언할 경우
  1) 멤버변수와 메서드가 없어도 클래스를 선언가능.
  2) 멤버변수와 메서드를 정의하려고 하면 반드시 클래스를 선언.
  3) 파일명과 일치하는 클래스에만 public 사용가능.
  4) 클래스를 사용하려면 인스턴스로 만들어야 한다.
  5) 클래스는 new를 통해 인스턴스를 생성할 수 있다.
  */
  public class Animal {
  public int legs;
  String color;

  public void run() {
    System.out.println(legs);
  }
}