package p08_IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05Notepad {
  public static void main(String[] args) {
  new Notepad();
  }
}

class Notepad extends JFrame {
 private JMenuBar menuBar;
 private JMenu menuF, menuE, menuO, menuV, menuH;
 private JMenuItem miNew, miOpen, miSave, miExit, miInfo;
 private JTextArea textArea;
private JScrollPane scp;
 //constuctor
  public Notepad() throws HeadlessException {
    init(); arrange(); inflate();
  }
  // window의 구성품을 초기화
  private void init() {
    menuBar = new JMenuBar();
    menuF = new JMenu("파일(F)");menuE = new JMenu("편집(E)");
    menuO = new JMenu("서식(O)");menuV = new JMenu("보기(V)");
    menuH = new JMenu("도움말");
    miNew = new JMenuItem("새로 만들기(N)");
    miOpen = new JMenuItem("열기(O)");
    miSave = new JMenuItem("저장(S)");
    miExit = new JMenuItem("끝내기(X)");
    miInfo = new JMenuItem("정보(A)");
    textArea = new JTextArea();
    scp = new JScrollPane(textArea);
    miNew.addActionListener(e -> {
      textArea.setText("");
      //miNew.addActionListener(e -> textArea.setText(""));//lambda 방식
    });
  }
  // 배치하는 method
  private void arrange() {
    menuF.add(miNew);menuF.add(miOpen);menuF.add(miSave);
    menuF.add(miExit);menuH.add(miInfo);
  menuBar.add(menuF);menuBar.add(menuE);menuBar.add(menuO);
  menuBar.add(menuV);menuBar.add(menuH);
  setJMenuBar(menuBar);
  add(scp); //jframe을 상속받음
  }
  //나타나게 하는 method
  private void inflate() {
    setTitle("나의 메모장");
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 끄면 종료된다.
    setLocationRelativeTo(this);  // 창이 가운데로 열린다.
    setVisible(true); // 창이 보인다.
  }
}
// 이 뒤에 메모내용 저장하고, 불러오기를 만든다.