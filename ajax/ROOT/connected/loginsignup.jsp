<%@page import="java.net.URLDecoder"%>
<%@page import="activity.LoginSignupActivity"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%
	
	String result = "";

	LoginSignupActivity login = new LoginSignupActivity();
	String method = request.getParameter("method");
	
	if(method.equals("saveUserInfo"))
	{
		
		String userToken = request.getParameter("userToken");
		String userNm = request.getParameter("userNm");
		String userImg = request.getParameter("userImg");
		
		int userAuth = 0;
		int userSex = Integer.parseInt(request.getParameter("userSex"));
		int userAge = Integer.parseInt(request.getParameter("userAge"));;
		String userContry = request.getParameter("userContry");
		String userProfile = request.getParameter("userProfile");
		
		userToken = URLDecoder.decode(userToken, "UTF-8");
		userNm = URLDecoder.decode(userNm, "UTF-8");
		userImg = URLDecoder.decode(userImg, "UTF-8");
		userContry = URLDecoder.decode(userContry, "UTF-8");
		userProfile = URLDecoder.decode(userProfile, "UTF-8");
		
		
		
		String jUser;
		if(userToken != null)
		{
			result = login.saveUserInfo(userToken, userNm, userImg, userAuth, userSex, userAge, userContry, userProfile);
		}
		else{
			result = "No Token";
		}
	}
	else if(method.equals("checkOverlapUserName"))
	{
		String userNm = request.getParameter("userNm");
		userNm = URLDecoder.decode(userNm, "UTF-8");
		

		//if(login.checkOverlapUserName(userNm)){
		result = login.checkOverlapUserName(userNm);
		//}
		//else {
		//	result = userNm;
		//}
		
		//if(login.checkOverlapUserName(userNm)){
		//	result = "OK";
		//}
		//else {
		//	result = userNm;
		//}	
	}
	else if(method.equals("getUserInfo"))
	{
		String userToken = request.getParameter("userToken");
		userToken = URLDecoder.decode(userToken, "UTF-8");
		result = login.getUserInfo(userToken);
	}
%>

<%=result%>
    