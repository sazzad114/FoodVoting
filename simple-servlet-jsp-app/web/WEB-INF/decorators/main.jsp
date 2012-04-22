<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>

<head>
    <%@ include file="header.jsp" %>
    <title><decorator:title default="INTRANET"/></title>
    <decorator:head/>
    <style type="text/css">
        div.foot {
            align: center;
            background-color: #ffffcc;
            width: 100%;
            height: 60px;

        }
    </style>

</head>

<body bgcolor="#F5FFFF">


<div style="width:180;background-color:white;float:left;margin:20px">
    <div style="width:auto;border-bottom:1px solid #87ceeb">
         <a href="#" style="text-decoration:none">
             Home
         </a>
    </div>
    <div style="width:auto;border-bottom:1px solid #87ceeb">
         <a href="#" style="text-decoration:none">
             Food List
         </a>
    </div>
    <div style="width:auto;border-bottom:1px solid #87ceeb">
         <a href="#" style="text-decoration:none">
             My Account
         </a>
    </div>
    <div style="width:auto;border-bottom:1px solid #87ceeb">
         <a href="#" style="text-decoration:none">
             Admin
         </a>
    </div>
    <div style="width:auto;border-bottom:1px solid #87ceeb">
         <a href="#" style="text-decoration:none">
             Logout
         </a>
    </div>

</div>
<div style="margin-top:20px; margin-left:220px; width:auto; padding:20px; border:1px solid #87ceeb"  >
     <decorator:body/>
</div>


<%@ include file="footer.jsp" %>

</body>

</html>
