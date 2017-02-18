package framework;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.apache.tomcat.util.codec.binary.Base64;

public class BaseForm {
	 /*
	  * 2017-02-15
	  * 김지광
	  * 모든 class의 상속이 될 Base Framework
	  * 데이터 decode, encode / DB 결과값을 json 형태로 바꿔주는 함수 등 여러 util 함수들을 포함한다.
	  */
	public BaseForm(){
		
	}
	
	
	 /*
	  * 2017-02-15
	  * 김지광
	  * Base64  인코딩
	  */
	public String base64Endcoding(String str)
	{
		String ret = "";
		if(str.length() != 0)
		{
			byte[] encoded = Base64.encodeBase64(str.getBytes());
			ret = new String(encoded);
		}
		return ret;
	}
	 /*
	  * 2017-02-15
	  * 김지광
	  * Base64  디코딩
	  */
	public String base64Decoding(String str)
	{
		String ret = "";
		if(str.length() != 0)
		{
			byte[] decoded = Base64.decodeBase64(str.getBytes());
			ret = new String(decoded);
		}
		return ret;
	}
	
	/*
	  * 2017-02-15
	  * 김지광
	  * utf8  인코딩
	  */
	public String utf8Endcoding(String str)
	{
		String enStr = str;
		if(str == null)
			enStr = "";
		
        try {
            enStr = URLEncoder.encode(enStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return enStr;
	}
	 /*
	  * 2017-02-15
	  * 김지광
	  * utf8  디코딩
	  */
	public String utf8Decoding(String str)
	{
		String enStr = str;
		if(str == null)
			enStr = "";
		
        try {
            enStr = URLDecoder.decode(enStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return enStr;
	}
	
	 /*
	  * 2017-02-15
	  * 김지광
	  * ResultSet을 json형태의 String 으로 변환
	  */
	public String convertToJson(ResultSet rs, boolean isArray)
	{
		 StringBuffer sb = new StringBuffer();
		 ResultSetMetaData srd;
		 
		 try {
			 
			sb = new StringBuffer();
			srd = rs.getMetaData();
			
			if(isArray)
				sb.append("[");
			
			String columnLabel;
			int columnCnt;
			
			columnCnt = srd.getColumnCount();
			while(rs.next())
			 {
				
				sb.append("{");
				for(int i=1; i <= columnCnt; i++){
					columnLabel = srd.getColumnLabel(i);					
					sb.append("\""+columnLabel+"\":");
					sb.append("\""+utf8Endcoding(rs.getString(columnLabel))+"\"");
					if(i<columnCnt)
						sb.append(",");
				}
				
				if(rs.isLast())
					sb.append("}");
				else
					sb.append("},");
				
			 }
			
			if(isArray)
				sb.append("]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
		return sb.toString();
	}
	
	
	/*
	  * 201
	  * 김지광
	  * error메세지를 Json으로 변환
	  */
	public String errorToJsonobject(String error, boolean isArray){
					
		StringBuffer sb = new StringBuffer();
		if(isArray)
			sb.append("[");
		sb.append("{");				
		sb.append("\"error\":");
		sb.append("\""+error+"\"");
		sb.append("}");
		if(isArray)
			sb.append("]");
		return sb.toString();
	}
}
