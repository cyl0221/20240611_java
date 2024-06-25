package p07_Collection;

import common.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.*;

public class Ex01List {
  public static void main(String[] args) {
    // 순서 있다. 중복 된다
    List list = new ArrayList();
    list.add(new Member("hgd", "1", "홍길동"));
    list.add(new Member("kgd", "1", "김길동"));
    list.add(new Member("jgd", "1", "정길동"));
    list.add(10); // 숫자도 추가 가능하다. element(요소) 타입이 object이기 때문에 다 추가 가능
    list.add(true);
    System.out.println(list);

    //1. for index
    for (int i = 0; i < list.size(); i++) {
      //System.out.println(list.get(i));
      Utils.typeOf(list.get(i));
    }

    //2. enhanced for
    for (Object o : list) {
      Utils.typeOf(o);
    }

    //3. iterator // 가르키다
    Iterator it = list.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }


    //4. foreach
    // 익명객체는 일회성, 참조할일 없는 경우
    list.forEach(new Consumer() {    //Consumer()안에 익명개체 //인터페이스를 주고 재정의한 상태?!
      @Override
      public void accept(Object o) {
        Utils.typeOf(o);
      }
    });
    list.forEach(o -> Utils.typeOf(o));
    // 클래스를 생성해야하는 경우, 참조할 경우가 있을 경우
    class ObjConsumer implements Consumer {
      String lists = ""; // 변수
      @Override
      public void accept(Object o) { // ctrl + o 눌러서 accept 선택
        lists += o;
        Utils.typeOf(o);
      }
    }
    ObjConsumer oc = new ObjConsumer();
    list.forEach(oc);//list.forEach(Consumer consumer) 인터페이스를 인플리먼트를한 클래스를 넣어주면된다.
    System.out.println(oc.lists);
    System.out.println(">>"+list.contains(10));
    list.addAll(new ArrayList(5));
    list.clear(); //모두삭제
    System.out.println(list);
    System.out.println(list.isEmpty()); // list 가 비어있는지 확인
    //System.out.println(list.get(0)); //type은 object
    //Utils.typeOf(list.get(0));
    List linkedList = new LinkedList();
  }
}

class Member {
  private String id;
  private String pass;
  private String name;

  public Member(String id, String pass, String name) {
    this.id = id;
    this.pass = pass;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("%s(ID: %s)", name, id); // member class에 toString으로 정의 해놨기 때문에,
  }
}
