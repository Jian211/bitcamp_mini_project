package viewer;

import java.util.Scanner;

import controller.UserController;
import dto.User;
import util.ChkNum;
import util.PatternChk;
import util.ScannerUtil;

public class MainViewer {

	PatternChk patternChk;
	UserController userController;
	UserViewer userViewer;
	AdminViewer adminViewer;
	ChkNum chkNum;
	Scanner sc;
	
	public MainViewer() {
		patternChk = new PatternChk();
		userController = new UserController();
		userViewer = new UserViewer();
		adminViewer = new AdminViewer();
		sc = new Scanner(System.in);
		chkNum = new ChkNum();
	}
	
	public void showMainMeun() {
		while(true) {
			System.out.println("1. 로그인 \n2. 회원가입\n3. 프로그램 종료");
			System.out.println("번호를 입력해주세요.");
			
			// 유효성 체크 메소드 제작 할 것
			int userChoice = sc.nextInt();
			
			switch (userChoice) {
			
			case 1: // 로그인
				showLogin();
				break;

			case 2:	// 회원가입
				showJoinForm();
				break;
				
			case 3:	// 종료
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
				
			default:
				System.out.println("선택한 메뉴번호가 존재하지 않습니다.");
			}
		}		
	}
	
	public void showLogin() {
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			System.out.print("> ");
			String userName = sc.nextLine();

			while (!patternChk.userNameForm(userName)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("아이디를 입력해주세요. (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
				System.out.print(">	");
				userName = ScannerUtil.getString();
			}

			System.out.println("비밀번호를 입력해주세요.");
			System.out.print("> ");
			String password = ScannerUtil.getString();

			while (!patternChk.pwForm(password)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
				System.out.print("> ");
				password = ScannerUtil.getString();
			}
			
			// 로그인 
			if (userController.auth(userName, password)) {
				System.out.println("로그인 성공!");

				if (logger.LoginUser.loginId > 9) {   		// 일반.
					userViewer.userMenu();
				} else {
					adminViewer.adminMenu();
				}
				break;
			} else {
				System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
			}
		}
	}
	
	
	public void showJoinForm() {
		User user = new User();
		boolean result = true;
		while(result) {

			System.out.println("==============		회 원 가 입		 ==============\n");
			System.out.println(" 아래 양식에 따라 입력해주세요.");
	
			System.out.println("로그인 아이디  (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
			System.out.print("> ");
			user.setName(sc.nextLine());
	
			System.out.println("\n로그인 비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
			System.out.print("> ");
			user.setPassword(sc.nextLine());
	
			System.out.print("\n이름을 입력해주세요. (영문 최대20글자, 한글 최대10글자)\n> ");
			user.setName(sc.nextLine());
	
			System.out.print("\n이메일을 입력해주세요. (예: mail@email.com)\n> ");
			user.setEmail(sc.nextLine());
	
			System.out.print("\n전화번호를 입력해주세요. (-를 포함해주세요.) (예: 010-1111-2222)\n> ");
			user.setPhnum(sc.nextLine());
			
			System.out.print("\n주소를 입력해주세요.\n> ");
			user.setAddress(sc.nextLine());

			// 값 정확한지 체크
			if(!userController.chkJoinPattern(user)) {
				System.out.println("정확한 값을 다시 입력해주세요.");
				continue;
			} else {
				result = !userController.joinUser(user);
			};
		}

		if(!result) {
			System.out.println("회원가입에 성공하셨습니다.");
		} else {
			System.out.println("회원가입에 실패하셨습니다.");
		}
	}


}
