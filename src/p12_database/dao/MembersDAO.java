package p12_database.dao;

import p12_database.vo.Members;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MembersDAO extends DAOSet {
  public Members loginCheck(String id, String pass) {
    Members members = null;
    try {
      conn = connectDB();
      String sql = "select *from members where id=? and pass=? ";


      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        members = new Members(rs.getLong("mno"),
            rs.getString("id"), rs.getString("pass"),
            rs.getString("name"), rs.getString("mobile"));

      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return members;
  }

  public boolean insertMembers(Members members) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "insert into members(mno, id, pass, name, mobile)" +
          "VALUES(sq_members.nextval,?,?,?,?)";


      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, members.getId());
      pstmt.setString(2, members.getPass());
      pstmt.setString(3, members.getName());
      pstmt.setString(4, members.getMobile());
      int cnt =pstmt.executeUpdate();
      if (cnt>0)  result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }
  public boolean updateMember(Members member) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "UPDATE members SET pass=?, name=?, mobile=? WHERE mno=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, member.getPass());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getMobile());
      pstmt.setLong(4, member.getMno());
      int cnt = pstmt.executeUpdate();
      if (cnt > 0) {
        result = true;
      } else {
        System.out.println("No rows updated. Check if mno is correct: " + member.getMno());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }
  public boolean deleteMember(long mno) {
    String query = "DELETE FROM Members WHERE mno = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
      pstmt.setLong(1, mno);
      int affectedRows = pstmt.executeUpdate();
      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  private Connection getConnection() {
    return null;
  }
  public ArrayList<Members> getList() {
    ArrayList<Members> result = new ArrayList<>();
    try {
      conn = connectDB();
      String sql = "select * from members ";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Members m = new Members(
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


}
