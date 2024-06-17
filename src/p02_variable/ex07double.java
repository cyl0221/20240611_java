package p02_variable;

import common.Utils;

public class ex07double {
  public static void main(String[] args) {
      // float :: -3.4*10^38 ~ 3.4*10^38 (정밀도 : 소수7자리)
      // double :: -1.7*10^308 ~ 1.7*10^308 (정밀도 : 소수13자리)
    float f1 = 0.0f; // float f1 = 0.0;==> 에러남 0.0 뒤에 f를 붙여줘야한다.
    double d1 = 0.0; // d 생략가능
    Utils.typeOf(0.0); //값 double
    Utils.typeOf(0.0f); //값 float
    int i1 = 10;
    long l1 = 1000;  // long 8byte
    Utils.typeOf(0.0f + i1); // 값 float
    Utils.typeOf(0.0f + l1); //  값 float 표현범위가 큰 타임으로 형변환
    Utils.typeOf(f1 + d1); // 값 double
    d1 = f1; //
    // f1 = d1 // ==> 오류
    f1 = (float) d1;  // 명시적 형변환
  }
}

// boolean ,char, int 가 대표
// float 와 double 중 double이 대표
