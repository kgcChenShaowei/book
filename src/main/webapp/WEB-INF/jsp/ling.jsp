<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ling" method="post" enctype="multipart/form-data">
    <div align="center">图书借阅系统</div>
    <table width="500" border="0" align="center">
        <tr>
            <td>登陆账号</td>
            <td ><input name="usercode" type="text" id="usercode" />
            </td>
        </tr>
        <tr>
            <td>登陆密码</td>
            <td><input name="password" type="text" id="password"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" name="btn" id="btn" value="登陆">
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>

