package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

/*
 * 목록(R), 등록(C), 수정(U), 삭제(D)
 * 주의: DAO 메세지가 없음. 콘솔 출력 X (System.out.println)가 없음
 */
public class StudentDAO extends DAO {
	Scanner scn = new Scanner(System.in);

	// 단건조회.
	public int selectExists(String sno) {
		String sql = "select count(1) from tbl_student";
		sql += "    where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 3. 수정 기능
	public boolean updateStudent(StudentVO svo) {
		String sql = "update tbl_student ";
		sql += "     set  std_phone = ?";
		sql += "         ,address = ?";
		sql += "     where   std_no = ?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdPhone());
			psmt.setString(2, svo.getAddress());
			psmt.setString(3, svo.getStdNo());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	} // end of update

	// 삭제 기능 ////
	public boolean deleteStudent(String stdNo) {
		String sql = "delect tbl_student where std_no = ?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	} // end of update

	// 등록기능.
	public boolean insertStudent(StudentVO svo) {
		String sql = "insert into tbl_student (std_no,std_name,std_phone,address,birth_date)";
		sql += "values(?,?,?,?,?) ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdNo());
			psmt.setString(2, svo.getStdName());
			psmt.setString(3, svo.getStdPhone());
			psmt.setString(4, svo.getAddress());
			psmt.setString(5, svo.getBirthDate());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	}

	// 목록반환기능.
	public List<StudentVO> selectList() {
		String sql = "select * from tbl_student order by std_no";
		List<StudentVO> list = new ArrayList<>();
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentVO svo = new StudentVO();
				svo.setAddress(rs.getString("address"));
				svo.setBirthDate(rs.getString("birth_date"));
				svo.setCreatiorDate(rs.getDate("creation_date"));
				svo.setStdName(rs.getNString("std_name"));
				svo.setStdNo(rs.getString("std_no"));
				svo.setStdPhone(rs.getString("std_phone"));

				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of selectList().
}
