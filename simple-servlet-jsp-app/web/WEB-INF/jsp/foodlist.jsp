<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 4/22/12
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Food List</title></head>
<body>
<div>
    <c:forEach var="foodType" items="${FOODTYPELIST}">

        <div>
            <li style="list-style-type:none">${foodType.foodTypeName}</li>

            <br/>

            <div style="margin-left:50px">
                <c:forEach var="food" items="${foodType.foodList}">
                    <li>${food.foodName}</li>
                    <br/>
                </c:forEach>
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>