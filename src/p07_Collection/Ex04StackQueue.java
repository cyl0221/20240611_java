package p07_Collection;

import java.util.*;

public class Ex04StackQueue {
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(0);stack.push(1);stack.push(2);
    System.out.println(stack);
    System.out.println(stack.size());
    System.out.println(stack.contains(1));
    System.out.println(stack.pop()); // 끝에 있는것 확인 및 지운다.
    System.out.println(stack.peek()); //끝에 있는거 확인
    System.out.println(stack);
    System.out.println(stack.empty());

    Queue q = new LinkedList();
    q.offer("a");q.offer("b");q.offer("c");
    System.out.println(q);
    System.out.println(q.poll()); // 앞에 있는거 확인 및 지운다
    System.out.println(q.peek()); // 앞에 있는거 확인
    System.out.println(q);

    // collection 이전에 나온 버전(동기화 포함)
    Vector v = new Vector(); //동기화 포함 <-> collection 은 동기화 불포함
    v.add(0);v.add("a");v.add(true);
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    e = v.elements();//다시 사용하려고 할 때
    Iterator it = v.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    it = v.iterator(); // 다시 사용하려고 할때
  }
}
