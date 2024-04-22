<%-- 
    Document   : address
    Created on : Apr 15, 2024, 2:56:00 PM
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
        <form action="user" method="GET">
            Full name: <input type="text" name="txtFullname" value="" required=""><br><br>
            Phone number: <input type="tel" name="txtPhonenumber" value="" required=""><br><br>
            City: <input type="text" name="txtCity" value=""><br><br>
            District <input type="text" name="txtDistrict" value=""><br><br>
            Ward: <input type="text" name="txtWard" value=""><br><br>
            Street name & House no: <input type="text" name="txtStreetnamehouseno" value=""><br><br>
            Label <input type="text" name="txtLabel" value=""><br><br>
            Default: <select name="txtDefault">
                <option value="1">On</option>
                <option value="0">Off</option>
            </select>
            <br><br>
            <input type="submit" name="action" value="Add address">
        </form>
    </body>
</html>
