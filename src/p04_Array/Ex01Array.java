package p04_Array;

import common.Utils;

public class Ex01Array {
  public static void main(String[] args) {
    //배열 : 같은 변수의 이름으로 반복되는 작업을 위한 저장 공간
    // 배열을 선언하게 되면 length을 자동으로 선언하게 됨

    /*int[] arr = new int[10]; //size 10개*/
    // 선언과 초기화 분리 // 위에 주석처리 해놓은 것은 선언과 초기화 합쳐놓은 것
   /* int[] arr;
    arr = new int[10];*/

    //선언과 초기화와 직접 값 입력
    // int[] arr = new int[]{0,1,2,3};
    int[] arr = {0,1,2,3};  // 위 아래 같은 내용이고 지금 이 줄 처럼 간단하게 표현도 가능하다.

    Object[] objects = new Object[5]; // 0,1,2,3,4
    String[] strings = new String[3];
    Utils.typeOf(arr);
    Utils.typeOf(objects);
    Utils.typeOf(strings);
    System.out.println(arr.length);
    System.out.println(arr[0]); // arr의 0번째의미 // 값은 0 => new를 만나서 0이 된다.
    System.out.println(objects[3]); //object 참조형변수 기본값은 null
    System.out.println(strings[2]);
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 5;
    System.out.println(arr[1]); // 횟수가 정해져있으면 while 대신에 for문을 썼을때 편하다.
    int sum = 0;
    for (int i = 0; i < arr.length; i++) { // for 내에 int sum = 0을 넣으면 계속 0으로 초기화되기 때문에 말짱도루묵
      arr[i] =(int) (Math.random()*10);
      arr[i]  = i;
      sum = sum + arr[i];
      /*System.out.println(arr[i]);// 그냥 i 값을 못 쓰는 이유는 값이 바뀔 수 있기 때문에,*/
    }
      System.out.println(sum);

  }
}
