package p03_method;

import javax.swing.*;

public class Ex08switchcase {
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog("당신이 태어난 달 입력:"); // String :: 참조형은 주소값을 가지고 여러개의 속성
    int birthMonth = Integer.parseInt(input); //문자를 숫자로 형변환

    String result = "";
    switch (birthMonth) { //  switch case 문에는 break 필요!
      case 3: case 4: case 5:
        result = "봄";
        break;
      case 6: case 7: case 8:
        result = "여름";
        break;
      case 9: case 10: case 11:
        result = "가을";
        break;
      case 12: case 1: case 2:
        result = "겨울";
        break;
      // default:
      //  result = "겨울"; break; // default는 break 없어도 된다.
      }
    System.out.println("당신이 태어난 계절:" + result);

    input =  JOptionPane.showInputDialog("당신의 이름을 입력:");
    String familyName = input.substring(0,1); //substring 문자열인
    switch (familyName) {
      case "김":
        System.out.println("Kim");
        break;
      case "이" :
        System.out.println("Lee");
        break;
      case "박" :
        System.out.println("Park");
        break;
      case "성" :
        System.out.println("Seong");
        break;
      case "최" :
        System.out.println("Choi");
        break;
      case "정" :
        System.out.println("Jung");
        break;
      case "강" :
        System.out.println("Kang");
        break;
    }
  }
}
