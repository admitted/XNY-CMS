<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
me.cuijing.cms.admin.model.Admin user = (me.cuijing.cms.admin.model.Admin)session.getAttribute("admin");
if ( user== null) {//判断是否存在session
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/login.jsp";
	response.sendRedirect(basePath);
}
%>