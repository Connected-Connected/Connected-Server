package activity.mainfragment;

import java.sql.ResultSet;

import db.mainfragment.DTmpFragment;
import framework.BaseForm;

public class TmpFragment extends BaseForm {
	
	private DTmpFragment db;
	public TmpFragment(){
		
		db = new DTmpFragment();
		
		
	}
	
	public String getUser(String userToken) {
		db.conOpen();

		String sql = "SELECT * FROM USER WHERE USER_TOKEN = ?";
		
		String result;
		try {

			ResultSet rs = db.getUser(sql, userToken);
			
			result = convertToJson(rs, true);
			
		} catch (Exception e) {
			result = "[]";
		} finally {
			db.conClose();
		}

		return result;
	}
	
	
	public void setUser(String userToken, String userId, String userName, int userAge)
	{
		db.conOpen();

		String sql = "INSERT INTO USER(USER_TOKEN, USER_ID, USER_NM, USER_AGE) VALUES (?, ?, ?, ?)";
		
		try {
			
			db.setUser(sql, userToken, userId, userName, userAge);
			
		} catch (Exception e) {
			
			
		} finally {
			db.conClose();
		}
			
		
	}
	
	
	
	

}
