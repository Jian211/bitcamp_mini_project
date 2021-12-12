package controller;

import dao.UserDao;
import dto.User;
import util.PatternChk;

public class UserController {

	public UserDao userDao;
	public PatternChk patternChk; 
	
	public UserController() {
		userDao = UserDao.getInstance();
		patternChk = new PatternChk();
		
	}
	
	
	// JOIN

	// 잘 입력했는지 검사하고 결과를 반환
	public boolean chkJoinPattern(User user) {
		boolean [] result = new boolean[6];
		result[0] = patternChk.userNameForm(user.getName());
		result[1] = patternChk.emailForm(user.getEmail());
		result[2] = patternChk.pwForm(user.getPassword());
		result[3] = patternChk.phnumForm(user.getPhnum());
		result[4] = patternChk.nameForm(user.getName());
		result[5] = true;
		
		for (int i = 0; i < result.length; i++) {
			if(!result[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean joinUser(User user) {	
		System.out.println(user.getName());
		System.out.println(user.toString());
		return userDao.insertUser(user) > 0;
	}

	
	// LOGIN
	// 로그인에 성공하면 해당 유저의 고유번호를 리턴하는 메소드  > 리턴이 아닌 로커 클래스 객체에 저장
	public boolean auth(String userName, String password) {
		boolean result = false;
		int loginId = userDao.authChk(userName, password);

		if(loginId > 0) {		// 0보다 크면 로그인 됬다는 증거 
			result = true;
			logger.LoginUser.loginId = loginId;
			logger.LoginUser.loginStatus = true;
		}
		return result;
	}
	

	//////////////////////  내정보 ////////////////////////////////////
	// 회원정보 보기
	public User showInfo() {
		return userDao.selectByUserId();
	}
	
	// 회원정보 수정
	public void updateInfo(String password, String email, String phnum, String address, int userId) {
		int result = userDao.updateUser(password, email, phnum, address, userId);
		if(result > 0) {
			System.out.println("회원정보가 수정되었습니다.");
		}
	}
	
	// 회원 탈퇴
	public void deleteUser(String password) {
		int result = 0;
		
		if(userDao.passwordChk(password)) {
			result = userDao.deleteUser();
			logger.LoginUser.logOut();
			
			if(result > 0) {
				System.out.println("회원 탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.");
			}
			
		} else {
			System.out.println("비밀번호를 잘못 입력하셨습니다. 회원 탈퇴를 취소합니다.");
		}
		
	}


	
	
}
