<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主要内容区main</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>   
    <script type="text/javascript">
    	function addArt() {
    		var edit =  UE.getEditor('myEditor'); 
			var caid = document.getElementById("caid").value;
			var artitle = document.getElementById("artitle").value;
			var arcontent = edit.getContent();
			var aruser = document.getElementById("aruser").value;
			var arstate = document.getElementById("arstate").value;
			var arnumber = document.getElementById("arnumber").value;
			$.post("${pageContext.request.contextPath}/addArticle",
					{"caid":caid,"artitle":artitle,"arcontent":arcontent,"aruser":aruser,"arstate":arstate,"arnumber":arnumber},
					function(data){
						if(data == "OK"){
							alert("添加成功");
							window.location.href ="${pageContext.request.contextPath}/findArticleAllPage";
						}else{
							alert("添加失败");
							window.location.reload()
						}
					});
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
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(background/images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(background/images/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
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
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#addinfo a{ font-size:14px; font-weight:bold;  padding:0px 0 0px 20px; line-height:45px;}

</style>
  </head> 		
  <body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：文章设置&nbsp;&nbsp;>&nbsp;&nbsp;添加文章</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">添加文章</a>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form action="" method="post" >
   	 	<input type="hidden" value="" name="type">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">文章栏目：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        	<select id="caid">
        			<c:forEach var="catalog" items="${CatalogList}">
        				<option value="${catalog.caid}">
        					${catalog.caname}
        				</option>
        			</c:forEach>
        	</select>
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">文章序号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
			<input type="text" id="arnumber" value="${arnumber}" class="text-word" readonly="readonly">
		</td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">文章标题：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
			<input type="text" id="artitle" value="" class="text-word">
		</td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray" >文章内容：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
			<textarea name="arcontent"  style="width: 100%; height: 280px" id="myEditor"></textarea>
		</td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">发布者：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" >
        	<input type="text" id="aruser" value="" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">状态：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select id="arstate" id="level">
	    <option value="1" >&nbsp;&nbsp;显示</option>
	    <option value="2" >&nbsp;&nbsp;不显示</option>
        </select>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">操作：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="" type="submit" value="提交" class="text-but" onclick="addArt()">
        <input name="" type="reset" value="重置" class="text-but"></td>
      </tr>
    </table>   
    </form>
    </td>
    </tr>
</table>
	<script type="text/javascript">
 		UEDITOR_CONFIG.UEDITOR_HOME_URL = '${pageContext.request.contextPath}/ueditor/';
	     UE.getEditor('myEditor'); 
    </script>
  </body>
</html>
