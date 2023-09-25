<%-- 
    Document   : VisitorTable
    Created on : 20 Sep 2023, 4:31:15 pm
    Author     : ariff
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="GuardHouse.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitors</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="mainPage.css">
    </head>
    <body>
        <form action="MainController" method="get">
            <input type="hidden" name="action" value="back">
            <button type="submit" class="back-button">Back</button>
        </form>
        <form action="MainController" method="get">
            <input type="text" name="SearchValue" placeholder="Search..">
            <input type="hidden" name="action" value="QueryVis">
            <button type="submit" class="back-button">Search</button>
        </form>
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
                Connection con = DBConnection.getConnection();
                Statement ps = con.createStatement();
                String str = "SELECT * FROM visitor";
                ResultSet rs = ps.executeQuery(str);

                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString("FullName")%></td>
                <td><%=rs.getString("Identification")%></td>
                <td><%=rs.getString("IdentificationType")%></td>
                <td><%=rs.getString("Company")%></td>
                <td><%=rs.getString("VisitorType")%></td>
                <td><%=rs.getString("BriefingDateStart")%></td>
                <td><%=rs.getString("BriefingDateEnd")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
