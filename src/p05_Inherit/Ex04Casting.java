package p05_Inherit;

public class Ex04Casting {
  public static void main(String[] args) {

    Father f1 = new Father();
    Son s1 = new Son();
//    s1.hard();

    // 상속관계의 형변환
    Father f2 = new Son(); // 자식의 instance / 참조형 타입의 형변환 // 자 -> 부
    // Son s2 = (Son) new Father(); // 오류! 반대로는 안된다. / 부 -> 자
    Son s3 = (Son)f2; // 자 -> 부 -> 자 ==> type -> Son

    /* 상속관계의 형변환에서 변수와 method 중복이 일어날 경우
     변수는 형변환된 타입의 값을 가진다.
    method는 무조건 자식의 method를 따른다.*/
    f2.hard();
    System.out.println(f2.age);
    s3.hard();
    System.out.println(s3.age);
  }
}

class Father {
  String familyName;
  int age = 50;

  void hard() {
        System.out.println("아버지의 열심");
  }
}

class Son extends Father {
  int age = 20;
  void hard () {
    System.out.println("아들의 열심");
  }

}