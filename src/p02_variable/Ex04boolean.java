package p02_variable;

import com.sun.tools.javac.Main;

public class Ex04boolean {
  public static void main(String[] args) { // 밑에 tv class 호출한다
    // Tv tv = new Tv();
    Tv tv;
    tv = new Tv(); // 위 내용과 동일한 내용
    System.out.println(tv);
    tv.power();
    tv.power();
    tv.channelUp();
    tv.channelDown();
    tv.volumeUp();
    tv.volumeDown();
    tv.channel(12);
    //System.out.println(tv.channel);
    //System.out.println(tv.volume);
  }
}

// tv 클래스 선언  변수명은 power volume channel / 속성을 주고,

// class 는 재사용성이 있다.
class Tv {
  boolean power;
  int channel;
  int volume;

  // method 뒤 소괄호, 앞 retrun(void)
  void power() {
   /* 1.
    if(power == false){
      power = true;
      System.out.println("Tv 전원이 켜졌습니다.");
    } else {
      power = false;
      System.out.println("Tv 전원이 꺼졌습니다.");
    }*/
/*   2.
    if(power == true){
     System.out.println("Tv 전원이 켜졌습니다.");
   } else {
     System.out.println("Tv 전원이 꺼졌습니다.");
   }
*/
//  3.
    power = !power;
    System.out.println(power ? "전원 On" : "전원 Off"); // 삼항 연산자 <?:>
  }
  void channelUp() {       // 단항 연산자
    //channel = channel + 1;
    //channel += 1;
    // channel++;
    //if (power) {
    System.out.println(++channel);
    //}
  }
  void channelDown() {
    System.out.println(--channel);
  }
  void volumeUp() {
    System.out.println(++volume);
  }
  void volumeDown() {
    System.out.println(--volume);
  }

    void channel(int channel) {
      this.channel = channel;
    }
}







