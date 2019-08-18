

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layuiAdmin 网站用户 iframe 框</title>
  <#include "../common.ftl"/>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${ctx}/static/plugin/layui/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

  <div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin" style="padding: 20px 0 0 0;">
    <div class="layui-form-item">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="userName" value= "admin123"lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">手机号码</label>
      <div class="layui-input-inline">
        <input type="text" name="phone" value= "15322211111" lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="mail" value= "15322211111@123.com"lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">头像（layui）</label>
      <div class="layui-input-inline">
        <input type="text" name="avatar"  placeholder="请上传图片" autocomplete="off" class="layui-input" >
      </div>
      <button style="float: left;" type="button" class="layui-btn" id="layuiadmin-upload-useradmin">上传图片</button> 
    </div>
    <div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
    
    <div class="layui-form-item">
      <label class="layui-form-label">头像（HTML5方式）</label>
      <div class="layui-input-inline">
        <input type="file" name="images[0]" placeholder="请上传图片" autocomplete="off" class="layui-input" >
      </div>
    </div>
  </div>

  <script src="${ctx}/static/plugin/layui/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '${ctx}/static/plugin/layui/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form', 'upload'], function(){
    var $ = layui.$
    ,form = layui.form
    ,upload = layui.upload ;
    
    upload.render({
      elem: '#layuiadmin-upload-useradmin'
      ,url: layui.setter.base + 'json/upload/demo.js'
      ,accept: 'images'
      ,method: 'get'
      ,acceptMime: 'image/*'
      ,done: function(res){
       console.log(res);
        $(this.item).prev("div").children("input").val(res.data.src)
      }
    });
  })
  </script>
</body>
</html>