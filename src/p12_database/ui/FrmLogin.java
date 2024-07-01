package p12_database.ui;

import javax.swing.*;

public class FrmLogin extends FrmBasic {
  private JLabel lbLogin, lbId, lbPass;
  private JTextField tfId;
  private JPasswordField pfPass;
  private JButton btnLogin, btnJoin, btnClose;

  public FrmLogin(String title, int width, int height) {
    super(title, width, height); // super을 써서  FrmBasic에 있는 init(); arrange(); inflate(); 을 불러온다
  }

  @Override
  public void init() {

  }

  @Override
  public void arrange() {

  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
