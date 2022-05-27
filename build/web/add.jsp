<%@page import="service.ProductService"%>
<%@page import="model.Product"%>
<%@page import="model.Category"%>
<%@page import="service.CategoryService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (request.getParameter("submit") != null) {
        Product p = new Product();
        p.setNameProduct(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setCategory(Integer.parseInt(request.getParameter("category")));

        ProductService ps = new ProductService();
        int result = ps.insertProduct(p);

        if (result == 1) {
            out.print("<script> "
                    + " alert('Thêm thành công'); "
                    + " location.href = '.?act=view&category="+ p.getCategory() +"'; "
                    + " </script>");
        } else {
            out.print("<script> alert('Thêm không thành công, vui lòng thêm lại') </script>");
        }
    }
%>

<body>
    <div class="container">
        <form action=".?act=add" method="POST">
            <table class="addTable">
                <tr>
                    <th colspan="2">
                        <h4>Thêm sản phẩm</h4>
                    </th>
                </tr>
                <tr>
                    <td>Tên sản phẩm</td>
                    <td><input type="text" id="name" required name="name" class="inputAdd"></td>
                </tr>
                <tr>
                    <td>Giá</td>
                    <td><input type="number" id="price" name="price" min="1" required onchange="checkNum()" class="inputAdd"></td>
                </tr>
                <tr>
                    <td>Thể loại</td>
                    <td>
                        <select class="inputAdd" name="category">
                            <%
                                CategoryService categoryServiceAdd = new CategoryService();
                                for (Category categoryAdd : categoryServiceAdd.getAllCategory()) {
                            %>
                            <option value="<% out.print(categoryAdd.getIdCaetgory()); %>"><% out.print(categoryAdd.getNameCategory()); %></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="submit" value="Thêm" class="addButton">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <script>
        function checkNum() {
            num = document.getElementById('price')
            if (num.value < 1) {
                num.value = 1
            }
        }


    </script>
</body>