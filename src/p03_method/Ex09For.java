package p03_method;

public class Ex09For {
  public static void main(String[] args) {
    // 반복문을 구현할때
    // 첫번째 패턴을 찾아라
    // 두번째 초조증을 적용하여 구현

    /*int sum = 0;
    sum = sum + 0;
    sum = sum + 1;
    sum = sum + 2;
    sum = sum + 3;
    sum = 0;
    // for (int i = 0; i < 10 ; i++) { //for i 를 선택하면 옆에 식이 자동으로 생성된다. // 값은 45
    //  초기값(Initialization) ;  조건(Condition) ; 증감식(Increment/Decrement)
    // 본체 (Body): 조건이 참인 동안 반복적으로 실행되는 코드 블록   )
    // 중괄호(for문 내) 안에서만 유효하게 사용가능함

    for (int i = 9; i >= 0; --i)
      sum = sum + i; // 위 주석처리한 값과 같다.
    System.out.println(sum);*/


    /* int multi = 0;
    for (int i = 2; i < 10; i++)
      for (int j = 1; j < 10; j++) {
        System.out.println(i + "*" + j + "=" + (i * j) + "\n");
      }*/
    for (int i = 2; i < 10; i++) {
      System.out.println("[" + i + "단 ]");
      for (int j = 1; j < 10; j++) {
        System.out.printf("%d * %d = %2d \n" ,
            i , j, i * j);
      }
      System.out.println("---------------------------------------");
    }
    for (int i = 2; i < 10; i += 3) {
      /*System.out.println("[" + i +"단 ]");*/
      for (int j = 1; j < 10; j++) {
        for (int k = 0; k < 3; k++) {

          System.out.printf("%d * %d = %2d \t" ,
              i+k, j, (i+k) * j);
        }
        System.out.println();
      }
      System.out.println();
    }

    //for 문은 비교적 횟수에 대한 예측이 가능할 때
    int i = 0;
    for (; ;) {
      System.out.println(i++);
      if(i >= 10)
        break; // 자신이 속한 반복문을 벗어남
    }
    for(int k= 0, j=0; j<10 ;j++, k--);{ //조건은 하나만 줄 수있다.(초기화랑 증감값은 여러개 줄 수 있음)
      System.out.println();
    }
    }
}
