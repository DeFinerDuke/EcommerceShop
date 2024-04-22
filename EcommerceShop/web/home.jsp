<%-- 
    Document   : Home
    Created on : Apr 1, 2024, 9:57:34 AM
    Author     : BenNguyen
--%>
<%@page import="entity.InsertedProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EZShop | Hot Deals, Best Prices</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("USERNAME");
            if (username == null) {
        %>
        <a href="guest.html">Seller Centre</a>
        <a href="guest.html">Profile</a>
        <a href="guest.html">Cart</a>
        <%
        } else {
        %>
        <form action="user" method="POST">
            <input type="submit" name="action" value="Seller Centre">
            <a href="account.jsp">Profile</a>
            <a href="cart.jsp">Cart</a>
        </form>
        <%
            }
        %>
    </form>
    <br>
    <form action="MainController">
        <input type="text" name="keyword" value="" placeholder="Search for products, brands and shops">
        <input type="submit" name="action" value="Search">
    </form>
    <br>
    <%
        ArrayList<InsertedProduct> listProduct = (ArrayList<InsertedProduct>) session.getAttribute("LISTPRODUCT");
    %>
    <table border="1">
        <thead>
            <tr>
                <th>Product name</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <% if (listProduct != null && !listProduct.isEmpty()) {
                    for (InsertedProduct product : listProduct) {
            %>
        <form action="preview.jsp" method="GET">
            <tr>
                <td>
                    <input type="image" src="<%= product.getLinkIMG()%>" width="200px" height="200px" alt="image"/>
                    <br>
                    <%= product.getName()%>
                </td>
                <td><input type="hidden" name="pice" value="<%= product.getPrice()%>"><%= product.getPrice()%></td>
            <input type="hidden" name="quantity" value="<%= product.getQuantity()%>">
            <input type="hidden" name="description" value="<%= product.getDescription()%>">
            </tr>
        </form>
        <% }
            }%>
    </tbody>
</table>
</body>
</html>
