package viewer;

import controller.UserController;
import util.ScannerUtil;

public class UserViewer {

	public static int logInId;
	
	UserController userController;
	
	public UserViewer() {
		userController = new UserController();
	}

	
	
	
	/////////////////  회원가입   ///////////////////////////////////
	public void showJoinForm() {
		System.out.println("회원가입!! 시작 나중에 수정");
		/* 
		  	회원가입 아이디, 비밀번호 등 입력받고 컨트롤러 ㄱㄱ
		  	
		  	컨트롤러 회원가입까지 만들기
		  	
		  	
		  	
		 */
		
	}



	/////////////////  로그인    ///////////////////////////////////
	// 로그인
		public void showLogin() {
			while (true) {
				System.out.println("아이디를 입력해주세요.");
				System.out.print("> ");
				String username = ScannerUtil.scanString();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print("> ");
				String password = ScannerUtil.scanString();
				
				logInId = userController.auth(username, password);
				if (logInId == 0) {
					System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
				} else {
					System.out.println("로그인 성공!");
					showMenu();
					break;
				}
			}
		}


		private void adminMenu() {
			/*
				관리자용 메뉴
			 
			 */
			
		}
		
		private void showMenu() {
			
			/* 
				- 일반유져
				도서 검색 
				마이페이지

				- 관리자 
				도서관리

			 */
		}
}
