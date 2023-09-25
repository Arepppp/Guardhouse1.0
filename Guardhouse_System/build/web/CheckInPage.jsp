<%-- 
    Document   : CheckInPage
    Created on : 24 Aug 2023, 10:48:56 pm
    Author     : ariff
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="GuardHouse.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Main Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="mainPage.css">
    </head>
    <body>
        <h1>SEARCH USER</h1>
        <form action="MainController" method="get">
            <div class="search-block">
                <div class="search-block-h1">Enter Credentials</div>
                <input type="text" name="QueryValue" placeholder="IC or Passport No or Permit No" id="QueryValue"/>
                <input type="hidden" name="action" value="search">
                <button type="submit">Search</button>
            </div>
        </form>
        <%
            String ID = (String) request.getAttribute("IDE");
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `visitor` WHERE Identification = ?");
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        %>
        <table class ="centerMargin" border="1">
            <tr>
                <td>Full Name:</td>
                <td><%=rs.getString("FullName")%></td>
            </tr>
            <tr>
                <td>Identification:</td>
                <td><%=rs.getString("Identification")%></td>
            </tr>
            <tr>
                <td>Identification Type:</td>
                <td><%=rs.getString("IdentificationType")%></td>
            </tr>
            <tr>
                <td>Type of Visitor:</td>
                <td><%=rs.getString("VisitorType")%></td>
            </tr>
            <tr>
                <td>Briefing Valid Till:</td>
                <td><%=rs.getString("BriefingDateEnd")%></td>
            </tr>
        </table>
        <form action="MainController" method="get">
            <input type="hidden" name="ID" value="<%=rs.getString("Identification")%>">
            <input type="hidden" name="action" value="checkin">
            <button class="nodata-block-button" type="submit">Check In</button>
        </form>
        <%
            }
        %>
        
        <h1 class="centerMargin">CHECKED IN USERS</h1>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Check In Timestamp</th>
                <th>Company</th>
                <th>Checkout</th>
            </tr>
            <%
                Statement ps1 = con.createStatement();
                String str1 = "SELECT * FROM visitor INNER JOIN checkin ON visitor.Identification = checkin.Identification";
                ResultSet rs1 = ps1.executeQuery(str1);

                while (rs1.next()) {

            %>
            <tr>
                <td><%=rs1.getString("FullName")%></td>
                <td><%=rs1.getString("CheckIn")%></td>
                <td><%=rs1.getString("Company")%></td>
                <td>
                    <form action="MainController" method="get">
                        <input type="hidden" name="Identification" value="<%=rs1.getString("Identification")%>">
                        <input type="hidden" name="action" value="checkout">
                        <button class="checkout-block-button" type="submit">Checkout</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
