package p01_class;

public class AnimalEx {
  static Animal a2 = new Animal(); // instance 변수
  // static 을 붙여줘야 a2가 사용가능
  //class 내에는 멤버변수 와 method 사용
  //Quiz) Animal을 인스턴스로 만들어 사용해보시오.
  public void done() {
  Animal a1 = new Animal();
    a1.run();
    a2.run();
  // 메인 method가 불러줘야 사용가능
    //heap 영역
  }

  public static void main(String[] args) {    //<== method
    Animal a1 = new Animal();
    a1.run();
    AnimalEx animalEx = new AnimalEx();
        animalEx.done();
        System.out.println(animalEx.a2);// <== 멤버 변수
    //  메인 method 실행(jvm이 실행시킨다)
    // jvm이 실행하기 위해서 static을 붙여서 사용한다.
    // a2.run();//static은 같은 static 끼리만 사용 : 시점이 다름
     a2.run();
  }
}
