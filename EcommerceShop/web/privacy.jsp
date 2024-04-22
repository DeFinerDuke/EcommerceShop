<%-- 
    Document   : privacy
    Created on : Apr 3, 2024, 1:44:42 PM
    Author     : BenNguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EZShop | Hot Deals, Best Prices</title>
</head>
<body>
    <h1>Adjust the account</h1>
    <form action="user" method="POST">
        Your current password: <input type="text" name="OldPassword" value=""><br><br>
        Your new password: <input type="text" name="NewPassword" value=""><br><br>
        Confirm your password: <input type="text" name="ConfirmPassword" value=""><br><br>
        <% String error = (String) request.getAttribute("NULL_ERROR");
           if (error != null) { %>
            <%= error%><br>
        <% }
           String checkedPassword = (String) request.getAttribute("CHECKED_PASSWORD");
           if (checkedPassword != null) { %>
          <%= checkedPassword%><br>
        <% }
           String errorChange = (String) request.getAttribute("ERROR_CHANGE");
           if (errorChange != null) { %>
           <%= errorChange%><br>
        <% }
           String passwordStatus = (String) request.getAttribute("PASSWORD_STATUS");
           if (passwordStatus != null) { %>
          <%= passwordStatus%><br>
        <% } %>
        <input type="submit" name="action" value="Change Password">
    </form>
        <a href="account.jsp">Back</a>
</body>
</html>
