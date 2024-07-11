package co.yedam.comcom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class AppTests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "jsp";
		String pass = "jsp";
		Connection conn = null;
		
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
			return null;
		}
		return conn;

	}

	public static void main(String[] args) {
		// 1)Oracle JDBC Driver 자바 라이브러리.
		// 2)Connection 객체.
		Scanner scn = new Scanner(System.in);
		
		
		System.out.println(">학생번호 입력.");
		String sno = scn.nextLine();
		System.out.println(">학생이름 입력.");
		String sname = scn.nextLine(); // "" 공백값
		System.out.println(">연락처 입력.");
		String phon = scn.nextLine();
		System.out.println(">주소 입력.");
		String address = scn.nextLine();
		System.out.println(">생일 입력.");
		String birth = scn.nextLine();
		
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setAddress(address);
		std.setBirthDate(birth);
		std.setStdPhone(phon);
		std.setStdName(sname);

		modStu(std);
//		delStudent(sno); //삭제
//		modstudent(sno,sname,phon); //수정
//		addStudent(sno, sname, phon); // 입력.
		search(); // 목록조회.
	}
	
	
	
	//수정 기능2
	public static void modStu(StudentVO svo) {
		
		Connection conn = getConn();
		String sql = "update tbl_student";
		sql += "set  std_name = nvl('" + svo.getStdName() + "', std_name)";
		sql += "    ,std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
		sql += "    ,address = nvl('" + svo.getAddress()+ "', address)";
		sql += "    ,birth_date = nvl('" + svo.getBirthDate() + "', birth_date)";
		sql += " 	where std_no = '" + svo.getStdNo() + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete => 처리된 건수,
		
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	// 수정기능.
	
//	public static void modstudent(String stdNo,String stdName, String phone) {
//		Connection conn = getConn();
//		String sql = "update tbl_student";
//		sql += " set std_name = '" + stdName + "'";				
//		sql	+= " ,std_phone = '" + phone + "'";
//		sql	+= "where std_no ='" + stdNo + "'";						
//		try {
//			Statement stmt = conn.createStatement();
//			int r = stmt.executeUpdate(sql); // insert,update,delete => 처리된 건수,
//			System.out.println("처리된 건수는 " + r + "건.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	//삭제기능.
	// DELETE tbl_student
	// where std_no = 's2024-02'
	public static void delStudent(String stdNo) {
		Connection conn = getConn();
		String sql = "Delete from tbl_student where std_no = '"+ stdNo +"'"; 
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete => 처리된 건수,
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	// 입력가능.
	// insert into tbl_student (std_no, std_name, std_phone)
	// values('s2024-04','김민규','010-2222-5678');
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "insert into tbl_student (std_no, std_name, std_phone)";
		sql += "values('" + stdNo + "','" + stdName + "','" + phone + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete => 처리된 건수,
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회기능.
	public static void search() {
		// 조회기능.
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_student ");
			// [객체1, 객체2, 객체3]
			while (rs.next()) {
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";
				System.out.println(
						rs.getString("std_no") + ", " //
					  + rs.getString("std_name") + ", " //
					  + rs.getString("std_phone")
					  + birth//
					  );
			}
			System.out.println("end of date.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 조회기능 끝.
	}

}
