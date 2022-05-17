<%@page import="java.util.List"%>
<%@page import="service.TheLoaiService"%>
<%@page import="model.TheLoai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body>
    <table id="myTable">
        <tr>
            <td class="myTd">
                <p>Nhóm sản phẩm</p>
                <%
                    TheLoaiService theLoaiService = new TheLoaiService();
                    List<TheLoai> theLoais = theLoaiService.getAllTheLoai();
                    for (TheLoai theLoai : theLoais) {
                %>
                <a href=".?act=view&tl=<% out.print(theLoai.getMaTL()); %>"><% out.print(theLoai.getTenTL()); %></a><br>
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
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>