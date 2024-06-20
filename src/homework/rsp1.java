package homework;

import javax.swing.*;

public class rsp1 {
  public static void main(String[] args) {


// 2024년 6월 19일
// 가위바위보 게임 과제
// do while 한번만 사용
// 가위(0), 바위(1), 보(2)
// 무한루프 빠졌을때 ctrl + c 누르면 종료

    boolean stop = false;
    do {

      System.out.println("\n[가위바위보 게임]");
      String input = JOptionPane.showInputDialog("가위(0), 바위(1), 보(2) 입력 또는 종료버튼 Q/q");

// 게임 종료 확인

      if (input.equalsIgnoreCase("q")) {

        stop = true;

        break;

      }


      int me;

      try {
        me = Integer.parseInt(input);
        if (me < 0 || me > 2) {
          System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

          continue;

        }

      } catch (Exception e) {

        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

        continue;

      }


// me 숫자 -> meStr 한글

      String meStr;

      switch (me) {

        case 0:

          meStr = "가위";

          break;

        case 1:

          meStr = "바위";

          break;

        case 2:

          meStr = "보";

          break;

        default:

          meStr = "알 수 없음";

          break;

      }


// 컴퓨터 가위바위보 선택 (0, 1, or 2)

      int random = (int) (Math.random() * 3);


// random 숫자 -> randomStr 한글

      String randomStr;

      switch (random) {

        case 0:

          randomStr = "가위";

          break;

        case 1:

          randomStr = "바위";

          break;

        case 2:

          randomStr = "보";

          break;

        default:

          randomStr = "알 수 없음";

          break;

      }


      System.out.println("컴퓨터: " + randomStr);

      System.out.println("나: " + meStr);


      // 결과

      if (me == random) {

        System.out.println("비겼습니다.");

      } else if ((me == 0 && random == 2) || (me - random == 1)) {

        System.out.println("이겼습니다.");

      } else {

        System.out.println("졌습니다.");

      }

    } while (!stop);

    System.out.println("게임을 종료합니다.");

  }

}
