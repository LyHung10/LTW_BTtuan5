<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<script>
    function validateForm() {
        var statusChecked = document.querySelector('input[name="status"]:checked');
        if (!statusChecked) {
            alert("Vui lòng chọn trạng thái.");
            return false; // Ngăn gửi biểu mẫu nếu không chọn trạng thái
        }
        return true; // Cho phép gửi biểu mẫu nếu trạng thái đã được chọn
    }
</script>

<form action="${pageContext.request.contextPath}/admin/category/update" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
    <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid}" hidden="hidden"><br>

    <label for="categoryname">Category Name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}" required><br> <!-- Thêm required -->

    <label for="images">Images:</label><br>
    <%-- Gán URL ảnh --%>
			<c:choose>
				<c:when test="${cate.images.substring(0,5) != 'https'}">
					<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
				</c:when>
				<c:otherwise>
					<c:url value="${cate.images}" var="imgUrl"></c:url>
				</c:otherwise>
			</c:choose>
    <img height="150" width="200" src="${imgUrl}" /><br>

    <input type="file" id="images" name="images"><br>

    <label>Status:</label><br>
    <input type="radio" id="ston" name="status" value="1" <c:if test="${cate.status == 1}">checked</c:if>>
    <label for="ston">Hoạt động</label><br>
    
    <input type="radio" id="stoff" name="status" value="0" <c:if test="${cate.status == 0}">checked</c:if>>
    <label for="stoff">Khóa</label><br>

    <br>
    <input type="submit" value="Update">
</form>
