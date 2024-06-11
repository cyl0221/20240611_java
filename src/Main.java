//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  int num1 = 10;
  int num2 = 20;
  int num3 = num1 + num2;

  void done() {
    System.out.println(num3);
    if (num1 < num2) {
      num3 = num1;
    } else {
      num3 = num2;
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.done();

  }
}
class Animal {
  int legs;
}
 /* 클래스(class) 선언할 경우
 1) 멤버변수와 메서드가 없어도 선언가능하다.
 2) 멤버변수와 메서드를 사용하려고 하면 반드시 클래스를 선언
 3) 파일명과 일치하는 클래스에만 public 사용가능
 4) 클래스를 사용하려면 인스턴스로 만들어야 한다.
 5) 클래스는 new를 통해 인스턴스를 생성할 수 있다. */


public class Main {

    }