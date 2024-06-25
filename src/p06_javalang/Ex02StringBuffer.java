package p06_javalang;

public class Ex02StringBuffer {
  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("hello");
    // String은 문자열 선언시 크기가 한정적
    // 문자열의 수정, 삽입, 삭제가 용이한 StringBuffer
    System.out.println(sb.length());
    System.out.println(sb.capacity()); //capacity 버퍼의 크기(용량)
    sb.append("world");
    System.out.println(sb);
    System.out.println(sb.hashCode());
    System.out.println(System.identityHashCode(sb));
    System.out.println(sb.delete(4,6)); // 4번째
    System.out.println(sb.reverse()); // 역순으로 나온다
    StringBuffer sb2 = new StringBuffer(
        "나랏말싸미 뒹국에 달아 백성이 이르고저 할배");
    System.out.println(sb2.reverse());
  }
}
