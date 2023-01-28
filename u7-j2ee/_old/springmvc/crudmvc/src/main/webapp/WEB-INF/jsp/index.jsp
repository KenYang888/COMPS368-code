<%-- 
    Document   : index
    Created on : Mar 2, 2019, 11:35:59 PM
    Author     : cyrus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All message</title>
        <script>
            function delMsg(_id){
                if(confirm('Are you sure to delete message with id {' + _id + '}?')){
                    var _obj = document.getElementById("delId");
                    _obj.value = _id;
                    _obj.form.submit();
                }
            }
        </script>
    </head>
    <body>
        <form:form method="POST" modelAttribute="msgForm">
            <form:label path="uName">
                Your Name:
            </form:label>
            <form:input type="text" path="uName" />
            <br />
            <form:label path="msg">
                Your Name:
            </form:label>
            <form:input type="text" path="msg" />
            <br />            
            <input type="submit" value="Post" />
        </form:form>
        <hr/>
        <c:forEach var="m" items="${allMsg}">
            <table border="1">
            <tr>
                <td>${m.id}</td>
                <th>Name</th>
                <td>${m.uName}</td>
                <th>Create Date</th>
                <td>${m.create_dtm}</td>                    
            </tr>
            <tr>
                <th colspan="2">Message</th>
                <td colspan="3">${m.msg}</td>                    
            </tr>
            <tr>
                <td>
                    <input type="button" value="Delete" onclick="javascript:delMsg(${m.id});" />
                </td>
            </tr>
            </table>
        </c:forEach>
        <form action="<c:url value = "/del"/>" method="POST" name="delForm">
            <input type="hidden" id="delId" name="delId" value="-1" />
        </form>
    </body>
</html>