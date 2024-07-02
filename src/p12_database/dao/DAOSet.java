package p12_database.dao; // 패키지 선언

import java.sql.*; // SQL 관련 클래스 임포트

public class DAOSet {
  // 데이터베이스 연결을 위한 변수들 선언
  protected Connection conn;
  protected PreparedStatement pstmt;
  protected Statement stmt;
  protected ResultSet rs;

  // 데이터베이스 연결 메서드
  public Connection connectDB() throws SQLException {
    // String driver = "jdbc:mariadb://127.0.0.1:3306/db7"; // MariaDB 연결 URL (주석처리됨)
    String driver = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB 연결 URL
    String user = "db7", pass = "1234"; // 데이터베이스 사용자명과 비밀번호
    conn = DriverManager.getConnection(driver, user, pass); // 데이터베이스 연결
    return conn; // 연결 객체 반환
  }

  // 데이터베이스 연결 종료 메서드
  public void closeDB() {
    try {
      // ResultSet 닫기
      if(rs != null) rs.close();
      // Statement 닫기
      if(stmt != null) stmt.close();
      // PreparedStatement 닫기
      if(pstmt != null) pstmt.close();
      // Connection 닫기
      if(conn != null) conn.close();
      // 연결 상태 확인 후 메시지 출력
      System.out.println(conn.isClosed() ? "접속종료" : "접속중");
    } catch (Exception e) {
      throw new RuntimeException(e); // 예외 발생 시 런타임 예외로 던짐
    }
  }

  /*
  create table members(
  mno number, id varchar2(20),
  pass varchar2(20), name varchar2(20),
  mobile varchar2(20));

  create sequence sq_members;

  */
}
