package T.p12_databaseT.controller;

import T.p12_databaseT.ui.FrmJoinT;
import T.p12_databaseT.ui.FrmLoginT;
import T.p12_databaseT.ui.FrmMainT;
import T.p12_databaseT.ui.FrmModifyT;
import T.p12_databaseT.vo.MembersT;

import javax.swing.*;
import java.util.HashMap;

public class MainController {

  private MembersT session;
  private static MainController mainController;
  private MembersService membersService = new MembersService();


  private MainController() {
  }

  public static MainController getInstance() { //sington
    if (mainController == null) mainController = new MainController();
    return mainController;
  }

  public MembersT getSession() {
    return session;
  }

  public void setSession(MembersT session) {
    this.session = session;
  }

  public void dispatchCmd(String request, HashMap map) {
    if (request.equals("Join")) {
      new FrmJoinT();
    } else if (request.equals("getMainList")) {
      new FrmMainT(membersService.getList());
    } else if (request.equals("Main")) {
      FrmMainT(membersService.getList());
    } else if (request.equals("Modify")) {
      JFrame fr = (JFrame) map.get("owner");
      MembersT membersT = (MembersT) map.get("members");
      boolean modal = (boolean) map.get("modal");
      new FrmModifyT(fr, membersT, modal);
    } else {
      new FrmLoginT();
    }
  }
}