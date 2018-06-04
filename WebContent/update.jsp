<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="book" method="get">
		<table width="80%" align="center">
			<tr>
				<td colspan="2"><h3>修改书籍</h3></td>
			</tr>
			<tr>
				<td>书名：<input type="hidden" name="op" value="update"> <input
					type="hidden" name="id" value="${book.id }">
				</td>
				<td><input type="text" name="name" value="${book.name }"></td>
			</tr>
			<tr>
				<td>分类</td>
				<td><select name="categoryId">
						<c:forEach items="${clist }" var="bean">

							<%-- <c:if test="${bean.id==book.categoryId }">
								<option value="${bean.id }" selected>${bean.name }</option>
							</c:if>
							<c:if test="${bean.id!=book.categoryId }">
								<option value="${bean.id }">${bean.name }</option>
							</c:if> --%>

							<option value="${bean.id }" <c:if test="${bean.id==book.categoryId }">selected</c:if>>${bean.name }</option> 

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="price" value="${book.price }"></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="author" value="${book.author }"></td>
			</tr>
			<tr>
				<td>出版日期：</td>
				<td><input type="text" name="pubDate" value="${book.pubDate }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>