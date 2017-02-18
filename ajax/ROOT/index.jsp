<%@page import="activity.mainfragment.TmpFragment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	String userToken = "test1";

	
	TmpFragment tmpFragment = new TmpFragment();

	tmpFragment.setUser(userToken, "userid", "username", 10);
	String jUser = tmpFragment.getUser(userToken);
	

%>

<%= jUser %>
