<%-- 
    Document   : seller
    Created on : Apr 3, 2024, 11:17:40 AM
    Author     : BenNguyen
--%>
<%@page import="entity.InsertedProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EZShop | Seller Channel</title>
    </head>
    <body>

        <h3>Product Management</h3>
        <form action="product" method="POST">
            <input type="submit" name="action" value="All Products">
        </form><br>
        <a href="uploadFile.jsp">Add Products</a>
<!--        <h3>Shop Management</h3> 
        <form action="product"method="POST">
            <input type="submit" name="action" value="Profile">
        </form>
        <br>
        <form action="product" method="POST">
            <input type="submit" name="action" value="Update Shop">
        </form> -->
        <br>
        <a href="home.jsp">Home</a>
    <body>
        <%
            ArrayList<InsertedProduct> listProduct = (ArrayList<InsertedProduct>) session.getAttribute("PRODUCTINVENTORY");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product name</th>
                    <th>Price</th>
                    <th>Depot</th>
                    <th>Created date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% if (listProduct != null && !listProduct.isEmpty()) {
                        for (InsertedProduct product : listProduct) {
                %>
                <tr>
                    <td><%= product.getProductID()%></td>
                    <td>
                        <img src="<%= product.getLinkIMG()%>" width="100px" height="100px" alt="image"/><br>
                        <%= product.getName()%>
                    </td>
                    <td><%= product.getPrice()%></td>
                    <td><%= product.getQuantity()%></td>
                    <td><%= product.getCreatedDate()%></td>
                    <td>
                        <select name="action">
                            <option>Delete</option>
                            <option>Update</option>
                        </select>
                    </td>
                </tr>
                <% }
                }%>
            </tbody>
        </table>
    </body>

</html>
