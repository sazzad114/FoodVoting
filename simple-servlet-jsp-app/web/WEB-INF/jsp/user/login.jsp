<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 4/19/12
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setLocale value="ind" />
<fmt:setBundle basename="messages" />

<html>
<head><title>Simple jsp page</title></head>
<body>

<div style="margin:100px;width:350px;">

  <form action="/foodvoting/login" method="post">
   <fieldset style="padding-left:20px">
    <legend>Log in:</legend>
      <div>
        <c:if test="${param.message ne null}" >
           <span style="color:RED;">Incorrect user name or password</span>
        </c:if>
    </div>
    <br/>
    <fmt:message key="user.userName"/>:<br/><input type="text" name="userName" size="30" /><br /><br/>
    <fmt:message key="user.password"/>:<br/> <input type="password" name="password" size="30" /><br /><br/>
    <input type="submit" value="login"/><br/></br>
   </fieldset>
 </form>
</div>
</body>
</html>