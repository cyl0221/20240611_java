package p05_Inherit;

public class Ex12Inner {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner oi = new Outer().new Inner();
    System.out.println(oi.iv);
    Outer.InnerStatic ois = new Outer.InnerStatic();
    System.out.println(ois.isv);
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
}