package p05_Inherit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex10Modifier {
  // 접근 제어자(Access Modifier) : public, protectd, default, private
  public String publicVar;
  protected String ProtectedVar;
  String defaultVar;
  private String privateVar;

// 자바에서 상수는 변경되지 않는 값
  public static void main(String[] args) {
    // private int num = 1 ; 지역변수는 접근 제어자 사용불가
    // 지역변수를 익명개체에서 쓸때 final 붙일 것, java8부터 안붙여도 됨
    final int result = 10;
    new JButton().addActionListener(new ActionListener() { // 익명개체
      @Override
      public void actionPerformed(ActionEvent e)
      {
        System.out.println(result);
        // result = 10; // 지역변수는  익명개체에서 변경 불가
      }
    });
    FinalClass finalClass = new FinalClass();
    System.out.println(finalClass);
  }
}

//final이 class 앞에 붙어있을때는 제어자는 상속이 되지 않는다.
final class FinalClass {}
// class FinalParents extends  FinalClass {}
class ModifierTest {}