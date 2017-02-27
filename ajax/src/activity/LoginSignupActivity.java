package activity;

import java.sql.ResultSet;

import db.DLogin;
import framework.BaseForm;

public class LoginSignupActivity extends BaseForm {

	
	private DLogin db;
	public LoginSignupActivity(){
		
		db = new DLogin();
		
		
	}
	

	public String saveUserInfo(String userToken, String userName, String userImg, int userAuth, int userSex, int userAge, String userContry, String userProfile)
	{
						
		db.conOpen();

		String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			db.saveUserInfo(sql, userToken, userName, userImg, userAuth, userSex, userAge, userContry, userProfile);
			
		} catch (Exception e) {
			
			return e.getMessage();
			
		} finally {
			db.conClose();
		}
			
		return "OK";
		
	}
	
	public String checkOverlapUserName(String userNm)
	{
		db.conOpen();

		int userCnt = -1;
		String sql = "SELECT COUNT(0) AS USERCNT FROM USER WHERE USER_NM = ?";
		
		try {
			
			ResultSet rs = db.checkOverlapUserName(sql, userNm);
			
			if(rs.next())
				userCnt = rs.getInt("USERCNT");
			
		} catch (Exception e) {
			
			return e.getMessage();
			
		} finally {
			db.conClose();
		}
		
		return userCnt == 0? "OK" : "NO";
	}
	
	public String getUserInfo(String userToken)
	{
		
		
		db.conOpen();

		String result = "";
		String sql = "SELECT * FROM USER WHERE USER_TOKEN = ?";
		
		try {
			
			ResultSet rs = db.getUserInfo(sql, userToken);

			if(rs.isBeforeFirst())
				result = convertToJson(rs, false);
			
		} catch (Exception e) {
			
			return e.getMessage();
			
		} finally {
			db.conClose();
		}
		
		return result;
	}
}
