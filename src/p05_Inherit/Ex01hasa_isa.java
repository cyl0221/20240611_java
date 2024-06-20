package p05_Inherit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex01hasa_isa {
  public static void main(String[] args) {

  Child child = new Child();
    System.out.println(child.familyName);
    Parent parent = new Parent();
    System.out.println(parent.familyName);
    Car car = new Car();
    System.out.println(car.engine);
    Engine engine = new Engine();
    System.out.println(engine);
  }
}
// has-a 관계 : car는 engine은 공통된 속성과 기능을 공유하지 않는다
class Car {
  Engine engine = new Engine(); } // has a 관계
class Engine { int gitong;}

  // is a(상속) 관계 : parent 와 child 는 공통된 속성과 기능을 공유한다.
class Parent { String familyName;}
class Child extends Parent{  }
