package p06_javalang;

import java.util.Arrays;

public class Ex03ObjectMath {
  public static void main(String[] args) {
    System.out.println(Math.abs(-10));
    System.out.println(Math.ceil(10.1)); //절상, 올림
    System.out.println(Math.floor(10.1)); //절삭, 내림
    System.out.println(Math.round(0.5)); // 반올림
    System.out.println(Math.round(-1.5));
    int[] arr = new int[5];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 5) + 1;
    }
    System.out.println(Arrays.toString(arr));
    int max = arr[0];
    int min =arr[0];
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    System.out.println(max+"/"+min);
    // 숫자를 문자열로
    System.out.println(Integer.toBinaryString(10));// 10을 2진수의 문자형태
    System.out.println(Integer.toOctalString(10)); // 8진수의 문자형태
    System.out.println(Integer.toHexString(10)); // 16진수의 문자형태

    // 문자열을 숫자로
    System.out.println(Integer.parseInt("10"));
    System.out.println(Integer.parseInt("1010",2));
    System.out.println(Integer.parseInt("1010",8)); // radix :: 진법을 나타냄 ex)8진수
    System.out.println(Integer.parseInt("1010",16));
  }
}
