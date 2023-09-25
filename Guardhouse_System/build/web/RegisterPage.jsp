<%-- 
    Document   : RegisterPage
    Created on : 29 Aug 2023, 9:43:11 am
    Author     : ariff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="RegisterPage.css">
    </head>
    <body>
        <h1>Register New Visitor</h1>
        <form action="MainController" method="post">
            <div class= "register-block">
                <table>
                    <tr>
                        <td class="Label">ID Type:</td>
                        <td>
                            <input type="radio" name="IDType" value="IC" id="IC"><label for="IC">IC</label>
                            <input type="radio" name="IDType" value="Passport" id="PP"><label for="PP">Passport Number</label>
                            <input type="radio" name="IDType" value="Permit" id="PM"><label for="PM">Permit Number</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="Label">Type of visitor:</td>
                        <td>
                            <input type="radio" name="VisitorType" value="Normal" id="Normal"><label for="IC">Normal Visitor</label>
                            <input type="radio" name="VisitorType" value="Lorry Driver" id="LorryDriver"><label for="PP">Lorry Driver</label>
                            <input type="radio" name="VisitorType" value="Surveyor" id="Surveyor"><label for="PM">Surveyor</label>
                            <input type="radio" name="VisitorType" value="Contractor" id="Contractor"><label for="PM">Contractor</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="Label">ID: </td>
                        <td><input type="text" name="ID" placeholder="IC or Passport No or Permit No"/></td>
                    </tr>
                    <tr>
                        <td class="Label">Full Name: </td>
                        <td><input type="text" name="FullName" placeholder="Full Name"/></td>
                    </tr>
                    <tr>
                        <td class="Label">Date of Briefing Start: </td>
                        <td><input type="date" name="BriefStart" placeholder="Briefing Date Start"/></td>
                    </tr>
                    <tr>
                        <td class="Label">Date of Briefing Expire: </td>
                        <td><input type="date" name="BriefEnd" placeholder="Briefing Date End"/></td>
                    </tr>
                    <tr>
                        <td class="Label">Company: </td>
                        <td><input type="text" name="Company" placeholder="Company"/></td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="register">
                <button type="submit">Register and Check In</button>
            </div>
        </form>
        <form action="MainController" method="get">
            <input type="hidden" name="action" value="back">
            <button type="submit" class="back-button">Back</button>
        </form>
       
    </body>
</html>
