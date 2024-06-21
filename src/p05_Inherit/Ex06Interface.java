package p05_Inherit;

public class Ex06Interface {
  public static void main(String[] args) {
  Athlete athlete = new Athlete();
    System.out.println(athlete);
  }
}
//java 에서는 다중상속이 안된다.

// 인터페이스 뒤에는 ~able 또는 앞에는 i를 붙일 수 있다
class Athlete implements ISwim, IBicycle, IMarathon {
// 위 내용에서 ISwim, IBicycle, IMarathon 이거를 Triathlon 로만 묶어서 사용가능

  public void swim() {
    // 중복된 상수는 static 붙어 있기 때문에 클래스와 함게 지정
    System.out.println(ISwim.LEVEL);

  }

  @Override
  public void ride() {
    Triathlon.start();

  }

  @Override
  public void run() {

  }
}
//interface 는 추상자료형, 반드시 class 에서 implements후에 사용
// 자바는 다중함수를 사용하지 않는데 interface를
// class. 상수 =>
// 목적 : 클래스들이 구현해야 하는 동작을 보완하기 위해 사용
// 장점 : 표준화가 가능
interface ISwim{

  //추상메서드와 상수만 정의(static, default 메서드 추가)
  // 자유롭게 쓰기 위해서 정의를 따로 더 하지 않는다.
  /*(public abstract) void 앞 생략가능*/
  void swim();
  /*public static final* 생략가능*/ int LEVEL = 10;
}
interface IBicycle {  // interface 둘 다 미완성이니 위 클래스에서 정의해준다.
  void ride();
  int LEVEL = 20;
}
interface IMarathon {
  void run();
}
interface Triathlon extends ISwim,IBicycle,IMarathon{
  public default void complete() {
    swim(); ride();run();
  }
  public static void start() {
    System.out.println("출발이다!");
  }
}