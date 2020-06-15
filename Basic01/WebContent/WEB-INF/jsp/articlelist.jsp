<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主要内容区main</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
  	<script type="text/javascript">
	function deleteA(id){
		if(confirm('确定要删除该文章吗？')){
			$.ajax({
				url:"${pageContext.request.contextPath}/delArticle",
				type:"POST",
				data:{"id":id},			
				success:function(data){
					if(data == "OK"){
						alert("删除成功！");
						window.location.href ="${pageContext.request.contextPath}/findArticleAllPage";
					}else{
						alert("删除失败!");
					}
				}
			});						
		}else{
			alert("删除取消成功!");
			window.location.reload();
		}
		
	}
	</script>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="background/css/css.css" type="text/css" rel="stylesheet" />
<link href="background/css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="background/images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(background/images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(background/images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(background/images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
#addinfo{ padding:0 0 10px 0;}
</style>
  </head>
  
  <body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
   <tr>
    <td width="99%" align="left" valign="top">您的位置：文章管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="${pageContext.request.contextPath}/findByNameArticle">
	         <input type="hidden" value="SeachAll" name="type">
	         <span>文章标题：</span>	         
	         <input  name="arname" value="" class="text-word">
	         <input name="" type="submit" value="查询" class="text-but">	         	         
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;">
  		  <a href="${pageContext.request.contextPath}/findarnumbermax" target="mainFrame" onFocus="this.blur()" class="add">新增文章</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">栏目</th>
        <th align="center" valign="middle" class="borderright">标题</th>
        <th align="center" valign="middle" class="borderright">内容</th>
        <th align="center" valign="middle" class="borderright">排序号</th>
  		<th align="center" valign="middle" class="borderright">时间</th>
        <th align="center" valign="middle" class="borderright">状态</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach var="article" items="${ArticleList}">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${article.arid}</td>
        <td align="center" valign="middle" class="borderright borderbottom">
        	<c:forEach items="${catalogs}" var="catalog">
        		<c:if test="${catalog.caid eq article.caid}">
        			${catalog.caname}
        		</c:if>
        	</c:forEach>
        	
        		
        </td>
        <td align="center" valign="middle" class="borderright borderbottom"><a>${article.artitle}</a></td>
         <td align="center" valign="middle" class="borderright borderbottom">${article.arcontent}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${article.arnumber}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${article.artime}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${article.arstate}</td>
        <td align="center" valign="middle" class="borderbottom">
        <a href="${pageContext.request.contextPath}/findByIdArticle/${article.arid}" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span>
        <a  target="mainFrame"  class="add" onclick="deleteA(${article.arid})">删除</a></td>
      </tr>
      </c:forEach>
  <%--   
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">2</td>
        <td align="center" valign="middle" class="borderright borderbottom">留言测试</td>
        <td align="center" valign="middle" class="borderright borderbottom"><a href="background/message_info.html" target="mainFrame" onFocus="this.blur()">留言测试留言测试留言测试留言测试内容</a></td>
        <td align="center" valign="middle" class="borderright borderbottom">admin@sina.com</td>
        <td align="center" valign="middle" class="borderright borderbottom">2013-04-19 15:35:13</td>
        <td align="center" valign="middle" class="borderbottom"><a href="background/message_replay.html" target="mainFrame" onFocus="this.blur()" class="add">回复</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">不允许显示</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">查看</a></td>
      </tr>
--%>  
    </table></td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye">
    	<font size="2">共 ${page.totalCount} 条数据     </font>
        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第 
            ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=1">首页</a> 
        <c:choose> 
            <c:when test="${page.pageNow - 1 > 0}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.pageNow - 1}">上一页</a> 
            </c:when> 
            <c:when test="${page.pageNow - 1 <= 0}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=1">上一页</a> 
            </c:when> 
        </c:choose> 
        <c:choose> 
            <c:when test="${page.totalPageCount==0}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.pageNow}">下一页</a> 
            </c:when> 
            <c:when test="${page.pageNow + 1 < page.totalPageCount}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.pageNow + 1}">下一页</a> 
            </c:when> 
            <c:when test="${page.pageNow + 1 >= page.totalPageCount}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.totalPageCount}">下一页</a> 
            </c:when>                         
        </c:choose> 
        <c:choose> 
            <c:when test="${page.totalPageCount==0}"> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.pageNow}">尾页</a> 
            </c:when> 
            <c:otherwise> 
                <a href="${pageContext.request.contextPath}/findArticleAllPage?pageNow=${page.totalPageCount}">尾页</a> 
            </c:otherwise> 
        </c:choose> </td>
    </tr>
</table>
  </body>
</html>
