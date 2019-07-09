<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
    <div align="center">添加</div>
    <table width="500" border="1" align="center">
        <tr>
            <td>类型</td>
            <td>
                <c:if test="${requestScope.billTypeList!=null}">
                    <c:forEach items="${requestScope.billTypeList}" var="list">
                        <input type="radio" name="typeid" id="typeid" value="${list.id}"
                               <c:if test="${list.id==bills.typeid}">checked="checked"</c:if>>${list.name}</input>
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>标题</td>
            <td ><input name="title" type="text" id="title" value="${bills.title}"/>
                <input name="id" type="hidden" id="id" value="${bills.id}"/>
            </td>
        </tr>
        <tr>
            <td>日期</td>
            <td><input name="billtime" type="date" id="billtime" value="<fmt:formatDate value="${bills.billtime}" pattern="yyyy-MM-dd" ></fmt:formatDate>"/></td>
        </tr>
        <tr>
            <td>金额</td>
            <td><input name="price" type="text" id="price" value="${bills.price}"/></td>
        </tr>
        <tr>
            <td>说明</td>
            <td><input name="explains" type="text" id="explains" value="${bills.explains}"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" name="btn" id="btn" value="确认修改">
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>
