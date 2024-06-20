package p05_Inherit;

public class Ex02extends {
  public static void main(String[] args) {
    //Unit unit = new Unit(); // 밑에 abstract를 사용하면 사용하지 못한다 에러
    Marine m1 = new Marine();
    System.out.println(m1.hp);

  }
}

abstract class Unit { /// 추상적인 class
   int hp;
   String tribe;
  public void move(int x, int y){}
  public void stop(){}
}
abstract class Terran extends  Unit{  // 상속할때 extends 를 사용한다

}
class Marine extends Terran {

}
fdfd