package p03_method;

import javax.swing.*;
import java.util.Scanner;

public class Ex07condition {
  public static void main(String[] args) {
    /*Scanner sc = new Scanner(System.in);
    System.out.println("숫자 입력 : ");
    int input = sc.nextInt();
    System.out.println(input);*/
    String result = "";
    String score = JOptionPane.showInputDialog("점수입력하세요");
    int input = Integer.parseInt(score);
    if (input >= 90) {
      result = "A";
    } else if (input >= 80) {
      result = "B";
    } else if (input >= 70) {
      result = "C";
    } else if (input >= 60) {
      result = "D";
    }  else { result="F" ;}
    if(input == 100) {result = "A+";}
    else if (input < 60){result = "F";}
    else { if (input %10 >= 7 ) {
      result += "+";
    } else if (input %10 >= 4) {
      result += " ";
    } else if (input %10 >= 1){
      result += "-";
    }

    }
    // 입력하는 부분
    // 학점 내는 부분
    // 학점 디테일 내는 부분
    // 출력하는 부분
    if (input %10 >= 7 ) {
      result += "+";
    } else if (input %10 >= 4) {
      result += " ";
    } else if (input %10 >= 1){
      result += "-";
    }

    System.out.println(result + " 학점입니다.");

  /*if ( input >= 90) {
    System.out.println("A");
  } else if (input >= 80){
    System.out.println("B");

  } else if (input >= 70){
      System.out.println("C");
  } else if (input >= 60) {
    System.out.println("D");
  } else {
    System.out.println("F");
  }*/
  }
}

