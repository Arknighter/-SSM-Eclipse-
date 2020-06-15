<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>左侧导航menu</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="background/css/css.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="background/js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(background/images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
  </head>
  
  <body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="background/images/main/member.jpg" width="44" height="44" /></div>
	
    <span>用户：${MANAGER_SESSION.managername}<br>角色：超级管理员</span>

</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>系统设置</span>
        <a href="background/main.jsp" target="mainFrame" onFocus="this.blur()">后台首页</a>
      </div>
      <div>
        <span>管理员设置</span>
        <a href="${pageContext.request.contextPath}/findAllPage" target="mainFrame" onFocus="this.blur()">管理员列表</a>
        <a href="${pageContext.request.contextPath}/toManagerAdd" target="mainFrame" onFocus="this.blur()">添加管理员</a>
      </div>
      <div>
        <span>栏目设置</span>
        <a href="${pageContext.request.contextPath}/findCatalogAllPage" target="mainFrame" onFocus="this.blur()">栏目列表</a>
        <a href="${pageContext.request.contextPath}/canumbermax" target="mainFrame" onFocus="this.blur()">添加栏目</a>
      </div>
      <div>
        <span>文章设置</span>
        <a href="${pageContext.request.contextPath}/findArticleAllPage" target="mainFrame" onFocus="this.blur()">文章列表</a>
        <a href="${pageContext.request.contextPath}/findarnumbermax" target="mainFrame" onFocus="this.blur()">添加文章</a>
      </div>
    </div>
  </body>
</html>
