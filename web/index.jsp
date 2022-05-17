<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sản phẩm</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <%
        String act = request.getParameter("act");
        if (act == null) {
            act = "view";
        }

        switch (act) {
            case "view":
    %>
    <%@ include file = "view.jsp"%>
    <%                break;
            default:
                throw new AssertionError();
        }
    %>    
</html>
