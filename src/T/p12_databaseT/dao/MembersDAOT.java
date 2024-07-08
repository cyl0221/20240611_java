package T.p12_databaseT.dao;

import T.p12_databaseT.vo.MembersT;


import java.sql.SQLException;
import java.util.ArrayList;

public class MembersDAOT extends DAOSetT {
  public MembersT loginCheck(String id, String pass) {
    MembersT membersT = null;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? and pass=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        membersT = new MembersT(rs.getLong("mno"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return membersT;
  }

  public MembersT getMembers(int mno) {
    MembersT membersT = null;
    try {
      conn = connectDB();
      String sql = "select * from members where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mno);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        membersT = new MembersT(rs.getLong("mno"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return membersT;
  }
  public boolean insertMembers(MembersT membersT) {
    boolean result = false;
    try {
      conn = connectDB();

      String sql = "insert into members(mno,id, pass, name, mobile) "
          + "VALUES(sq_membersT.nextval, ?, ?, ?, ?) ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, membersT.getId());
      pstmt.setString(2, membersT.getPass());
      pstmt.setString(3, membersT.getName());
      pstmt.setString(4, membersT.getMobile());
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean updateMembers(MembersT membersT) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "update members set pass=?, name=?, mobile=? where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, membersT.getPass());
      pstmt.setString(2, membersT.getName());
      pstmt.setString(3, membersT.getMobile());
      pstmt.setLong(4, membersT.getMno());
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean deleteMembers(int mno) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "delete members where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mno);
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public ArrayList<MembersT> getList() {
    ArrayList<MembersT> result = new ArrayList<>();
    try {
      conn = connectDB();
      String sql = "select * from members ";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        MembersT m = new MembersT(
            rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile"));
        result.add(m);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean isDuplicateId(String id) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }
}