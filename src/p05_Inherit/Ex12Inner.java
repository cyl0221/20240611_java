package p05_Inherit;

public class Ex12Inner {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner oi = new Outer().new Inner();
    System.out.println(oi.iv);
    Outer.InnerStatic ois = new Outer.InnerStatic();
    System.out.println(ois.isv);
    Outer.InnerInterface oii = new Outer.InnerInterface() {
// 객체가 인터페이스로 형변환 된 것임.
      @Override
      public void innerMethod() {

      }
    };
    // 추상클래스 와 인터페이스는 불안정하니 인스턴스가 만들 수 없음.
  }
}

class Outer {
   class Inner {
    int iv = 100;
  }
  static class InnerStatic {
     int isv = 200;
  }
  void outerMethod () {
    class localInner {
      int localInnerVar = 300;
    }
  }
  interface InnerInterface {
     void innerMethod();
  }
}