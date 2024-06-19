package p03_method;

public class Ex04CallByValue {
  public static void main(String[] args) {
    String st; // 선언만 할 경우 인스턴스가 String 타입의 구조만 설정된 것임
    //System.out.println(st); // 초기화가 안되어서 에러
    String str = "hello";
    System.out.println(str); // String 은 문자가 찍힌다.
    Data d = new Data(); //참조형 변수 :: 주소값
    System.out.println("main: " + d); // 현재 주소값
    d.value = 100;
    System.out.println(d.value);
    change(500); //22번 라인(change int) 호출 :: 값
    change(d.value); //22번 라인(change int) 호출 :: 값
    change((int)1.12f); //  22번 기본형타입의 명시적 형변환
    change(d); // 24번 라인 호출(change Data) :: 참조형 변수
    System.out.println(d.value);

  }
  // static을 먼저 읽은 후 main method를 열어본다.
  // void
  static void change(int value) {   // int가 type value가 변수명
    value = 1000;// 지역변수에서 변경된것이지

      }
 static void change(Data data) {  //Data가 type data가 변수명
    data.value = 1000; // 지역변수에서 변경된것
   System.out.println("change: " + data);
   System.out.println(data.value);
  }

 // class가 있어야 instance > method를 만들고
}
// class 는 참조형 번수인데, 위에 data를 찍으면 주소가 나온다.
class Data {
  int value;
}
