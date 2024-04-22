<%-- 
    Document   : create
    Created on : Apr 9, 2024, 9:01:05 PM
    Author     : BenNguyen
--%>

<%@page import="entity.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EZShop | Hot Deals, Best Prices</title>
    </head>
    <body>
        <h1>Finish your account</h1>
        <% String username = (String) session.getAttribute("USERNAME");%>
        <form action="MainController" method="POST">
            Your password: <input type="password" name="txtPassword" value="">
            <% RegistrationInsertError errors = (RegistrationInsertError) request.getAttribute("INSERTERROR");
                if (errors != null && errors.getPasswordLengthErr() != null) {
            %> 
            <font style="color: red"><%= errors.getPasswordLengthErr()%></font>
            <%   }%>
            <br><br>
            Confirm your password: <input type="password" name="txtConfirmPassword" value="">
            <%
                if (errors != null && errors.getConfirmNotMatch() != null) {
            %> 
            <font style="color: red"><%= errors.getConfirmNotMatch()%></font>
            <%   }%>
            <br><br>
            <input type="hidden" name="Username"  value="<%= username%>">
            <input type="submit" name="action" value="Save password">
        </form>
    </body>
</html>
