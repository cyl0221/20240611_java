package p02_variable;

  public class Ex01Location {
  // 1. 변수의 선언 위치 :: 전역(멤버), 지역
  int sum = 0; //멤버변수는 전역(global variable)
  // int sum = 1; // 중복 선언되어서 에러 발생
  public void sum() {
    System.out.println("global:"+ sum);  // 전역변수가 있어도 지역변수를 먼저 사용한다.
    int sum =1; //지역(local variable) 중괄호 안에 선언되어진것은 지역변수
    System.out.println("local:"+ sum);
  }

  public static void main(String[] args) {
    Ex01Location ex01Location = new Ex01Location();
    System.out.println(ex01Location.sum);
    ex01Location.sum();  // 위의 sum 의 method 를 가져다 쓰기 때문에 뒤에 소괄호 작성
  }
}
