<%@ page language="java" session="true" %>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>
