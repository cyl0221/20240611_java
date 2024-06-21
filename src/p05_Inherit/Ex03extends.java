package p05_Inherit;

public class Ex03extends {
  public static void main(String[] args) {
    //Unit unit = new Unit(); // 밑에 abstract를 사용하면 사용하지 못한다 에러
    Marine m1 = new Marine();
    System.out.println(m1);
    Medic medic = new Medic();
    System.out.println(medic);

  }

}

abstract class Unit { /// 추상적인 class
  public Unit(String tribe,String name, int hp) {
    super();
    this.tribe = tribe;
    this.name = name;
    this.hp = hp;


  }

  int hp;
  String tribe;
  String name;
  public void move(int x, int y){}
  public void stop(){}

  @Override
  public String toString() {
    return String.format("%s{tribe=%s name=%s, hp=%d }",name,tribe,name,hp);
  }
}
abstract class Protoss extends  Unit{  // 상속할때 extends 를 사용한다
  // 상속할 경우에는 Member변수와 method만 상속 // 생성자는 상속이 안된다.
  public Protoss(String name, int hp) {
    //super <= (생략되어있음)// 내가 상속받을 클래스를 가르킴(조상의 생성자)
    super("Protoss",name,hp);
  }
  // 추상클래스  스스로 인스턴스 생성불가, 상속받은 후 인스턴스 생성 가능
}abstract class Terran extends  Unit{  // 상속할때 extends 를 사용한다
  // 상속할 경우에는 Member변수와 method만 상속 // 생성자는 상속이 안된다.
  public Terran(String name, int hp) {
    //super <= (생략되어있음)// 내가 상속받을 클래스를 가르킴(조상의 생성자)
    super("Terran",name,hp);  //ctrl + super 를 클릭하면 조상(terran의 조상 Unit)을 알 수 있음
  }
}
class Marine extends Terran {
  public Marine() {
    super("Marine",60);
  }
}
class  Medic extends Terran{
  public Medic() {
    super("Medic",45);
  }
}

