package T.p12_databaseT.ui;

import T.p12_databaseT.dao.MembersDAOT;
import T.p12_databaseT.vo.MembersT;
import p12_database.vo.Members;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrmModifyT extends JDialog {
  private JPanel pnlCenter, pnlSouth;
  private JTextField tfId, tfName, tfMobile;
  private JPasswordField pfPass;
  private JButton btnJoin, btnClose, btnModify;
  private JLabel[] labels;
  private String[] strings;
  private MembersT membersT;

  public FrmModifyT(JFrame jFrame, MembersT membersT, boolean modal) {
    super(jFrame, "회원번호 " + membersT.getMno()+"번의 수정",true);
    this.membersT = membersT;
    init();arrange();inflate();
  }

  public void init() {
    strings = new String[] {"ID", "Password", "Name", "Mobile"};
    labels = new JLabel[strings.length];
    pnlCenter = new JPanel(new GridLayout(strings.length, 2));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0,30,20,30));
    pnlSouth = new JPanel();
    for (int i = 0; i < strings.length; i++) {
      labels[i] = new JLabel(strings[i]);
    }
    //초기화
    tfId = new JTextField(10); tfName = new JTextField(10);
    tfMobile = new JTextField(10); pfPass = new JPasswordField(10);
    //값을 넣을수있는곳
    tfId.setText(membersT.getId());
    tfName.setText(membersT.getName());
    tfMobile.setText(membersT.getMobile());
    pfPass.setText(membersT.getPass());
    tfId.setEditable(false);

    btnModify = new JButton("수정"); btnClose = new JButton("닫기");
    btnModify.addActionListener(e -> {
      String id = tfId.getText();
      String pw = new String(pfPass.getPassword());
      String name = tfName.getText();
      String mobile = tfMobile.getText();
      if (id.equals("")) {
        JOptionPane.showMessageDialog(this, "ID를 확인하세요");
        tfId.requestFocus();
        return;
      }
      if (id.equals("")) {
        JOptionPane.showMessageDialog(this, "Password를 확인하세요");
        tfId.requestFocus();
        return;
      }
      if (id.equals("")) {
        JOptionPane.showMessageDialog(this, "이름를 확인하세요");
        tfId.requestFocus();
        return;
      }
      if (id.equals("")) {
        JOptionPane.showMessageDialog(this, "Mobile를 확인하세요");
        tfId.requestFocus();
        return;
      }
      // 유효성검사를 완성하세요!!
      boolean result =
          new MembersDAOT().updateMembers(new MembersT(membersT.getMno(), id, pw, name, mobile));
      if (result) {
        JOptionPane.showMessageDialog(this, "수정되었습니다.");
        tfName.setText("");
        tfId.setText("");
        pfPass.setText("");
        tfMobile.setText("");
      } else {
        JOptionPane.showMessageDialog(this, "수정 실패하였습니다.");
      }

    });

    btnClose.addActionListener(e -> dispose());
  }

  public void arrange() {
    pnlCenter.add(labels[0]); pnlCenter.add(tfId);
    pnlCenter.add(labels[1]); pnlCenter.add(pfPass);
    pnlCenter.add(labels[2]); pnlCenter.add(tfName);
    pnlCenter.add(labels[3]); pnlCenter.add(tfMobile);
    add(pnlCenter, "Center");

    pnlSouth.add(btnModify);   pnlSouth.add(btnClose);
    add(pnlSouth, "South");
  }

  public void inflate() {
    setSize(250, 300);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // JDialog ::  종료가 안됨
    setLocationRelativeTo(this);
    setVisible(true);
  }
}