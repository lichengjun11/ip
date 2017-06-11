<%--
  Created by IntelliJ IDEA.
  User: lichengjun
  Date: 2017/6/11
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h4 style="text-align: center">IP 地址查询</h4>
  <form style="text-align: center" action="index" method="post">
    <input type="text" name="ip" placeholder="输入ip" >
    <input type="submit" value="查询">

  </form>
  <%
    String message = (String) request.getAttribute("message");
   if (message != null){
       out.print(message);
   }
  %>
  </body>
</html>
