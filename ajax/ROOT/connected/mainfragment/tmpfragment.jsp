<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String result = "";
	String type = request.getParameter("dataType");
	
	if(type != null)
	{
		if(type.equals("type1"))
		{
			result = "[{\"Data\" : \"type 1's data\" }]";
		}
		else if(type.equals("type2"))
		{
			result = "[{\"Data\" : \"type 2's data\" }]";
		}
		else
		{
			result = "[{\"Data\" : \"no data\" }]";
		}
	}
	else{
		result = "[{\"Data\" : \"no data\" }]";
	}
%>

<%= result%>