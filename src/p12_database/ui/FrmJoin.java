package p12_database.ui;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import javax.swing.*;
import java.awt.*;

public class FrmJoin extends p12_database.ui.FrmBasic {
  private JLabel lbJoin, lbName, lbID, lbPass, lbMobile;
  private JTextField tfName, tfId, tfMobile;
  private JPasswordField pfPass;
  private JButton btnJoin, btnLogin;
  private JPanel pnlCenter, pnlSouth;

  public FrmJoin(String title, int width, int height) {
    super(title, width, height);
  }

  @Override
  public boolean init() {
    lbJoin = new JLabel("Join");
    lbJoin.setFont(new Font("맑은 고딕", Font.BOLD | Font.CENTER_BASELINE, 30));
    lbJoin.setHorizontalAlignment(JLabel.CENTER);
    lbJoin.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    lbName = new JLabel("NAME");
    lbID = new JLabel("ID");
    lbPass = new JLabel("Pass");
    lbMobile = new JLabel("MOBILE");

    tfName = new JTextField(20);
    tfId = new JTextField(20);
    tfMobile = new JTextField(20);
    pfPass = new JPasswordField(20);

    btnJoin = new JButton("가입");
    btnLogin = new JButton("로그인");

    pnlCenter = new JPanel(new GridLayout(4, 2, 10, 10));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
    pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    tfName.addActionListener(e -> {
      if (!isEmptyName()) tfId.requestFocus();
      else {
        showWarning("이름을 입력하세요.");
      }
    });
    tfId.addActionListener(e -> {
      if (!isEmptyId()) {
        pfPass.requestFocus();
      } else {
        showWarning("아이디를 입력하세요.");
      }
    });
    pfPass.addActionListener(e -> {
      if (!isEmptyPass()) {
        tfMobile.requestFocus();
      } else {
        showWarning("비밀번호를 입력하세요.");
      }
    });

    tfMobile.addActionListener(e -> {
      if (!isEmptyMobile()) {
        btnJoin.requestFocus();
      } else {
        showWarning("전화번호를 입력하세요.");
      }
    });
    btnJoin.addActionListener(e -> {
      if (!isEmptyName() && !isEmptyId() && !isEmptyPass() && !isEmptyMobile()) {
        boolean isRegistered = registerMember
            (tfName.getText(), tfId.getText(), new String(pfPass.getPassword()), tfMobile.getText());
        if (isRegistered) {
          JOptionPane.showMessageDialog
              (this, "가입에 성공했습니다!", "가입 완료", JOptionPane.INFORMATION_MESSAGE);
          clearFields(); // 성공시 입력 필드 초기화
          } else  JOptionPane.showMessageDialog
            (this, "회원가입 실패", "회원가입 실패", JOptionPane.INFORMATION_MESSAGE);
      } else {
        JOptionPane.showMessageDialog
            (this, "모든 칸을 입력하세요.", "가입 불가", JOptionPane.WARNING_MESSAGE);
      }
    });

    btnLogin.addActionListener(e -> {
      dispose();
      new p12_database.ui.FrmLogin("로그인",400,300).setVisible(true);
    });
    return true;
  }


  private void clearFields() {
    tfName.setText("");
    tfId.setText("");
    tfMobile.setText("");
    pfPass.setText("");
  }

  private boolean registerMember(String name, String id, String pass, String mobile) {
    MembersDAO dao = new MembersDAO();
    Members member = new Members(id, pass, name, mobile);
    member.setName(name);
    member.setId(id);
    member.setPass(pass);
    member.setMobile(mobile);
    return dao.insertMembers(member);
  }

  private boolean isEmptyName() {
    return tfName.getText().trim().isEmpty();
  }

  private boolean isEmptyId() {
    return tfId.getText().trim().isEmpty();
  }

  private boolean isEmptyPass() {
    return new String(pfPass.getPassword()).trim().isEmpty();
  }

  private boolean isEmptyMobile() {
    return tfMobile.getText().trim().isEmpty();
  }
  private void showWarning(String message) {
    JOptionPane.showMessageDialog(this, message, "경고", JOptionPane.WARNING_MESSAGE);
  }
  @Override
  public void arrange() {
    add(lbJoin, "North");
    pnlCenter.add(lbName);
    pnlCenter.add(tfName);
    pnlCenter.add(lbID);
    pnlCenter.add(tfId);
    pnlCenter.add(lbPass);
    pnlCenter.add(pfPass);
    pnlCenter.add(lbMobile);
    pnlCenter.add(tfMobile);
    add(pnlCenter, "Center");
    pnlSouth.add(btnJoin);
    pnlSouth.add(btnLogin);
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
