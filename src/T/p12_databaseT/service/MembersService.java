package T.p12_databaseT.service;

import T.p12_databaseT.dao.MembersDAOT;
import T.p12_databaseT.vo.MembersT;

import java.util.ArrayList;

public class MembersService {
  private MembersDAOT membersDAOT = new MembersDAOT();

  public ArrayList<MembersT> getList() {
    ArrayList<MembersT> result = null;
    result = membersDAOT.getList();
    return result;
  }
  public void deleteMembers(int mno) {
    membersDAOT.deleteMembers(mno);
  }

  public MembersT loginCheck(String id, String pass) {
    return membersDAOT.loginCheck(id, pass);
  }

  public boolean insertMembers(MembersT membersT) {
    return membersDAOT.insertMembers(membersT);
  }
  public boolean isDuplicatedId(String id) {
    return membersDAOT.isDuplicateId(id);
  }

}