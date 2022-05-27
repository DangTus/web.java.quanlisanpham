<%@page import="service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ProductService ps = new ProductService();
    int id, result;
    id = Integer.parseInt(request.getParameter("product"));
    result = ps.deleteProduct(id);

    if (result != 1) {
        out.print("<script> "
                + " alert('Có lỗi khi xóa!') "
                + " </script>");
    }
    response.sendRedirect(".");
%>