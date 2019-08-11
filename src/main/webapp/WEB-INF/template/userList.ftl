<!DOCTYPE html>
<html>
   <head>
    <title>用户列表</title>
    <#include "common.ftl"/>
   </head>
   <body>
  
	  <div class="container">
	  <h2>用户列表</h2>
	  <p>.table-sm 类用于通过减少内边距来设置较小的表格:</p>            
	  <table class="table table-bordered table-sm">
	    <thead>
	      <tr>
	        <th>用户名</th>
	        <th>手机</th>
	        <th>邮箱</th>
	      </tr>
	    </thead>
	    <tbody>
	     <#if userList?? && (userList?size > 0)>
		      <#list userList as user>
				  <tr>
			        <td>${user.userName!}</td>
			        <td>${user.phone!}</td>
			        <td>john@example.com</td>
			      </tr>
	          </#list>
	      </#if>
	      
	    </tbody>
	  </table>
	</div>
   

</html>