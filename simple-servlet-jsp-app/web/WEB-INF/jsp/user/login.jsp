<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 4/19/12
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<div>
  <form action="/foodvoting/login" method="post">
   <fieldset>
    <legend>Log in:</legend>
    Name: <input type="text" name="userName" size="30" /><br />
    Password: <input type="password" name="password" size="30" /><br />
    <input type="submit" value="login"/>
   </fieldset>
 </form>
</div>
</body>
</html>