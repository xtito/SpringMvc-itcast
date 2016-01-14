<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@include file="/inc.jsp" %>
<!DOCTYPE html>

<%--
  
  User: Zy
  Date: 2015/12/22
  Time: 11:04
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>查询商品列表</title>
</head>
<body>

    <form action="${ctx}" method="post">
        查询条件：
        <table width="100%" border=1>
            <tr>
                <td><input type="submit" value="查询"/></td>
                <td><input type="button" value="新增" onclick="window.location.href='${ctx}/save.action'" /></td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border=1>
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.itemsList }" var="item">
                <tr>
                    <td>${item.name }</td>
                    <td>${item.price }</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${item.detail }</td>

                    <td><a href="${ctx}/items/editItems.action?id=${item.id}">修改</a></td>

                </tr>
            </c:forEach>

        </table>
    </form>

</body>
</html>
