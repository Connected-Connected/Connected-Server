<%@page import="activity.mainfragment.TmpFragment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	String userToken = request.getParameter("userToken");
	
	TmpFragment tmpFragment = new TmpFragment();
	
	String jUser;
	if(userToken == null)
	{
		jUser = tmpFragment.getUser("token4");
	}
	else{
		tmpFragment.setUser(userToken, "userid", "¾È³ç", 10);
		jUser = tmpFragment.getUser(userToken);
	}
	
%>

<%= jUser %>
