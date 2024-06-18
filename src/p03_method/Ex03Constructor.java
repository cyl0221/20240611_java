package p03_method;

public class Ex03Constructor {
  public static void main(String[] args) {
    Car gv70 = new Car("gv70", "white", "HD");
    // gv70.setColor("white");
    System.out.println(gv70.getColor());
  }
}

// 시점의 차이?!
class Car {
  // 생성자는 없어도 기본 생성자가 자동으로 생성
  // 생성자는 new에 의해서 인스턴스 생성
  // 생성자도 Overloading  이 된다.
  // 사용자가 생성자를 등로하면 기본 생성자는 자동 추가 안됨
  public Car() {
    this("Gv80","white","hd");
  }

  // 매개변수에 들어와있는 변수들 ex) model, color, maker
  public Car(String model, String color, String maker) { // 생성자
    this.model = model;
    this.color = color;
    this.maker = maker;  // this 는 자신이 속한 class

  }
  // this () 소괄호 :: 생성자
  // this . 점 :: 속성
  // this 는 자신이 속한 class

  // 아래내용처럼 안쓰고 위에 넣는다
    /*private String model = "gv70";
    private String color ="white";
    private String maker = "HD";
*/
  private String model;
  private String color;
  private String maker;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }
}
