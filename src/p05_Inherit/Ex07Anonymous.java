package p05_Inherit;

public class Ex07Anonymous {
  public static void main(String[] args) {
      MyButton myButton = new MyButton();
      Clickable clickable = new Clickable() {
    // interface를 완성시켜 instance를 만든다
        @Override
        public void click() {
          System.out.println("click"); //이름이 없는 개체
        }
      };
  }
}

class MyButton implements Clickable {
  @Override
  public void click() {
  }
}
interface Clickable{
  void click();
}
