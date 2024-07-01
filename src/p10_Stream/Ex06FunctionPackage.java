package p10_Stream;

import java.util.function.Supplier;

public class Ex06FunctionPackage {
  // 일반적으로 자주 쓰이는 method 형식 4가지를 @FunctionalInterface형태로 만듦.
  public static void main(String[] args) {
    Supplier<Integer> supplier = new Supplier<Integer>() {
      @Override
      public Integer get() { // 매개변수가 없으니 lambda식에서 () 를 써줘야 한다
        return (int) (Math.random() *100) +1;
      }
    };
    supplier = () -> (int) (Math.random() *100) +1; // return은 생략가능
  }
}
