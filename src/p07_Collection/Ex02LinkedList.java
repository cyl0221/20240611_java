package p07_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex02LinkedList {
  public static void main(String[] args) {
    List al = new ArrayList();
    List ll = new LinkedList();

    System.out.println("====순차적 추가====");
    System.out.println("ArrayList : " + addSequentially(al));
    System.out.println("LinkedList : " + addSequentially(ll));

  }

  private static long addSequentially(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      list.add(i + "");
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private static long addMiddle(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.add(5000, i + "");
    }
    long end = System.currentTimeMillis();
    return end - start;
  }
  private static long removeSequentially(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = list.size(); i >=0; i--) {
      list.remove(i); //index로 지움
    }
    long end = System.currentTimeMillis();
    return end - start;
  }
  private static long removeMiddle(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i <10000; i++) {
      list.remove(i); //index로 지움
    }
    long end = System.currentTimeMillis();
    return end - start;
  }
}
