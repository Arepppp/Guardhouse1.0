<%-- 
    Document   : AlreadyCheckedIn
    Created on : 15 Sep 2023, 8:43:58 am
    Author     : ariff
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="GuardHouse.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
                <h4 class="red-font">THIS USER IS CHECKED IN</h4>
            </div>
        </form>

        <h1 class="centerMargin">CHECKED IN USERS</h1>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Check In Timestamp</th>
                <th>Company</th>
                <th>Checkout</th>
            </tr>
            <%
                Connection con = DBConnection.getConnection();
                Statement ps = con.createStatement();
                String str = "SELECT * FROM visitor INNER JOIN checkin ON visitor.Identification = checkin.Identification";
                ResultSet rs = ps.executeQuery(str);

                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getString("FullName")%></td>
                <td><%=rs.getString("CheckIn")%></td>
                <td><%=rs.getString("Company")%></td>
                <td>
                    <form action="MainController" method="get">
                        <input type="hidden" name="Identification" value="<%=rs.getString("Identification")%>">
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
