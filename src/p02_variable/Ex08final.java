package p02_variable;

import javax.swing.*;

public class Ex08final {
  public static void main(String[] args) {
    final int GAUS_VAL;
    GAUS_VAL = 10;
    System.out.println(GAUS_VAL);
    // GAUS_VAL = 20; // 에러발생 :: 한번 값을 정하면 바꿀수없음
    final String INPUT;
    INPUT = JOptionPane.showInputDialog("아이디를 입력하세요");
    System.out.println(INPUT);
  }
}