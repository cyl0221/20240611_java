package p02_variable;


import p01_class.Animal;

public class Ex02Types {
  //변수의 종류 : primitive, Reference
  // primitive type(일반 변수 실제 값을 가짐/기본형 변수)
  // Reference type(참조형 변수, 주소값을 가짐)
  // 일반 변수의 종류 : 논리형/문자형/정수형/실수형


  // 변수 사용할때 할당 필수!
  // Type 변수명 = 값(실제/주소)

  // int num; ==> 선언
  // num = 10; ==> 초기화
  // ==> 선언 + 초기화 =  할당 assignment
  // 지역변수는 전역변수와 다르게 할당까지 꼭 해야 한다.
  // 멤버변수는 선언만 해도 된다. ==> new 연산자를 통해 초기화를 하지않고 선언만 하면 기본값으로 초기화
  // return type
  boolean power = true;  // 지역변수이기 때문에 할당을 줘야 값이 나온다. // 할당 //==> 다른값이랑 호환이 안된다. 기본값은 false
  char c1; // 선언 // 지역변수인데 할당을 안했기 때문에 값이 안나옴 => 기본값 공백
  byte b1;  // 기본값 ==> 0
  short  s1; // 기본값 ==> 0
  int i1; // 기본값 ==> 0
  long l1; // 기본값 ==> 0
  float f1;  // 기본값 ==> 0.0
  double d1; // 기본값 ==> 0.0
  String str; // 기본값 ==> null
  Animal animal; // ==> 전역 변수 들  // 기본값 ==> null




  public static void main(String[] args) {
    // primitive type(일반 변수 실제 값을 가짐)
    // 지역변수는 전역변수와 다르게 할당까지 꼭 해야 한다.
    boolean power = true; // 논리형 = true or false 1byte
    char c1 = 'A'; // 문자형, 2byte, 0~65535 // char = 'HELLO' <== X 한문자만 들어갈 수 있음
    byte b1 = 10; // 정수형, 1byte, 범위 : -128~127 (총 256)
    short  s1 = 10; // 정수형, 2byte, 범위 : -32768~32767 총65535
    int i1 = 10; // 정수형 4byte, 범위 : -2147483648~2147483647
    long l1 = 10L; // 정수형, 8byte
    float f1 = 0.1f;  // 실수형, 4byte 소수점 7째자리 10^-45 ~ 10^38 ==> 표현범위가 long보다 크다
  double d1 = 0.1D; // 실수형, 8byte 소수점 13째자리 10^-324 ~ 10^308
    // Reference type(참조형 변수, 주소값을 가짐)
    String str = "Hello"; System.out.println(str);
    Animal animal = new Animal(); System.out.println(animal);
    System.out.println(c1);
    System.out.println(str);

    System.out.println("===================================================");
    //전역변수 선언 (instance 를 만든다 ex02Types 전역변수는 선언만 해도 가능)
    Ex02Types ex02Types = new Ex02Types();  // ==> instance //new (주소값) 생성 연산자
    System.out.println(ex02Types.power);// false
    System.out.println(ex02Types.c1);   // 공백
    System.out.println(ex02Types.b1);   // 0
    System.out.println(ex02Types.s1);   // 0
    System.out.println(ex02Types.i1);   // 0
    System.out.println(ex02Types.l1);   // 0
    System.out.println(ex02Types.f1);   // 0.0
    System.out.println(ex02Types.d1);   // 0.0
    System.out.println(ex02Types.str);  // null
    System.out.println(ex02Types.animal); // null
    // ==> 기본값

  }
}

