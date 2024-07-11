package go.game.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import go.game.vo.GamesellerVO;

/*
 *
 * 목록(R), 등록(C), 수정(U), 삭제(D)
 * 주의: DAO 메세지가 없음. 콘솔 출력 X (System.out.println)가 없음
 */

public class GamesellerDAO extends DAO {
	Scanner scn = new Scanner(System.in);

	// 등록기능.
	public boolean insertStudent(GamesellerVO svo) {
		String sql = "insert into tbi_game (TITLE_NO, GAM_MODEL, GAM_TITLE, GAM_PRICE, STOCK,RESTOKING_DATE)";
		sql += "values(?,?,?,?,?,?) ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getTitleNO());
			psmt.setString(2, svo.getGamModel());
			psmt.setString(3, svo.getGamTitle());
			psmt.setString(4, svo.getGamPrice());
			psmt.setString(5, svo.getStock());
			psmt.setString(6, svo.getRestokingdate());

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
	public List<GamesellerVO> selectList() {
		String sql = "select * from tbi_game";
		List<GamesellerVO> list = new ArrayList<>();
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				GamesellerVO svo = new GamesellerVO();
				svo.setTitleNO(rs.getString("TITLE_NO"));
				svo.setGamModel(rs.getString("GAM_MODEL"));
				svo.setGamTitle(rs.getString("GAM_TITLE"));
				svo.setGamPrice(rs.getString("GAM_PRICE"));
				svo.setStock(rs.getString("STOCK"));
				svo.setRestokingdate(rs.getString("RESTOKING_DATE"));
				
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of selectList().

	// 삭제 기능 ////
	public boolean deleteStudent(String gno) {
		String sql = "delete tbi_game where TITLE_NO = ?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gno);

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	} // end of update

}
