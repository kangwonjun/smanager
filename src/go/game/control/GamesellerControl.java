package go.game.control;

import java.util.List;
import java.util.Scanner;

import go.game.dao.GamesellerDAO;
import go.game.vo.GamesellerVO;

public class GamesellerControl {
	Scanner scn = new Scanner(System.in);
	GamesellerDAO gdao = new GamesellerDAO();

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("1.타이틀목록  2. 게임추가    3.게임검색및 재고 확인    4.게임할인 적용하기  5.게임삭제   6.프로그램 종료");
			System.out.print("선택> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				gameList();
				break;

			case 2:
				addGame();
				break;
//			
//		case 3:
//			gameSerchA();
//			break;
//			
//		case 4:
//			deleteGame();
//			break;
			
		case 5:
			deleteGame();
			break;
			
			
////		case 6:
//			System.out.println("종료합니다.");
//			isTrue = false;
			}
		}
	} // end of run().

	// 등록기능
	void addGame() {
		System.out.println(">타이틀넘버 입력.");
		String gno = scn.nextLine();
		System.out.println(">게임명 입력.");
		String gtitle = scn.nextLine(); // "" 공백값
		System.out.println(">기종 입력.");
		String gmodel = scn.nextLine();
		System.out.println(">가격 입력.");
		String gprice = scn.nextLine();
		System.out.println(">재입고 예정일.");
		String restoking = scn.nextLine();

		GamesellerVO std = new GamesellerVO();
		std.setTitleNO(gno);
		std.setGamTitle(gtitle);
		std.setGamModel(gmodel);
		std.setGamPrice(gprice);
		std.setRestokingdate(restoking);

		// 입력 기능 호출.
		if (gdao.insertStudent(std)) {
			System.out.println("저장완료!");
		} else {
			System.out.println("처리중 예외발생!");
		}
	}

	// 목록 출력 기능.
	void gameList() {
		List<GamesellerVO> game = gdao.selectList();
		System.out.println("TitleNO,model, title, price, stock,restoking ");
		System.out.println("------------------------------------------");
		for (GamesellerVO svo : game) {
			System.out.println(svo.briefShow());
		}

	} // end of studentList
	
	
	
	// 삭제 기능
		void deleteGame() {
			
			System.out.println("삭제할대상의 타이틀넘버를 입력해주세요");
			 String gno = scn.nextLine();
			if(gdao.deleteStudent(gno)) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("존재하지 않는 타이틀 넘버 입니다.");
			}
			
		}

}
