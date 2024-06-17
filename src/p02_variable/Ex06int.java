package p02_variable;

import common.Utils;

public class Ex06int {
  public static void main(String[] args) {
    byte b1 = 100;
    //byte b2 = 200;
    byte b3 = 100;
    Utils.typeOf(b1 + b3);
    //byte b4 = b1 + b3;
    System.out.println(b1 + b3);
    byte b4 = (byte) (b1 + b3);
    Utils.typeOf(b4);
    System.out.println(b4);
    // 1.boolean 제외한 4byte 이하 자료형은 int로 변환 후 연산 // 연산전에 변환한다.
    short s1 = 1000;
    short s2 = 1000;
    // 2.표현 범위가 큰것이 작은 것으로 올 때는 명시적 형변환!
    // short s3 = s1 + s2; ==> 오류
    short s3 = (short) (s1+s2); // 명시적 형변환
    System.out.println(s3);
    int i1 = s1 + s2;
    long l1 = 200l; //long = long
    //3. 표현범위가 작은것이 큰것으로 올 때는 묵시적 형변환!
    long l2 = 200; // long = int ==> 뒤에 L을 붙이지 않으면 int로 적용된다.// long l2 = (long)200; 묵시적형변환

    int i2 = (int)l2;  // 큰범위가 작은범위로 올때는 명시적 선언
    //int i2 = l2; ==> 오류발생
    long result = i2 + l2;
    Utils.typeOf(result); //long과 연산을 할 경우 long 타입으로 형변환
    int i3 = b1; // int = byte :: 묵시적 형변환(int 표현범위 큼)
    byte b5 = (byte) i3; //byte = int :: 명시적 형변환
  }
}

