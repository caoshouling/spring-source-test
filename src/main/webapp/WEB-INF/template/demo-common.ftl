
<!DOCTYPE html>
<html>
   <head>
     
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <#assign ctx = request.contextPath />
      
      <!-- 2.让IE游览器渲染试图，按照edge游览器的方法 -->
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  
	  <title>Bootstrap 模板</title>
      <!-- 引入 Bootstrap -->
      <link href="${ctx}/static/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <!-- 在指向图片或其他媒体文件、样式表和脚本的URL地址中省略http: https:协议部分，除非已知相应文件不能同时兼容2个协议-->
	  <!-- Recommended -->
	  <!-- <script src="//www.hengtiansoft.com/js/demo.js"></script> -->
      <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
      
   </head>
   <body>
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${ctx}/static/js/jquery-3.4.1.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="${ctx}/static/plugin/bootstrap/js/bootstrap.min.js"></script>
   </body>
</html>