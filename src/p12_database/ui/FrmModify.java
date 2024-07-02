package p12_database.ui;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import javax.swing.*;
import java.awt.*;

public class FrmModify<FrmMain> extends JFrame {
  private JLabel lbName, lbId, lbPass, lbMobile;
  private JTextField tfName, tfId, tfMobile;
  private JPasswordField pfPass;
  private JButton btnSave, btnCancel;
  private JPanel pnlCenter, pnlSouth;
  private Members member;
  private final FrmMain frmMain;

  public FrmModify(Members member, FrmMain frmMain) {
    this.member = member;
    this.frmMain = frmMain;
    setTitle("회원정보 수정");
    setSize(300, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    init();
    arrange();
    inflate();
  }


  private void init() {
    lbName = new JLabel("NAME");
    lbId = new JLabel("ID");
    lbPass = new JLabel("Pass");
    lbMobile = new JLabel("MOBILE");

    tfName = new JTextField(member.getName(), 20);
    tfId = new JTextField(member.getId(), 20);
    tfId.setEditable(false); // ID는 수정 불가
    tfMobile = new JTextField(member.getMobile(), 20);
    pfPass = new JPasswordField(member.getPass(), 20);

    btnSave = new JButton("저장");
    btnCancel = new JButton("취소");

    btnSave.addActionListener(e -> saveChanges());
    btnCancel.addActionListener(e -> dispose());
  }

  private void arrange() {
    pnlCenter = new JPanel(new GridLayout(4, 2, 10, 10));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlCenter.add(lbName); pnlCenter.add(tfName);
    pnlCenter.add(lbId); pnlCenter.add(tfId);
    pnlCenter.add(lbPass); pnlCenter.add(pfPass);
    pnlCenter.add(lbMobile); pnlCenter.add(tfMobile);

    pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    pnlSouth.add(btnSave); pnlSouth.add(btnCancel);

    add(pnlCenter, BorderLayout.CENTER);
    add(pnlSouth, BorderLayout.SOUTH);
  }

  private void inflate() {
    setVisible(true);
  }

  private void saveChanges() {
    if (!isEmpty(tfName.getText()) && !isEmpty(new String(pfPass.getPassword())) && !isEmpty(tfMobile.getText())) {
      member.setName(tfName.getText());
      member.setPass(new String(pfPass.getPassword()));
      member.setMobile(tfMobile.getText());

      MembersDAO dao = new MembersDAO();
      if (dao.updateMember(member)) {
        JOptionPane.showMessageDialog(this, "수정 완료", "정보 수정", JOptionPane.INFORMATION_MESSAGE);
        dispose();
      } else {
        JOptionPane.showMessageDialog(this, "수정 실패", "정보 수정", JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(this, "모든 칸을 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
    }

  }
  private boolean isEmpty(String text) {
    return text == null || text.trim().isEmpty();
  }
}