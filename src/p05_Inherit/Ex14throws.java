package p05_Inherit;

import java.io.IOException;

public class Ex14throws {
  public static void main(String[] args) throws Exception{
    method1();
    System.out.println("main");
    Child2 child2 = new Child2();
  }
  private static void method1() throws Exception{
    method2();
    System.out.println("method1");}
  private static void method2() throws Exception {
    method3();
    System.out.println("method2");}

  private static void method3() throws Exception { // 전체적으로 throws 를 해주니, jvm이 책임진다.
    try {
      throw new Exception();
    } catch (Exception e) {
      throw new RuntimeException(e);
      /*System.out.println("method3");*/
    }
  }
}
class Parent2 {
  protected void method() throws ArithmeticException, IOException{}
}
class Child2 extends Parent2 {
  // method 재정의할떄 주의할 점 , method 재정의 할 때, 접근 제어자의 범위는 같거나 넓어야 한다.
  @Override
  //throws 는 없거나 적거나 같아야한다.
  protected void method() throws ArithmeticException, IOException, ArrayIndexOutOfBoundsException{
    super.method();
  }
}

