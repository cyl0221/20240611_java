package T.p12_databaseT;

import T.p12_databaseT.controller.MainController;
import T.p12_databaseT.ui.FrmLoginT;
import T.p12_databaseT.vo.MembersT;

public class MemberManagementT {
  public static void main(String[] args) {
    MainController.getInstance().dispatchCmd("Main",null);
  }
}
