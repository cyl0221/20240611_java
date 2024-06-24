package p05_Inherit;

public class Ex11Singleton {
  public static void main(String[] args) {
    // Singleton s1 = new Singleton(); // 생성연산자 + 생성자  = instance 만들어서 쓸 수 있다.
     Singleton s1 = Singleton.getInstance();
    // Singleton s2 = new Singleton(); // 밑에 private가 있어서 new는 사용하지 못하기 때문에
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1);
    System.out.println(s2);
  }
}
// 생성자는 method의 변형
class Singleton { // new를 통해서 instance를 못만드는 상태,
  static private Singleton singleton;
  private Singleton (){

  }
  static public Singleton getInstance() {
    if(singleton == null)
      singleton = new Singleton();
    return singleton;
  }
}
// 중복로그인방지 할떄 사용?!