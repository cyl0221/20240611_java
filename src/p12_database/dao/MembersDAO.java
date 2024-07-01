package p12_database.dao; // 패키지 선언: 현재 클래스가 속한 패키지를 지정합니다.

import p12_database.vo.Members; // Members 클래스를 임포트: Members 객체를 사용하기 위해 임포트합니다.
import java.sql.SQLException; // SQLException 클래스를 임포트: SQL 관련 예외 처리를 위해 사용됩니다.

public class MembersDAO extends DAOSet{ // MembersDAO 클래스 선언: DAOSet 클래스를 상속받습니다.
  public Members loginCheck(String id, String pass) { // loginCheck 메서드 선언: 사용자의 ID와 비밀번호를 확인합니다.
    Members members = null; // Members 객체를 초기화: 로그인 정보가 일치하면 해당 객체에 값을 할당합니다.
    try {
      conn = connectDB(); // 데이터베이스 연결: DB 연결을 위한 메서드를 호출합니다.
      String sql = "select *from members where id=? and pass=? "; // SQL 쿼리 작성: ID와 비밀번호를 기준으로 회원 정보를 조회합니다.
      pstmt =conn.prepareStatement(sql); // PreparedStatement 객체 생성: SQL 쿼리를 실행할 준비를 합니다.
      pstmt.setString(1, id); // 첫 번째 매개변수 설정: SQL 쿼리의 첫 번째 '?'에 ID 값을 설정합니다.
      pstmt.setString(2, pass); // 두 번째 매개변수 설정: SQL 쿼리의 두 번째 '?'에 비밀번호 값을 설정합니다.
      rs = pstmt.executeQuery(); // SQL 쿼리 실행: 쿼리를 실행하고 결과 집합(ResultSet)을 반환합니다.
      if (rs.next()){ // 결과 집합의 첫 번째 행이 존재하는지 확인: 존재하면 true를 반환합니다.
        members = new Members(rs.getLong("mno"),
            rs.getString("id"), rs.getString("pass"),
            rs.getString("name"),rs.getString("mobile")); // Members 객체 생성: 결과 집합의 값을 사용해 Members 객체를 생성합니다.
      }
    } catch (SQLException e) { // 예외 처리: SQL 예외가 발생하면 RuntimeException으로 감싸서 던집니다.
      throw new RuntimeException(e); // 발생한 예외를 RuntimeException으로 던짐
    } finally { // 항상 실행되는 블록: 예외 발생 여부에 상관없이 실행됩니다.
      closeDB(); // 데이터베이스 연결 닫기: DB 리소스를 정리하고 닫습니다.
    }
    return members; // Members 객체 반환: 로그인 정보가 일치하는 사용자의 정보를 담은 Members 객체를 반환합니다.
  }
}
