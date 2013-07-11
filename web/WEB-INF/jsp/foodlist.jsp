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
            <li style="color:#6495ed; font-style:oblique;font-weight:bolder;font-size:15px">${foodType.foodTypeName}</li>
            <br/>

            <div style="padding:20px;border:1px solid #87ceeb">
                <table style="font-size:15px;font-style:oblique;">
                    <c:forEach var="food" items="${foodType.foodList}">
                        <tr style="margin-bottom:10px">
                            <td style="width:120px;"><img style="margin-bottom:10px"
                                                          src="/foodvoting/img/${food.foodName}.jpeg"/></td>
                            <td style="vertical-align:text-top; font-style:oblique;color:#4682b4;font-weight:bolder; width:120px;padding-left:50px">${food.foodName}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <br/>
    </c:forEach>
</div>
</body>
</html>