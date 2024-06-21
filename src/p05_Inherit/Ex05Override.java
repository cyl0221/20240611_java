package p05_Inherit;

import java.util.Objects;

public class Ex05Override {
  public static void main(String[] args) {
    Data d1 = new Data(1); // 인스턴스에 대한 변수를 d1으로
    Data d2 = new Data(1);
    System.out.println(d1);
    System.out.println(d2);
    // if(d1==d2) System.out.println("같다"); //오류 ! hashcode가 다름
    if (d1.equals(d2)) System.out.println("같다");

  }
}


class Data {
  int value;

  public Data(int value) {
    this.value = value;
  }

  public String toString() {return "value:" + value;} // toString 을 써주니 주소값이 아닌, 값이 나온다.
  // @Override(생략도 가능)
  public boolean equals(Object obj) {
    //obj.value //오류! value 를 받을 수 없다.
    if (obj instanceof Data) {
      Data d = (Data) obj;
      return value == d.value;
    }
    return false;
  }

  @Override
  public int hashCode() {
    // hashcode의 값이 동일할때
    return Objects.hash(value);
  }
}