<%-- 
    Document   : uploadFile
    Created on : Apr 6, 2024, 7:36:11 AM
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
        <h1>Basic Product Information</h1>
        <form action="newproduct.jsp" method="POST" enctype="multipart/form-data">
            Product photo: <input type="file" id="txtFile" name="txtFile" value="" required="" accept="image/*"" required=""><br><br>
            <input type="submit" value="Next">
        </form>
    </body>
</html>
