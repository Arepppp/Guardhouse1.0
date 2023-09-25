<%-- 
    Document   : CheckoutTable
    Created on : 20 Sep 2023, 3:35:30 pm
    Author     : ariff
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="GuardHouse.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
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
        <h1>VISITOR REPORTS</h1>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Company</th>
                <th>Check In</th>
                <th>Check Out</th>
                <th>Time Inside</th>
            </tr>
            <%
                Connection con = DBConnection.getConnection();
                Statement ps = con.createStatement();
                String str = "SELECT * FROM checkout INNER JOIN visitor ON visitor.Identification = checkout.Identification";
                ResultSet rs = ps.executeQuery(str);

                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString("FullName")%></td>
                <td><%=rs.getString("Company")%></td>
                <td><%=rs.getString("CheckIn")%></td>
                <td><%=rs.getString("CheckOut")%></td>
                <td><%=rs.getString("TimeInside")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
