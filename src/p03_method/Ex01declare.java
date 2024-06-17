package p03_method;

public class Ex01declare {
  // return type(총 10가지) : void, primitive, reference
  // void : return 없는 경우
  // primitive (8가지), reference (1가지) : return 없는 경우
  boolean b1; // 선언만 한 상태

  // void add {}
  void print1() {
    System.out.println("Hello method~!");
    return; // 보통은 return을 쓰지 않음 // 암묵적으로 return 생략
  }
  // return type 을 사용.
  boolean print2() {
  //boolean add1() {    //add 는 (주석처리된 add)위에와 동일해서 사용불가하니 add1을 쓸 수 있다.
    /*boolean result;
    Ex01declare ex01declare = new Ex01declare();
    result = ex01declare.b1;
    return result; // 지역변수로 되어있기 때문에 할당이 되어야한다.*/ // --1
    return new Ex01declare().b1; // -- 2
    //변수를 사용하는 이유? 한번 더 사용하기 위해서,
  }
  char print3() {
    return 'C';
  }
  // 구조 :: return type +  method 이름 + 소괄호  // method 이름이 같으면?!
  int print4() {return 10; }
  int print6() {return (int) 0.0;} // 명시적 형변환
  double print5() {return 10;}

  boolean print() {       // 매개변수가 없음
    boolean result = false;
    return result;
  }
  //오버로딩 :: method가 같아도 사용 가능한 상태
  boolean print(boolean result){ //매개변수가 잇음 //중괄호 안에서만 유효한 상태(지역변수) 매개변수=지역변수
    return result;
  }
  char print(char c) {return c;}
  int print(int result) { return result;} // int print(int i) { return i;}
  double print(double result) {return result;}

  // args :: argument 매개변수, 인수
  public static void main(String[] args) {
    Ex01declare e1 = new Ex01declare();
    e1.print1();
    System.out.println(e1.print2());
    System.out.println(e1.print());
    System.out.println(e1.print(true));
    System.out.println(e1.print('Z')); // 알아서 30번을 호출
    System.out.println(e1.print(10));
    System.out.println(e1.print(6.5));


  };

}

class Math