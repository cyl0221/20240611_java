package p05_Inherit;

public class Ex03extends {
  public static void main(String[] args) {
    //Unit unit = new Unit(); // 밑에 abstract를 사용하면 사용하지 못한다 에러
    Marine m1 = new Marine();
    System.out.println(m1.hp);
    Medic medic = new Medic();
    System.out.println(medic);

  }

}

abstract class Unit { /// 추상적인 class
  public Unit(String tribe, int hp) {
    super();
    this.tribe = tribe;
    this.hp = hp;
  }

  int hp;
   String tribe;
  public void move(int x, int y){}
  public void stop(){}

  @Override
  public String toString() {
    return String.format("Unit{hp=%d, tribe=%s}",hp,tribe);
  }
}
abstract class Terran extends  Unit{  // 상속할때 extends 를 사용한다
  // 상속할 경우에는 Member변수와 method만 상속 // 생성자는 상속이 안된다.
  public Terran(int hp) {
    //super <= (생략되어있음)// 내가 상속받을 클래스를 가르킴(조상의 생성자)
    super("Terran",hp);
  }
}
class Marine extends Terran {
  public Marine() {
    super(60);
  }
}
class  Medic extends Terran{
  public Medic() {
    super(45);
  }
}

