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

            <div style="margin-left:50px;">
                <div style="padding:10px;background-color:#e0ffff;line-height:200%">
                    <table style="font-size:15px;font-style:oblique;">
                        <c:forEach var="food" items="${foodType.foodList}">
                            <tr>

                                <td style="padding-bottom:10px; font-style:oblique;color:#4682b4;font-weight:bolder;width:120px">${food.foodName}</td>
                                <c:if test="${foodVoteCount[food.foodId] != null}">
                                    <td style="padding-bottom:10px;padding-left:50px;font-style:oblique;color:#4682b4;font-weight:bolder;width:80px">${foodVoteCount[food.foodId]}
                                        Votes
                                    </td>
                                </c:if>
                                <c:if test="${foodVoteCount[food.foodId] == null}">
                                    <td style="padding-bottom:10px;padding-left:50px;font-style:oblique;color:#4682b4;font-weight:bolder;width:80px">0 Votes
                                    </td>
                                </c:if>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <br/>
    </c:forEach>

</div>
</body>
</html>