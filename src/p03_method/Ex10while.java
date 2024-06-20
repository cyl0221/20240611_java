package p03_method;

import javax.swing.*;

public class Ex10while {
  public static void main(String[] args) {
    int i = 0;
    int sum = 0;
    while (i < 10/*조건*/) {
      sum += i++;// 증감에 대한 내용 /*명령*/
    }
    System.out.println(sum);

    /*int i1 = 1;
    while (i1 <= 9) {
    System.out.printf("2 * %d = %d \n", i1, 2*i1);
      i1++;
    }*/
    int i2 = 2;
    int j = 1;
    while (i2 < 10) {
      j = 1;
      while (j < 10) {
        System.out.printf("%d * %d = %d \n", i2, j, i2 * j);
        j++;
      }
      System.out.println();
      i2++;

    }  // 반복되면서 초기화가 되니까 j값을 정해준다.

    i = 2;
    j = 1;
    while (j < 10) {
      i = 2;
      while (i < 10) {
        System.out.printf("%d * %d = %2d \t ", i, j, i++ * j);

      }
      j++;
      System.out.println();

    }


    /*System.out.println(random);*/
    /*System.out.println("========내 마음의 숫자를 맞추기 게임========");

    int random = (int) (Math.random() * 100) + 1;
    while (true) {
      int answer = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));
      if (answer > random) {
        System.out.println("작습니다.");
      } else if (answer < random) {
        System.out.println("큽니다");
      } else {
        System.out.println("정답입니다.");
        break;
      }
    }*/



/*    boolean stop = false;
    while (true) {
    int random = (int) (Math.random() * 100) + 1; //1보다 작은 실수를 리턴해줌
      if (stop) break;

      while (true) {
      String input = JOptionPane.showInputDialog("숫자를 입력하세요(종료하려면 Q,q))");
        if (input.toLowerCase().equals("q")) {
          stop = true;
          break;
        } else {
          int answer = Integer.parseInt(input);
          if (random < answer) {
            System.out.println("작다");
          } else if (random > answer) {
            System.out.println("크다");
          } else {
            System.out.println("정답");
          }

    while (random != answer) {
      System.out.println("다시 입력하세요");}


        }
    }
    }*/
    // JOptionPane 숫자로 들어오는걸 문자로 바꿔주는 것
    // try catch 문
    do {
      int you = (int) (Math.random() * 3); // 세가지 경우의수를 나타냄
      String input = JOptionPane.showInputDialog("가위(0),바위(1),보(2)중에 입력하세요");
      if (input.equals("q")) {
        break;
      }
      int me;
      try {
        me = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        continue;
      }
      String me1 = "";
      String you1 = "";

      if (me == 0) {
        me1 = "가위";
      } else if (me == 1) {
        me1 = "바위";
      } else if (me == 2) {
        me1 = "보";
      } else {

        continue;
      }

      if (you == 0) {
        you1 = "가위";
      } else if (you== 1) {
        you1 = "바위";
      } else if (you== 2) {
        you1 = "보";
      }
      String result;
      if (me == you) {
        result = "draw";
      } else if ((me == 0 && you == 2) || (me == 1 && you == 0) || (me == 2 && you== 1)) {
        result = "win";
      } else {
        result = "lose";
      }
      System.out.printf("me: %s\nyou: %s\n%s\n", me1, you1 , result);
    } while (true);
    System.out.println("q");
  }
}