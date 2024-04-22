<%-- 
    Document   : registration
    Created on : Apr 8, 2024, 10:30:56 AM
    Author     : BenNguyen
--%>

<%@page import="entity.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign up today! | EZShop</title>
    </head>
    <body>
        <h1>EZShop Sign Up</h1>
        <h4>It's quick and easy</h4>
        <form action="MainController" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="txtUsername" required><% RegistrationInsertError errors = (RegistrationInsertError) request.getAttribute("INSERTERROR");
                if (errors != null && errors.getUsernameLengthErr() != null) {%> <font style="color: red">*<%= errors.getUsernameLengthErr()%></font>
            <% } %>
            <br><br>
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="txtFullname" required> <% if (errors != null && errors.getFullNameLengthErr() != null) {%><font style="color: red">*<%= errors.getFullNameLengthErr()%></font>
            <% } %>
            <br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="txtEmail" required> <% if (errors != null && errors.getEmailIsInvalid() != null) {%> <font style="color: red">*<%= errors.getEmailIsInvalid()%></font>
            <% } %>
            <br><br>
            <label for="phonenumber">Phone Number:</label>
            <input type="tel" id="phonenumber" name="txtPhonenumber"><% if (errors != null && errors.getPhonenumberIsInvalid() != null) {%> <font style="color: red">*<%= errors.getPhonenumberIsInvalid()%></font>
            <% }%>
            <br><br>
            <label for="gender">Gender:</label>
            <select id="gender" name="txtGender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
            <br><br>
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="txtDOB">
            <br><br>
            <input type="submit" name="action" value="Next">
        </form>
    </body>
</html>
