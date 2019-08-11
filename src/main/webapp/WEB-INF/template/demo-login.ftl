<!DOCTYPE html>
<html lang="zh">
<head>
	  <#include "demo-common.ftl"/>
	  <title>用户登录表单 - Bootstrap 模板</title>

</head>
<body>
	

  	
<div class="container">
  <h2>用户登录表单</h2>
  <font color="red">
	  <#if error??>
	    ${error!}
	  <#else>
	   ${RequestParameters.error!}
	  </#if>
  </font> 
  <br/>  
  
  <form name="frmLogin" action="${ctx}/auth/login" method="post">
    <div class="form-group">
      <label for="userName">用户名:</label>
      <input type="text" name ="userName"  class="form-control" id="userName" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">密码:</label>
      <input type="password" name ="password"  class="form-control" id="pwd" placeholder="Enter password">
    </div>
    <div class="form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox"> Remember me
      </label>
    </div>
     <div class="form-group">
       <label for="forwardUrl">调转地址:</label>
        <input type="text"  name="forwardUrl" value = "${RequestParameters.forwardUrl!}" class="form-control" id="forwardUrl" placeholder="Enter password">
      </label>
    </div>
     
     
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>


 
</body>
</html>


