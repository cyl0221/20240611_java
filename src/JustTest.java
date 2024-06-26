public class JustTest {
  public static void main(String[] args) {
        String seat [][] = new String[10][15];
        String eng [] = {"a","b","c","d","e","f","g","h","i","j"};
        for (int i = 0; i < seat.length; i++) {
          for (int j = 0; j < seat[i].length; j++) {
            seat[i][j] = eng[i] +  (j + 1);
            System.out.print(seat[i][j] + " ");
          }
          System.out.println();

        }
      }
    }



