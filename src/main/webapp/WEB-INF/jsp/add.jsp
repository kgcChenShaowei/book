<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post" enctype="multipart/form-data">
    <div align="center">添加</div>
    <table width="500" border="1" align="center">
        <tr>
            <td>图书编号</td>
            <td ><input name="bookcode" type="text" id="bookcode" />
                <input name="bookid" type="hidden" id="bookid" />
            </td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td ><input name="bookname" type="text" id="bookname" />
            </td>
        </tr>
        <tr>
            <td>图书类型</td>
            <td>
                <select name="booktype" id="booktype">
                    <option value="-1">--请选择--</option>
                    <c:if test="${requestScope.nameList!=null}">
                        <c:forEach items="${requestScope.nameList}" var="list">
                            <option value="${list.id}">${list.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>图书作者</td>
            <td >
                <select name="bookatuthor" id="bookatuthor">
                    <option value="-1">--请选择--</option>
                    <c:if test="${requestScope.atuthorList!=null}">
                        <c:forEach items="${requestScope.atuthorList}" var="list">
                            <option value="${list.aid}">${list.aname}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input name="publishpress" type="text" id="publishpress"/></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input name="publishdate" type="date" id="publishdate"/></td>
        </tr>
        <tr>
            <td>创建人</td>
            <td><input name="createdby" type="text" id="createdby"/>
                <input name="isborrow" type="hidden" id="isborrow" value="1"/></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input name="creationtime" type="date" id="creationtime"/></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input name="lastupdatetime" type="date" id="lastupdatetime"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" name="btn" id="btn" value="确认添加">
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>

