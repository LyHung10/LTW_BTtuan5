<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file= "/commons/taglib.jsp"%>
    
<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname" required><br><br>

    <label for="images">Link images:</label><br>
    <input type="text" id="images" name="images"><br><br>

    <label for="images1">Upload file:</label><br>
    <input type="file" id="images1" name="images1"><br><br>

    <label>Status:</label><br>
    <input type="radio" id="ston" name="status" value="1" required>
    <label for="ston">Hoạt động</label><br>
    <input type="radio" id="stoff" name="status" value="0">
    <label for="stoff">Khóa</label><br><br>

    <input type="submit" value="Insert">
</form>
