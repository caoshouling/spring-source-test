<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>出错了</title>
  <meta name="renderer" content="webkit">
  <#include "common.ftl"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${ctx}/static/plugin/layui/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${ctx}/static/plugin/layui/layuiadmin/style/admin.css" media="all">
</head>
<body>


<div class="layui-fluid">
  <div class="layadmin-tips">
    <i class="layui-icon" face>&#xe664;</i>
    
    <div class="layui-text" style="font-size: 20px;">
      系统内部异常：${jsonResponse.code}-${jsonResponse.message!}
    </div>
    
  </div>
</div>


  <script src="${ctx}/static/plugin/layui/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '${ctx}/static/plugin/layui/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index']);
  </script>
</body>
</html>