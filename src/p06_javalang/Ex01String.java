package p06_javalang;

public class Ex01String {
  public static void main(String[] args) {
    String str1 = "hello";
    String str2 = new String("hello");
    String str3 = "hello";
    String str4 = String.valueOf("hello");
    System.out.println(str1 == str2); //new로 만들어진 string과는 주소값이 다르기때문에 false가 나옴
    System.out.println(str1 == str3);
    System.out.println(str1 == str4);

    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode()); //위의 해쉬코드와 같게 나온다.
    System.out.println(str3.hashCode()); //위의 해쉬코드와 같게 나온다.
    System.out.println(str4.hashCode()); //위의 해쉬코드와 같게 나온다.
    System.out.println(System.identityHashCode(str1));
    System.out.println(System.identityHashCode(str2));// 시스템적 측면에서는 해쉬코드가 다르게 나온다.
    System.out.println(System.identityHashCode(str3));
    System.out.println(System.identityHashCode(str4));
    System.out.println(str1.equals(str2));
// constant pool에 str1의 변수가 가리키는 "hello"를 가져옴
    System.out.println("str1.intern(): " + str1.intern());
    // 배열은 int가 모인 객체타입, 참조형변수 뒤에 소괄호가 안붙음, length() String의 method 가르키기 때문에 붙는다
    for (int i = 0; i < str1.length(); i++) {
      if(i!=0) System.out.print(",");
      System.out.print(str1.charAt(i));
// String 은 char의 배열로 저장한다.
    }
    System.out.println();
    System.out.println(str1.compareTo("world")); // -15 , w가 h보다 -15만큼 떨어져 있다
    System.out.println(str1.concat("world")); // 연결 => concat
    System.out.println(str1.contains("hell")); // true ,가지고 있어서
    System.out.println(str1.startsWith("e")); // false , 시작하는 글자
    System.out.println(str1.endsWith("lo")); // true , 끝나는 글자
    System.out.println(str1.indexOf("el")); // 1, 위치하는 순서
    System.out.println(str1.indexOf("l")); // 2, 위치하는 순서(맨앞의것을 나타내줌)
    System.out.println(str1.indexOf('l',3)); // 3, 위치하는 순서(맨 뒤에 것을 나타내줌)
    System.out.println(str1.lastIndexOf("l")); // 3, 위치하는 순서(맨 뒤에것을 나타내줌)
    System.out.println(str1.lastIndexOf("el")); //1, 위치하는 순서
    System.out.println(str1.replace("l","k")); //hekko, l을 k로 바꿔줌

  }
}
