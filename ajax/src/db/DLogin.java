package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import framework.database.DBAdapter;

public class DLogin extends DBAdapter{


	public DLogin() {
		super();
	}

	private PreparedStatement psmt;

	public void saveUserInfo(String sql, String userToken, String userName, String userImg, int userAuth, int userSex, int userAge, String userContry, String userProfile) {
		try {
			psmt = _conn.prepareStatement(sql); 
			psmt.setString(1, userToken);
			psmt.setString(2, userName);
			psmt.setString(3, userImg);
			psmt.setInt(4, userAuth);
			psmt.setInt(5, userSex);
			psmt.setInt(6, userAge);
			psmt.setString(7, userContry);
			psmt.setString(8, userProfile);
			
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public ResultSet checkOverlapUserName(String sql, String userNm)
	{
		ResultSet rs = null;
		
		try {
			psmt = _conn.prepareStatement(sql); 
			psmt.setString(1, userNm);
			
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return rs;
	}
	
	public ResultSet getUserInfo(String sql, String userToken)
	{
		ResultSet rs = null;
		
		try {
			psmt = _conn.prepareStatement(sql); 
			psmt.setString(1, userToken);
			
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return rs;
	}
	

}