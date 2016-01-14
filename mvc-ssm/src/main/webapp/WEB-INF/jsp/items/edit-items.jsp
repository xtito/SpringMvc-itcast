<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>

</head>
<body>
<!-- 显示错误信息 -->
<%--<c:if test="${allErrors!=null }">
	<c:forEach items="${allErrors }" var="error">
	${ error.defaultMessage}<br/>
</c:forEach>
</c:if>--%>

<%--<form id="itemForm" action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post" enctype="multipart/form-data">--%>
<form id="itemForm" action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post">
    <input type="hidden" name="id" value="${requestScope.items.id }"/>

    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td><label for="s_name">商品名称</label></td>
            <td><input id="s_name" type="text" name="name" value="${requestScope.items.name }"/></td>
        </tr>
        <tr>
            <td><label for="s_price">商品价格</label></td>
            <td><input id="s_price" type="text" name="price" value="${requestScope.items.price }"/></td>
        </tr>
        <tr>
            <td><label for="s_date">商品生产日期</label></td>
            <td><input id="s_date" type="text" name="createtime"
                       value="<fmt:formatDate value="${requestScope.items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
            </td>
        </tr>
        <%--<tr>
            <td><label>商品图片</label></td>
            <td>
                <c:if test="${ requestScope.items.pic !=null}">
                    <img src="/pic/${ requestScope.items.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file"  name="items_pic"/>
            </td>
        </tr>--%>
        <tr>
            <td><label for="s_desc">商品简介</label></td>
            <td>
                <textarea id="s_desc" rows="3" cols="30" name="detail">${requestScope.items.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>

</html>