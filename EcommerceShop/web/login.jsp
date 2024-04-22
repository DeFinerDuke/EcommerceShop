<%-- 
    Document   : Login
    Created on : Mar 31, 2024, 4:19:56 PM
    Author     : BenNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login now to start shopping! | EZShop</title>
    </head>
    <body>
        <h1>Welcome to EZShop</h1>
        <h2>Login</h2>
        <form action="MainController" method="POST">
            <%
                String Username = (String) request.getAttribute("USERNAME");
                String Password = (String) request.getAttribute("PASSWORD");
            %>
            <label for="username">Username:</label>
            <input type="text" id="username" name="txtUsername" required value="<%=(Username != null) ? Username : ""%>">
            <br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="txtPassword" required value="<%=(Password != null) ? Password : ""%>">
            <br>
            <% String error = (String) request.getAttribute("ERRORLOGIN"); %>
            <% if (error != null) {%>
            <font style="color: red"><%= error%></font>
            <% }%>
            <br><br>
            <input type="submit" name="action" value="Log in">
        </form><br>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Continue as guest">
        </form>
        <br>
        New to EZShop? <a href="signup.jsp">Sign up</a>
    </div>
</body>
</html>
