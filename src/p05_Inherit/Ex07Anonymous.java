package p05_Inherit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    new MyFrame();
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
class MyFrame extends JFrame {
  public MyFrame() throws HeadlessException {
    setSize(300,200); //창의 크기
    setTitle("My Window"); //창의 이름
    setDefaultCloseOperation(EXIT_ON_CLOSE); //닫기 눌렀을때 종료된다.
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());// 레이아웃을 잡아주기 위한 것
    JButton jButton = new JButton("확인");
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
      }
    }); // 익명개체
    add(jButton);
    setVisible(true);
  }
}
