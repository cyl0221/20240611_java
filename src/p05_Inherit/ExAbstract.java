package p05_Inherit;

public class ExAbstract {
  public static void main(String[] args) {
    //스스로 인스턴스 생성불가 ( 추상클래스, interface)
    /*Abstract abs = new Abstract();
      Interface inter = new Interface();*/

  }
}

// 추상클래스 abstract :: 스스로 인스턴스를 만들지 못함 미완성인 상태
// 공통(표준)으로 사용위해 만듦, 인스턴스 생성 불가
abstract class Abstract {
  int num = 10; void general(){}
  // 추상 메서드로 사용할 경우 abstract 붙일 것
  abstract void special();
}
interface Interface {}

//제어자는 나중에 설명해주신다고 함.