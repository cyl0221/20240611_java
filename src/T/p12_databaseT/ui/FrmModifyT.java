package T.p12_databaseT.ui;

import T.p12_databaseT.dao.MembersDAOT;
import T.p12_databaseT.vo.MembersT;


import javax.swing.*;
import java.awt.*;

public class FrmModifyT extends JDialog {
  private JPanel pnlCenter, pnlSouth;
  private JTextField tfId, tfName, tfMobile;
  private JPasswordField pfPass;
  private JButton btnModify, btnClose;
  private JLabel[] labels;
  private String[] strings;
  private MembersT membersT;

  public FrmModifyT(JFrame jFrame, MembersT membersT, boolean modal) {
    super(jFrame, "회원번호 "+ membersT.getMno()+" 번의 수정", true);
    this.membersT = membersT;
    init();arrange();inflate();
  }

  public void init() {
    strings = new String[] {"ID", "Password", "Name", "Mobile"};
    labels = new JLabel[strings.length];
    pnlCenter = new JPanel(new GridLayout(strings.length, 2));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0,30, 20, 30));
    pnlSouth = new JPanel();
    for (int i = 0; i < strings.length; i++) {
      labels[i] = new JLabel(strings[i]);
    }
    tfId = new JTextField(10); tfName = new JTextField(10);
    tfMobile = new JTextField(10); pfPass = new JPasswordField(10);
    tfId.setText(membersT.getId());tfName.setText(membersT.getName());
    tfMobile.setText(membersT.getMobile());pfPass.setText(membersT.getPass());
    tfId.setEditable(false);
    btnModify = new JButton("수정"); btnClose = new JButton("닫기");
    btnModify.addActionListener(e -> {
      String id = tfId.getText();
      String pw = new String(pfPass.getPassword());
      String name = tfName.getText();
      String mobile = tfMobile.getText();
      if (id.equals("")) {
        JOptionPane.showMessageDialog(FrmModifyT.this, "ID를 확인하세요");
        tfId.requestFocus();
        return;
      }
      if (pw.equals("")) {
        JOptionPane.showMessageDialog(FrmModifyT.this, "Password를 확인하세요");
        pfPass.requestFocus();
        return;
      }
      if (name.equals("")) {
        JOptionPane.showMessageDialog(FrmModifyT.this, "이름을 확인하세요");
        tfName.requestFocus();
        return;
      }
      if (mobile.equals("")) {
        JOptionPane.showMessageDialog(FrmModifyT.this, "Mobile을 확인하세요");
        tfMobile.requestFocus();
        return;
      }
      // 유효성검사를 완성하세요!!
      boolean result =
          new MembersDAOT().updateMembers(new MembersT(membersT.getMno(), id, pw, name, mobile));
      if (result) {
        JOptionPane.showMessageDialog(FrmModifyT.this, "수정되었습니다.");
        tfName.setText("");tfId.setText("");pfPass.setText("");tfMobile.setText("");
      } else {
        JOptionPane.showMessageDialog(FrmModifyT.this, "수정 실패하였습니다.");
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
    setSize(250, 250);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }

}