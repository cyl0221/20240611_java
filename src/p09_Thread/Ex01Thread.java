package p09_Thread;

import javax.swing.*;

public class Ex01Thread {
  public static void main(String[] args) {
    Bomb bomb = new Bomb();
    //Threac를 상속 받으면 그 자체로 start()를 적용할 수 있다.
    // bomb.start();  //class상태에서 쓸 수 있고  --(1)

    // Runnable 을 implement 하면 Thread() 생성자 안에 매개변수로 전달해야만 생성가능
    new Thread(bomb).start(); // --(2)
    int input = Integer.parseInt(JOptionPane.showInputDialog("빨간선(0),파란선(1) 중에 선택하세요"));
    bomb.choice(input);


  }
}

// Thread의 장점 : 별도의 흐름을 생성, 자원을 절약할 ㅅ 있다.
//class Bomb extends Thread { // --(1)  위 1번하고 같이 쓰인다.
class Bomb implements Runnable {  // --(2) 위 2번하고 같이 쓰인다.
private int answer = (int) (Math.random() * 2); // 뒤에 숫자는 랜덤으로 뽑을 숫자의 범위,
  private boolean state;

  public void choice(int input) {

    state = true;
    if (answer == input) {
      System.out.println("살았습니다.");
    } else {
      System.out.println("죽었습니다.");
    }
  }

  @Override // Thread 의 동작을 정의한 메서드
  public void run() {
    for (int i = 10; i > 0; i--) {
      if (state == true) {
        break;}
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);    // int 0 또는 1
      }

    }
  }


}