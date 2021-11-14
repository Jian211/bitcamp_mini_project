package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*	
 	작성자 : 지명근
 	
	사용자의 입력값을 판별해주는 클래스
	
	아이디 형식에 맞지 않을 시 false,  맞을시 true를 반환해주는 메소드들이 모여있다.
 
 */

public class PatternChk {
	
	Pattern p;
	Matcher m;

	String rexUserName = "^[a-zA-Z0-9]{4,12}$"; 			// 아이디 형식
	String rexPw = "^[a-zA-Z0-9가-힣\\!\\@\\-\\_]{6,20}$";   // 패스워드 형식
	String rexName = "^[가-힣A-Za-z]{2,30}$"; 				// 유저 이름 형식
	String rexEmail = "^[\\w]{2,12}@[\\w\\.\\_\\-]{2,20}$"; // 이메일 형식
	String rexPhnum = "^[\\d]{2,3}-[\\d]{3,4}-[\\d]{4}$";   // 번호 형식
	String rexOrderdate = "^[0-9]{8}"; 						// 주문일 입력 형식
	String rexOrderMonth = "^[0-9]{6}"; 					// 주문월 입력형식

	public boolean nameForm(String name) {			// 유저이름 형식에 맞는지 확인해주는 메소드
		boolean result = false;
		p = Pattern.compile(rexName);
		m = p.matcher(deleteBlank(name));
		if (m.matches()) {
			result = true;
		}
		return result;
	}
	
	public boolean pwForm(String password) {		// 패스워드 형식에 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexPw);
		m = p.matcher(deleteBlank(password));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean userNameForm(String userName) {	// 아이디 형식이 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexUserName);
		m = p.matcher(deleteBlank(userName));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean emailForm(String email) {		// 이메일 형식이 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexEmail);
		m = p.matcher(deleteBlank(email));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean phnumForm(String phnum) {		// 번호 형식이 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexPhnum);
		m = p.matcher(deleteBlank(phnum));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean orderdateForm(String orderdate) {// 주문일 형식이 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexOrderdate);
		m = p.matcher(deleteBlank(orderdate));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean orderMonthForm(String orderMonth){ // 주문월 형식이 맞는지 확인해주는 메소드
		boolean result = false;

		p = Pattern.compile(rexOrderMonth);
		m = p.matcher(deleteBlank(orderMonth));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public String deleteBlank(String a) {			 // 공백 제거
		return a.replace(" ", "");
	}
}
