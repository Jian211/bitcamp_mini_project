package util;

public class ChkNum {

	
	public boolean chkMenuRange(int start, int end, String userSelect) {
		// 유저가 맞지 않는 값을 고르면 true;
		int userNum = Integer.parseInt(userSelect);
		return userNum > end || userNum < start;
	}
}
