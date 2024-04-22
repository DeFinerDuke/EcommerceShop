<%-- 
    Document   : account
    Created on : Apr 1, 2024, 10:09:44 AM
    Author     : BenNguyen
--%>
<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Address"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EZShop | Hot Deals, Best Prices</title>
    </head>
    <body>
        <%
            String action = request.getParameter("action");
            ArrayList<Address> addresses = (ArrayList<Address>) session.getAttribute("ADDRESS");
            User user = (User) session.getAttribute("USERINF");
        %>

        <form action="user" method="POST">
            <input type="submit" name="action" value="Profile">
        </form><br>
        <!--                <form action="user" method="POST">
                            <input type="submit" name="action" value="Banks & Cards"><br>
                        </form>-->
        <form action="user" method="POST">
            <input type="submit" name="action" value="Addresses">
        </form><br>
        <!--                <form action="user" method="POST">
                            <input type="submit" name="action" value="Privacy Settings"><br>
                        </form>-->
        <form action="user" method="POST">
            <input type="submit" name="action" value="Seller Centre">
        </form>
        <br>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Log out">
        </form><br>
        <a href="privacy.jsp">Change password</a><br><br>
        <a href="home.jsp">Back</a>
        <% if (!"Addresses".equals(action)) { %>
        <% if (user != null) {%>
        <form action="user" method="POST">
            <table border="1">
                <tr>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Gender</th>
                    <th>Date of birth</th>
                    <th>Action</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <td><%= user.getUserName()%></td>
                    <td><input type="text" name="Name" value="<%= user.getFullName()%>"></td>
                    <td><%= user.getEmail()%></td>
                    <td><input type="number" name="PhoneNumber" value="<%= user.getPhoneNumber()%>"></td>
                    <td>
                        <select name="Gender">
                            <option value="Male" <% if (user.getGender().equals("Male")) { %>selected<% } %>>Male</option>
                            <option value="Femal" <% if (user.getGender().equals("Femal")) { %>selected<% } %>>Female</option>
                            <option value="Other" <% if (user.getGender().equals("Other")) { %>selected<% }%>>Other</option>
                        </select>
                    </td>
                    <td><input type="date" name="DOB" value="<%= user.getDOB()%>"></td>
                    <td><input type="submit" value="Save" name="action"></td>
                    <td style="color: green"><%
                        String status = (String) session.getAttribute("UPDATESTATUS");
                        if (status != null) {
                        %>
                        <%= status%>
                    </td> 
                    <% } %>
                </tr>
            </table>
        </form> 
        <% }%>
        <% } else { %>
        <% if (addresses != null) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>Full name</th>
                    <th>Phone number</th>
                    <th>City</th>
                    <th>District</th>
                    <th>Ward</th>
                    <th>Street name and House number</th>
                    <th>Label</th>
                    <th>Default</th>
                    <th>Action</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>

                <% for (Address a : addresses) {%>
            <form action="user" method="POST">
                <tr>
                <input type="hidden" name="txtAddressid" value="<%= a.getAddressID()%>">
                <td><input type="text" name="txtFullname" value="<%= a.getFullName()%>"></td>
                <td><input type="tel" name="txtPhonenumber" value="<%= a.getPhoneNumber()%>"></td>
                <td><input type="text" name="txtCity" value="<%= a.getCity()%>"></td>
                <td><input type="text" name="txtDistrict" value="<%= a.getDistrict()%>"></td>
                <td><input type="text" name="txtWard" value="<%= a.getWard()%>"></td>
                <td><input type="text" name="txtStreetnamehouseno" value="<%= a.getStreetNameHouseNo()%>"></td>
                <td><input type="text" name="txtLabel" value="<%= a.getLabel()%>"></td>
                <td> <select name="txtDefault">
                        <option value="1" <% if (a.getDefault() == 1) { %>selected <% } %> >On</option>
                        <option value="0" <% if (a.getDefault() == 0) { %> selected <% } %>>Off</option>
                    </select></td>
                <td><input type="submit" name="action" value="Delete"</td>
                <td><input type="submit" name="action" value="Update"</td>
                </tr>
            </form>
            <% }%>
            <td>
                <a href="address.jsp">Add New Address</a>
            </td>
            <td style="color: green"><%
                String status = (String) request.getAttribute("STATUS");
                if (status != null) {
                %>
                <%= status%>
                <% } %>
            </td>
        </tbody>
    </table>
    <% } %>
    <% }%>
</body>
</html>
