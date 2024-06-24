package p05_Inherit;

public class Ex13trycatch {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    System.out.println(3);
    try {
      System.out.println(10/0);
    System.out.println(4);
    } catch (Exception e) {
      //throw new RuntimeException(e); //실행하다가 오류가 발생해도 넘어간다.
      System.out.println("예외발생");
    } finally {
    System.out.println(5); // 발생을 하든 안하든 무조건 출력
    }
    System.out.println(6);
    System.out.println(7);
    System.out.println(8);
  // tryWithResource 문은 입출력에서 다룰 것
  }
}
