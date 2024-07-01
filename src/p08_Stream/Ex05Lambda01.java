package p08_Stream;

public class Ex05Lambda01 {
  public static void main(String[] args) {
    Runnable r = new Runnable() {   // --(1)-1
      @Override
      // 1) 매개변수가 없을 경우 반드시 () 표기
      public void run() {
//        System.out.println("Anonymous Object");  -- (1)-1
//        System.out.println();  -- 만약 명령을 없앴을때, --(2)
      }
    };
    r = ()-> System.out.println("Anonymous Object"); //매개변수가 없을때 무조건 소괄호를 넣어줘야한다. // --(1)-2
    r = ()-> {System.out.println("Anonymous Object");};  // --(1)-3
    r = () -> {}; // run() method 안에 명령이 없는 경우 반드시 {} --(2)

    MyInterface mi =new MyInterface() {
      @Override
      //public void doIt(매개변수x) {명령어x} 매개변수가 없을 때 경우 --*
      public void doIt(int num) {

      }
    };
//    mi = () -> {}; 매개변수에 아무것도 없을때에 씀 -- *
      //2) 매개변수가 1개 일 때, ()는 생략가능, 2개 이상 생략 불가
      mi = (num) -> {}; // --^^
      mi = num ->  {}; // --^^
      MyInterface2 mi2 = (n1,n2) -> {}; // -- %%
    //3) 매개변수가 있고, return type이 있는 경우
      MyInterface3 mi3 = (n1,n2) -> {return (n1+n2);}; //-- &&
      mi3 = (n1,n2) -> n1+n2; // 중괄호를 생략하면 return도 생략 -- &&

    //4) 중괄호안에 명령이 2개 이상이면 중괄호 생략 불가
    mi3 = (n1,n2) -> {
      n1 = n1 + 10; n2 =n2*10;
      return n1+n2;
    }; // 중괄호를 생략하면  return도 생략
  }
}
@FunctionalInterface // 함수형 인터페이스 선언시  --^^
interface MyInterface {
  void doIt(int num);
}
@FunctionalInterface // 함수형 인터페이스 선언시 -- %%
interface MyInterface2 {
  void doIt(int num1, int num2); //매개변수가 2개일때
}
@FunctionalInterface // 함수형 인터페이스 선언시 -- &&
interface MyInterface3 {
  int doIt(int num1, int num2); //매개변수가 2개일때
}
