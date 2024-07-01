package p07_Collection;

import java.util.ArrayList;

public class Ex10Generics {
  public static void main(String[] args) {


  // Generics 사용목적
  //1) 형변환 코드를 생략하여 간결해짐.
  //2) 타입의 안정성을 도모.

//    ArrayList list = new ArrayList(); --(1) generics 미사용
    ArrayList<Card> list = new ArrayList();  // --(2)  generics 사용
    list.add(new Card(1));
    list.add(new Card(2));
    list.add(new Card(3));
    list.add(new Card(4));
    list.add(new Card(5));
    // Card card = (Card) list.get(0); //모든  collection의 element 타입은 Object  --(1) generics 미사용
    Card card = list.get(0);   // 모든 collection의 element 타입은 Object --(2) generics 사용
  }
}

class Card {
  private int num;
  public Card(int num) {this.num = num;} // 생성자
}
