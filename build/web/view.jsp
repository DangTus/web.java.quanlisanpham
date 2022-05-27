<%@page import="service.ProductService"%>
<%@page import="model.Product"%>
<%@page import="model.Category"%>
<%@page import="service.CategoryService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body>
    <div class="container">
        <table class="myTable">
            <tr>
                <td class="myTd">
                    <p>Nhóm sản phẩm</p>
                    <%
                        CategoryService categoryService = new CategoryService();
                        for (Category category : categoryService.getAllCategory()) {
                    %>
                    <a href=".?act=view&category=<% out.print(category.getIdCaetgory()); %>"><% out.print(category.getNameCategory()); %></a><br>
                    <%
                        }
                    %>
                </td>
                <td class="myTd">
                    <p>Danh sách sản phẩm</p>
                    <table id="spTable">
                        <tr>
                            <th>STT</th>
                            <th>Tên sản phẩm</th>
                            <th>Giá SP</th>
                            <th>Thao Tác</th>
                        </tr> 
                        <%
                            int category;
                            ProductService productService = new ProductService();

                            if (request.getParameter("category") == null) {
                                category = 1;
                            } else {
                                category = Integer.parseInt(request.getParameter("category"));
                            }

                            for (Product product : productService.getProductByCategory(category)) {
                        %>
                        <tr>
                            <td><% out.print(product.getIdProduct()); %></td>
                            <td><% out.print(product.getNameProduct()); %></td>
                            <td><% out.print(String.format("%.0f", product.getPrice()) + " $"); %></td>
                            <td><a href="#" onclick="deleteWarning(<% out.print(product.getIdProduct()); %>)">Xóa</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <div class="addButtonBox">
                        <a href=".?act=add" class="addButtonView">Thêm</a>
                    </div>                
                </td>            
            </tr>
        </table>
    </div>

    <script>
        function deleteWarning(idProduct) {
            if(confirm("Bạn có chắc chắn muốn xóa không?")) {
                location.href = ".?act=delete&product="+idProduct
            }
        }
    </script>
</body>