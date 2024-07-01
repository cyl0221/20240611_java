package p11_network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ex01TcpipMultiChatClient extends JFrame {
  public static void main(String[] args) {
    new Ex01TcpipMultiChatClient();
  }

  private JTextArea ta;
  private JScrollPane scp;
  private JTextField tf;
  private String nickname;
  private DataOutputStream out;

  public Ex01TcpipMultiChatClient() throws HeadlessException {
    init();
    arrange();
    inflate();
  }

  private void init() {
    nickname = JOptionPane.showInputDialog("Input Nickname");
    String ip = JOptionPane.showInputDialog("Server IP", "10.100.204.26");

    ta = new JTextArea();
    ta.setEditable(false); //setEditable 수정가능여부
    scp = new JScrollPane(ta);
    tf = new JTextField();
    ta.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    try {
      // ip로 부터 소켓 열었다.
      Socket socket = new Socket(ip, 7777);
      // 소켓(네트워크로나가는 문)으로부터 outstream  생성, 외부로 나갈 수 있는 흐름이 만들어진 것
      out = new DataOutputStream(socket.getOutputStream());
      out.writeUTF(nickname);
       new Thread(new Receiver(socket)).start(); //  implement Runnable일때
      // 소켓은 하나만 있어야 하는데, 보내는것 썼고, 받는것도 써야하는데 같은 소켓을 사용한다.
      // receiver 에 써주고
      // new Receiver().start(); extends Thread

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    tf.addActionListener(new ActionListener() { // 익명개체
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          /*String sendMsg = tf.getText();
          if(sendMsg.equals("")) return;
          ut.writeUTF(nickname + ":" + sendMsg);*/
          out.writeUTF(nickname + ":" + tf.getText());
          tf.setText(""); // 채팅창에 입력하고 자동으로 공백처리됨
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void arrange() {
    add(scp, "Center");
    add(tf, "South");
  }

  private void inflate() {
    setTitle("Chatting Room");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this); // 모니터 가운데로 위치
    setVisible(true); // 창의 유무
  }

   class Receiver implements Runnable {
 // class Receiver extends Thread {
  DataInputStream in;

    public Receiver(Socket socket) {
      try {
        in = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void run() {
    while (in != null) { // 꺼지면 소켓이 끊어진다.
      try {
        String message = in.readUTF();
        /*
        String msg = in.readUTF();
        System.out.println(msg);
        ta.append(msg+"/n");
        ta.setCaretPosition(ta.getDocument().getLength());*/
        SwingUtilities.invokeLater(() -> ta.append(message + "\n")); //
      } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
    }
  }
}

