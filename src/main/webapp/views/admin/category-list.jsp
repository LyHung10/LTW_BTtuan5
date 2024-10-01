<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<a href="${pageContext.request.contextPath }/admin/category/add"> Add Category</a>
<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>Category Name</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${listcate}" var="cate" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>

			<%-- Gán URL ảnh --%>
			<c:choose>
				<c:when test="${cate.images.substring(0,5) != 'https'}">
					<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
				</c:when>
				<c:otherwise>
					<c:url value="${cate.images}" var="imgUrl"></c:url>
				</c:otherwise>
			</c:choose>

			<td><img height="150" width="200" src="${imgUrl}" /></td>
			<td>${cate.categoryid }</td>
			<td>${cate.categoryname }</td>
			<td>
				<c:if test="${cate.status == 1 }">
					<span>Hoạt động</span>
				</c:if> 
				<c:if test="${cate.status != 1 }">
					<span>Khóa</span> 
				</c:if>
			</td>
			<td>
				<a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>" class="center">Sửa</a> |
				<a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>" class="center">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>
