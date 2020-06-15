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
    
    <title>兔小白个人博客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="background/js/jquery.min.js"></script>
<script type="text/javascript" src="background/js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<!-- 返回顶部调用 end-->

  </head>
  
  <body>

<header>
  <div class="logo f_l"> <a href="/"><img src="images/logo.png"></a> </div>
  <nav id="topnav" class="f_r">
    <ul>
      <a href="${pageContext.request.contextPath}/welcome" target="_self">首页</a> <a href="#" target="_blank">关于我</a> <a href="#" target="_blank">文章</a> <a href="#" target="_blank">心情</a> <a href="#" target="_blank">相册</a> <a href="#" target="_blank">留言</a>
    </ul>
    <script src="background/js/nav.js"></script> 
  </nav>
</header>
<article>
  <div class="l_box f_l">
    <div class="banner">
      <div id="slide-holder">
        <div id="slide-runner"> <a href="/" target="_blank"><img id="slide-img-1" src="images/a1.jpg"  alt="" /></a> 
        						<a href="/" target="_blank"><img id="slide-img-2" src="images/a2.jpg"  alt="" /></a> 
        						<a href="/" target="_blank"><img id="slide-img-3" src="images/a3.jpg"  alt="" /></a> 
        						<a href="/" target="_blank"><img id="slide-img-4" src="images/a4.jpg"  alt="" /></a>
          <div id="slide-controls">
            <p id="slide-client" class="text"><strong></strong><span></span></p>
            <p id="slide-desc" class="text"></p>
            <p id="slide-nav"></p>
          </div>
        </div>
      </div>
      <script>
	  if(!window.slider) {
		var slider={};
	}

	slider.data= [
    {
        "id":"slide-img-1", // 与slide-runner中的img标签id对应
        "client":"标题1",
        "desc":"这里修改描述 这里修改描述 这里修改描述" //这里修改描述
    },
    {
        "id":"slide-img-2",
        "client":"标题2",
        "desc":"add your description here"
    },
    {
        "id":"slide-img-3",
        "client":"标题3",
        "desc":"add your description here"
    },
    {
        "id":"slide-img-4",
        "client":"标题4",
        "desc":"add your description here"
    } 
	];

	  </script> 
    </div>
    <!-- banner代码 结束 -->
    <div class="topnews">
      <h2><span>
	      <a href="/" target="_blank">
	      	${requestScope.catalogs[3].caname}</a>
	      <a href="/" target="_blank">
	      	${requestScope.catalogs[2].caname}</a>
	      <a href="/" target="_blank">
	      	${requestScope.catalogs[5].caname}</a>
	      </span><b>文章</b>推荐
      </h2>
      <div class="blogs">
        <figure><img src="images/01.jpg"></figure>
        <ul>
          <h3><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[0].arid}">${requestScope.articles[0].artitle}</a></h3>
          <p>${requestScope.articles[0].arcontent} ...</p>
          <p class="autor"><span class="lm f_l">
	          <a href="/">
	          		<c:forEach items="${requestScope.catalogs}" var="ctaloga">
	          			<c:if test="${requestScope.articles[0].caid eq catalog.caid}">
	          				${requestScope.caname}
	          			</c:if>
	          		</c:forEach>	          		
	          </a>
	          </span><span class="dtime f_l">${requestScope.articles[0].artime}</span>
	          <span class="viewnum f_r">浏览（<a href="/">${requestScope.articles[0].clicks}</a>）</span>
          </p>
        </ul>
      </div>
      
      <div class="blogs">
        <figure><img src="images/02.jpg"></figure>
        <ul>
          <h3><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[1].arid}">${requestScope.articles[1].artitle}</a></h3>
          <p>${requestScope.articles[1].arcontent} ...</p>
          <p class="autor"><span class="lm f_l">
	          <a href="/">
	          		<c:forEach items="${requestScope.catalogs}" var="ctaloga">
	          			<c:if test="${requestScope.articles[1].caid eq catalog.caid}">
	          				${requestScope.caname}
	          			</c:if>
	          		</c:forEach>	          		
	          </a>
	          </span><span class="dtime f_l">${requestScope.articles[1].artime}</span>
	          <span class="viewnum f_r">浏览（<a href="/">${requestScope.articles[1].clicks}</a>）</span>
          </p>
        </ul>
      </div>
      
       
      <div class="blogs">
        <figure><img src="images/03.jpg"></figure>
        <ul>
          <h3><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[2].arid}">${requestScope.articles[2].artitle}</a></h3>
          <p>${requestScope.articles[2].arcontent} ...</p>
          <p class="autor"><span class="lm f_l">
	          <a href="/">
	          		<c:forEach items="${requestScope.catalogs}" var="ctaloga">
	          			<c:if test="${requestScope.articles[2].caid eq catalog.caid}">
	          				${requestScope.caname}
	          			</c:if>
	          		</c:forEach>	          		
	          </a>
	          </span><span class="dtime f_l">${requestScope.articles[2].artime}</span>
	          <span class="viewnum f_r">浏览（<a href="/">${requestScope.articles[2].clicks}</a>）</span>
          </p>
        </ul>
      </div>
    <%-- 
      <div class="blogs">
        <figure><img src="images/02.jpg"></figure>
        <ul>
          <h3><a href="/">教你怎样用欠费手机拨打电话</a></h3>
          <p>初次相识的喜悦，让你觉得似乎找到了知音。于是，对于投缘的人，开始了较频繁的交往。渐渐地，初识的喜悦退尽，接下来就是仅仅保持着联系，平淡到偶尔在节假曰发短信互致问候...</p>
          <p class="autor"><span class="lm f_l"><a href="/">个人博客</a></span><span class="dtime f_l">2014-02-19</span><span class="viewnum f_r">浏览（<a href="/">459</a>）</span><span class="pingl f_r">评论（<a href="/">30</a>）</span></p>
        </ul>
      </div>
	--%>
    </div>
  </div>
  <div class="r_box f_r">
    <div class="tit01">
      <h3>关注我</h3>
      <div class="gzwm">
        <ul>
          <li><a class="xlwb" href="#" target="_blank">新浪微博</a></li>
          <li><a class="txwb" href="#" target="_blank">腾讯微博</a></li>
          <li><a class="rss" href="portal.php?mod=rss" target="_blank">RSS</a></li>
          <li><a class="wx" href="mailto:admin@admin.com">邮箱</a></li>
        </ul>
      </div>
    </div>
    <!--tit01 end-->
    <div class="ad300x100"> <img src="images/ad300x100.jpg"> </div>
    <div class="moreSelect" id="lp_right_select"> 
      <script>
