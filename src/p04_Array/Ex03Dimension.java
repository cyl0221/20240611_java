package p04_Array;

public class Ex03Dimension {
  public static void main(String[] args) {
    //2차원 배열
    int[][] arr = new int[3][3]; // int [행][열]
    /*arr = {{1,2,3},{4,5,6},{7,8,9}}*/ //오류
    arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 2차원 배열 // 출력할때 행을 걸어놓고 열을 출력(2중 for문 사용)
    System.out.println(arr2.length);
    System.out.println(arr2[0].length);
    System.out.println(arr2[0][0]);
    int sum = 0;
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        if(j !=0) {System.out.print(", ");} // 같은 줄에 있으면 중괄호 생략가능
        sum = sum + arr2[i][j];
        System.out.print(arr2[i][j]);

      }
      System.out.println();
    }
    System.out.println(sum);
  }
}
