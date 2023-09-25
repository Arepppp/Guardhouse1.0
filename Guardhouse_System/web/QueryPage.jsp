<%-- 
    Document   : QueryPage
    Created on : 25 Sep 2023, 7:44:25 pm
    Author     : ariff
--%>

<%@page import="java.util.List"%>
<%@page import="GuardHouse.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>VISITOR DATA</h1>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Identification</th>
                <th>Identification Type</th>
                <th>Company</th>
                <th>Visitor Type</th>
                <th>Briefing Date Starts</th>
                <th>Briefing Date Expires</th>
            </tr>
            <%
                List<User> Output = (List<User>) request.getAttribute("Output");
                for (User user: Output) {
            %>
            <tr>
                <td><%=user.getFullName()%></td>
                <td><%=user.getIdentification()%></td>
                <td><%=user.getIdentificationType()%></td>
                <td><%=user.getCompany()%></td>
                <td><%=user.getVisitorType()%></td>
                <td><%=user.getBriefingDateStart()%></td>
                <td><%=user.getBriefingDateEnd()%></td>
            </tr>
            <%
                }
            %>
    </body>
</html>
