<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<!--不同大小的设备上都能统一友好显示-->
<meta name="viewport" content="width=device-width">
<title>主页面</title>
<!-- 在指向图片或其他媒体文件、样式表和脚本的URL地址中省略http: https:协议部分，除非已知相应文件不能同时兼容2个协议-->
<!-- Recommended -->
<!-- <script src="//www.hengtiansoft.com/js/demo.js"></script> 
-->
<#include "demo-common.ftl"/>
</head>
<body>
   ${ctx}
    <h1>Spring MVC + Freemarker Hello World example - hello</h1>
    ${userName!}，您好，欢迎来到主页面！<a href="${ctx}/auth/logout"> 注销</a><br>
  local: ${RequestParameters.local!}<br>
  ordersId: ${ordersId!}<br>
   
</body>
</html>