<%-- 
    Document   : display
    Created on : Nov 20, 2015, 10:42:29 PM
    Author     : joanvasquez
--%>

<!--
    whatsapp: 1-809-978-5552
    kakaotalk: joanvasquez
    email: yoloprogramo22@gmail.com
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${!empty sessionScope.information}">
            <c:out value="${sessionScope.information}" escapeXml="false"/>
        </c:if>
        
    </body>
</html>
