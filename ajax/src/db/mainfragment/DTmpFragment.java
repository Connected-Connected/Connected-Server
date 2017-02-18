package db.mainfragment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import framework.database.DBAdapter;

public class DTmpFragment extends DBAdapter{


	public DTmpFragment() {
		super();
	}

	private PreparedStatement psmt;

	public void setUser(String sql, String userToken, String userId, String userName, int userAge) {
		try {
			psmt = _conn.prepareStatement(sql); 
			psmt.setString(1, userToken);
			psmt.setString(2, userId);
			psmt.setString(3, userName);
			psmt.setInt(4, userAge);
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public ResultSet getUser(String sql, String UserID) {
		ResultSet rs = null;
		try {
			psmt = _conn.prepareStatement(sql); 
			psmt.setString(1, UserID);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return rs;
	}
	

}
