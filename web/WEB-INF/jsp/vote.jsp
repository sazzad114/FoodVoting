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

         <div style="padding:10px;border:1px solid #b0e0e6; margin-bottom:10px">
            <c:set var="isVoted" value="false"></c:set>
            <li style="list-style-type:none;color:#6495ed; font-style:oblique;font-weight:bolder;font-size:15px"">${foodType.foodTypeName}</li>
            <c:if test="${foodType.votedFood ne null}">
                </br><li style="color:red; font-style:oblique;font-weight:bolder;font-size:15px; list-style-type:none">You have already voted for this type of foods</li>
                <c:set var="isVoted" value="true"></c:set>
            </c:if>
            <br/>

            <div style="margin-left:50px">

                    <c:if test="${isVoted eq 'true'}">
                        <c:forEach var="food" items="${foodType.foodList}">
                            <li style="color:#3864b4; font-style:oblique;font-weight:bolder;font-size:12px">${food.foodName}</li>
                            <br/>
                        </c:forEach>
                    </c:if>
                    <c:if test="${isVoted eq 'false'}">
                        <form action="/foodvoting/vote" method="post">

                            <c:forEach var="food" items="${foodType.foodList}">
                                <input type="radio" id="${food.foodName}" name="${foodType.foodTypeName}"
                                       value="${food.foodName}">
                                <label style="color:#3864b4; font-style:oblique;font-weight:bolder;font-size:12px" for="${food.foodName}">${food.foodName}</label></br></br>
                            </c:forEach>
                            <input type="submit" value="Vote">
                        </form>
                    </c:if>

            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>