<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript">
    	function onblurname() {
			var names = document.getElementById("urname").value;
			var img = document.getElementById("nameimg");
			//alert(names);
			$.ajax({
				contentType:"application/json;charset=UTF-8",
				url:"${pageContext.request.contextPath}/username/"+names,
				type:"GET",
				dataType:JSON.stringify(),				
				//成功响应的结果
				success:function(data){
					//alert(data);
					img.src="background/images/login/true.png"
					img.style.visibility="visible";
					//msg.innerHTML="<用户验证成功>"									
				},
				error:function(data){
					//msg.innerHTML="<用户验证不成功>"
					img.src="background/images/login/false.png"
					img.style.visibility="visible";
				}
			});
		}
    
    	function onblurpwd() {
    		var names = document.getElementById("urname").value;
			var passwd = document.getElementById("passwd").value;
			var img = document.getElementById("pwdimg");
			//alert(names);
			$.ajax({
				contentType:"application/json;charset=UTF-8",
				url:"${pageContext.request.contextPath}/username/"+names,
				type:"GET",
				dataType:JSON.stringify(),				
				//成功响应的结果
				success:function(data){
					if(passwd==data){
						img.src="background/images/login/true.png"
						img.style.visibility="visible";
					}else{						
						img.src="background/images/login/false.png"
						img.style.visibility="visible";
					}
					
				}
			});
		}
    </script>
    <title>后台管理登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="background/css/alogin.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	
    <form id="form1" runat="server" action="${pageContext.request.contextPath }/login" method="post">
    <input type="hidden" value="login" name="type">
    <div class="Main">
    
        <ul>
        
            <li class="top"></li>
            <li class="top2">
            </li>
            <li class="topA"></li>
            <li class="topB"><span><img src="background/images/login/logo.png" alt="" style="" /></span></li>
            <li class="topC"></li>
            <li class="topD">
            
                <ul class="login">
                	
                    <li><span class="left login-text">用户名：</span> <span style="left">
                        <input id="urname" type="text" class="txt" name="managername" onchange="onblurname()"/> 
                        <span id="urnameimg"><img id="nameimg" src="background/images/login/true.png"></span> 
                    </span>
                    
                    </li>
                    <li><span class="left login-text">密码：</span> <span style="left">
                       <input id="passwd" type="password" class="txt" name="passwd"  onchange="onblurpwd()"/> 
                       <span id="urnameimg"><img id="pwdimg" alt="" src="background/images/login/true.png"></span>  
                    </span></li>
					
                </ul>	
                		 验证码：    <input type="text" id="check_code" name="check_code" size="15">
          		  			<a href="login"><img src="checkCode"  /></a><br />
            </li>
          		 
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B">
            </li>
            <li class="middle_C">
            	<span class="btn" >
            		<input name="" type="image" src="background/images/login/btnlogin.gif"  />
            	</span><br/>
            	<font color="red">
  					<span id="message">${msg }</span>
  			 	</font>           
            </li>
            <li class="middle_D"></li>
           
            <li class="bottom_A"></li>
            <li class="bottom_B">18软4@2018040104106系统&nbsp;&nbsp;@zhongerbaohuxiehui@foxmail</li>
        </ul>
    </div>

    </form>
  </body>

</html>
