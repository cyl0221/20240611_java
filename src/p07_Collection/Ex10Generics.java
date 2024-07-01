package p07_Collection; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스 임포트
import java.util.Arrays;    // Arrays 클래스 임포트
import java.util.Collection; // Collection 인터페이스 임포트
import java.util.function.IntFunction; // IntFunction 인터페이스 임포트

public class Ex10Generics { // Ex10Generics 클래스 정의
  public static void main(String[] args) { // main 메서드 시작

    // Generics 사용목적
    // 1) 형변환 코드를 생략하여 간결해짐.
    // 2) 타입의 안정성을 도모.

    // ArrayList<Card> list = new ArrayList();  --(1) generics 미사용 예시
    ArrayList<Card<Integer, String, Object>> list = new ArrayList<>();  // --(2) generics 사용, Card 타입의 리스트 생성
    list.add(new Card<>(1, "spade", "rect"));  // 리스트에 Card 객체 추가
    list.add(new Card<>(2, "spade", 2));  // 리스트에 Card 객체 추가
    list.add(new Card<>(3, "spade", true));  // 리스트에 Card 객체 추가
    list.add(new Card<>(4, "spade", new Object()));  // 리스트에 Card 객체 추가
    list.add(new Card<>(5, "spade", 'A'));  // 리스트에 Card 객체 추가
    list.add(new Card<>(1, "spade", "rect"));

/*    카드 번호: 1
    카드 타입: spade
    카드 도형: rect (문자열)
    의미: 번호가 1이고 타입이 spade인 카드이며, 도형 정보로 rect를 가짐
    list.add(new Card<>(2, "spade", 2));

    카드 번호: 2
    카드 타입: spade
    카드 도형: 2 (정수)
        의미: 번호가 2이고 타입이 spade인 카드이며, 도형 정보로 숫자 2를 가짐
    list.add(new Card<>(3, "spade", true));

    카드 번호: 3
    카드 타입: spade
    카드 도형: true (불리언 값)
    의미: 번호가 3이고 타입이 spade인 카드이며, 도형 정보로 true를 가짐
    list.add(new Card<>(4, "spade", new Object()));

    카드 번호: 4
    카드 타입: spade
    카드 도형: Object 객체
    의미: 번호가 4이고 타입이 spade인 카드이며, 도형 정보로 새로운 Object 객체를 가짐
    list.add(new Card<>(5, "spade", 'A'));

    카드 번호: 5
    카드 타입: spade
    카드 도형: 'A' (문자)
        의미: 번호가 5이고 타입이 spade인 카드이며, 도형 정보로 문자 'A'를 가짐*/



    // Card card = (Card) list.get(0); // 모든 collection의 element 타입은 Object  --(1) generics 미사용
    Card<Integer, String, Object> card = list.get(0);   // generics 사용으로 형변환 생략 가능

    // 배열을 List 타입으로 변경하는 3가지 방법
    // Card[] cards0 = list.toArray(new Card[list.size()]); //Java8 이전
    // Card[] cards0 = list.stream().toArray(Card[]::new); //Java8 이후

    Card[] cards = list.toArray(Card[]::new); // Java 11 이후, 이거를 풀어쓰면 밑에 내용
    /* Card[] cards = list.toArray(new IntFunction<Card[]>() { // Java 11 이후, IntFunction 사용
      @Override
      public Card[] apply(int value) { // 배열 크기만큼의 Card 배열 생성
        // 배열을 가리키는 참조변수는 null대신 길이가 0인 배열로 초기화,
        System.out.println(">>" + value); // 디버깅을 위한 출력문, 여기서 value는 배열의 크기
        return new Card[value]; // 새로운 Card 배열을 반환
      }
    });*/
    // 주석 처리된 부분은 위의 간단한 코드(Card[] cards = list.toArray(Card[]::new);)를 풀어 쓴 형태입니다.
    // Java 11에서 추가된 람다식을 사용한 방법을 설명하는데,
    // IntFunction은 배열의 크기를 인수로 받아 해당 크기의 배열을 생성하여 반환하는 함수형 인터페이스입니다.
    // 이 방식을 사용하면 리스트의 크기만큼의 배열을 동적으로 생성할 수 있습니다.

    Deck<Card<Integer, String, Object>> deck = new Deck<>(); // Deck 클래스의 인스턴스 생성
    deck.set(cards); // Deck 인스턴스에 cards 배열 설정
    deck.print(); // Deck 내용 출력
  }
}

class Card<K, V, G> { // Card 클래스 정의
  private K num; // 카드 번호를 저장하는 필드
  private V type; // 카드 타입을 저장하는 필드
  private G fig; // 카드 도형을 저장하는 필드

  public Card(K num, V type, G fig) { // 생성자, 카드 번호와 타입, 도형을 초기화
    this.num = num;
    this.type = type;
    this.fig = fig;
  }

  public void setKVG(K num, V type, G fig) { // 카드 번호, 타입, 도형을 설정하는 메서드
    this.num = num;
    this.type = type;
    this.fig = fig;
  }

  public String toString() { // 카드 번호와 타입을 문자열로 반환
    return num + "/" + type;
  }
}

class Deck<T> { // Deck 클래스 정의, 제네릭 타입 T 사용
  T[] deck; // Card 배열 대신 제네릭 타입 배열 사용

  void set(T[] deck) { // deck 배열을 설정하는 메서드
    this.deck = deck;
  }

  void print() { // deck 배열을 출력하는 메서드
    for (int i = 0; i < deck.length; i++) { // 배열의 각 요소를 순회
      if (i != 0) System.out.println(", "); // 첫 요소가 아닐 때 콤마 출력
      System.out.println(deck[i]); // 요소 출력
    }
    System.out.println(); // 줄 바꿈
  }
}
