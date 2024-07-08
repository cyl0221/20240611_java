package T.p12_databaseT.controller;

import T.p12_databaseT.service.MembersService;
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

  public static MainController getInstance() { //sington :: 한개의 인스턴스만 만들수있음, session 때문에 sington 패턴이 필요함, session과 함께 controller에 저장
    if (mainController == null) mainController = new MainController();
    return mainController;
  }

  public void setSession(MembersT session) {
    this.session = session;
  }

  public MembersT getSession() {return session;}
  public MembersService getMembersService(){return membersService;}

  public void dispatchCmd(String request, HashMap map) {
    if (request.equals("Join")) {
      new FrmJoinT();
    } else if (request.equals("getMainList")) {
      new FrmMainT();
    } else if (request.equals("Main")) {
      new FrmMainT();
    }  else if (request.equals("Modify")) {
      JFrame fr = (JFrame) map.get("owner");
      MembersT membersT = (MembersT) map.get("membersT");
      boolean modal = (boolean) map.get("modal");
      new FrmModifyT(fr,membersT,modal);
    } else {
      new FrmLoginT();
    }
  }
}