window.onload = function ()
{
	var oLi = document.getElementById("tab").getElementsByTagName("li");
	var oUl = document.getElementById("ms-main").getElementsByTagName("div");
	
	for(var i = 0; i < oLi.length; i++)
	{
		oLi[i].index = i;
		oLi[i].onmouseover = function ()
		{
			for(var n = 0; n < oLi.length; n++) oLi[n].className="";
			this.className = "cur";
			for(var n = 0; n < oUl.length; n++) oUl[n].style.display = "none";
			oUl[this.index].style.display = "block"
		}	
	}
}
</script>
      <div class="ms-top">
        <ul class="hd" id="tab">
          <li class="cur"><a href="/">点击排行</a></li>
          <li><a href="/">最新文章</a></li>
          <li><a href="/">站长推荐</a></li>
        </ul>
      </div>
      <div class="ms-main" id="ms-main">
        <div style="display: block;" class="bd bd-news" >
          <ul>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${cArticles[0].arid}" target="_blank">${requestScope.cArticles[0].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${cArticles[1].arid}" target="_blank">${requestScope.cArticles[1].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${cArticles[2].arid}" target="_blank">${requestScope.cArticles[2].artitle}</a></li>
          </ul>
        </div>
        <div  class="bd bd-news">
          <ul>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[0].arid}"" target="_blank">${requestScope.articles[0].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[1].arid}"" target="_blank">${requestScope.articles[1].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[2].arid}"" target="_blank">${requestScope.articles[2].artitle}</a></li>       
          </ul>
        </div>
        <div class="bd bd-news">
          <ul>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[0].arid}"" target="_blank">${requestScope.articles[0].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[1].arid}"" target="_blank">${requestScope.articles[1].artitle}</a></li>
            <li><a href="${pageContext.request.contextPath}/welcome/findByIdArticle/${articles[2].arid}"" target="_blank">${requestScope.articles[2].artitle}</a></li>
          </ul>
        </div>
      </div>
      <!--ms-main end --> 
    </div>
    <!--切换卡 moreSelect end -->
    
    <div class="cloud">
      <h3>标签云</h3>
      <ul>
        <li><a href="/">${requestScope.catalogs[0].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[1].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[2].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[3].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[4].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[5].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[6].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[7].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[8].caname}</a></li>
        <li><a href="/">${requestScope.catalogs[9].caname}</a></li>
      </ul>
    </div>

    <div class="ad"> <img src="images/03.jpg"> </div>
    <div class="links">
      <h3><span>[<a href="/">申请友情链接</a>]</span>友情链接</h3>
      <ul>
        <li><a href="/">杨青个人博客</a></li>
        <li><a href="/">web开发</a></li>
        <li><a href="/">前端设计</a></li>
        <li><a href="/">Html</a></li>
        <li><a href="/">CSS3</a></li>
        <li><a href="/">Html5+css3</a></li>
        <li><a href="/">百度</a></li>
      </ul>
    </div>
  </div>
  <!--r_box end --> 
</article>
<footer>
  <p class="ft-copyright">兔小白博客 Design by DanceSmile 蜀ICP备11002373号-1</p>
  <div id="tbox"> <a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a> </div>
</footer>
</body>
</html>
