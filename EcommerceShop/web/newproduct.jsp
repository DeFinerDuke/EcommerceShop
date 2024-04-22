
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EZShop | Hot Deals, Best Prices</title>
    </head>
    <body>
        <h1>Basic Product Information</h1>
        <%
            String url = ""; // Initialize URL variable
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                try {
                    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                    diskFileItemFactory.setRepository(new File("E:/Project/Source/StoreManagement/web"));
                    ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
                    List<FileItem> fileItems = fileUpload.parseRequest(request);
                    for (FileItem fileItem : fileItems) {
                        if (!fileItem.isFormField()) {
                            if (fileItem.getFieldName().equals("txtFile")) {
                                File file = new File("E:/Project/Source/StoreManagement/web/image/" + fileItem.getName());
                                fileItem.write(file);
                                url = request.getContextPath() + "/image/" + fileItem.getName();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        %>
       
        <form action="product" method="POST">
            Product name: <input type="text" name="txtName" value="" required=""><br><br>
            Description: <input type="text" name="txtDescription" value=""><br><br>
            Type: <input type="text" name="txtType" value="" required  placeholder="Example: t-shirt"><br><br>
            Price: <input type="number" name="txtPrice" value="" required placeholder="Example: 50000"><br><br>
            Depot: <input type="number" name="txtQuantity" value="" placeholder="Example: 100"><br><br>
            <%
                String storeID = (String) session.getAttribute("STOREID");
            %>
            <input type="hidden" name="linkIMG" value="<%= url %>">
            <input type="hidden" name="StoreID" value="<%= storeID%>">
            <input type="submit" name="action" value="SaveAndDisplay">
        </form>
    </body>
</html>
