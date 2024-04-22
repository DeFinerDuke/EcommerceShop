<%-- 
    Document   : newshop
    Created on : Apr 17, 2024, 9:55:59 AM
    Author     : BenNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String username = (String) session.getAttribute("USERNAME");%>
        <h1>Welcome, <%= username%>! </h1>
        <h2>Are you ready to sell?</h2>
        <h3>It's so simple and fast!</h3>
        <h1>Register shop</h1>
        <%
            String storename = (String) request.getAttribute("STORENAME");
        %>
        <form action="store" method="POST">
            Input your store name: <input type="text" name="txtStorename" value="<%= (storename != null) ? storename : "" %>" required=""><br><br>
            To verify, input your password: <input type="password" name="txtPassword" value="" required=""><br><br>
            <input type="submit" name="action" value="Create Now">
        </form>
        <br>
        <%
            String error = (String) request.getAttribute("ERRORPASSWORD");
            if (error != null) {
        %>
        <font style="color: red"><%= error%></font>
        <% }%>
    </body>
</html>
