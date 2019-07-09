<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width:980px; margin:0px auto; text-align:center">
    <div style="text-align:center">
        <h3>图书借阅系统</h3>
    </div>
    <div style="text-align:center">
        <form id="searchForm" action="${pageContext.request.contextPath}/index" method="post">
            图书分类:
            <select name="booktype" id="booktype">
                <option value="-1">--请选择--</option>
                <c:if test="${requestScope.nameList!=null}">
                     <c:forEach items="${requestScope.nameList}" var="list">
                          <option value="${list.id}" <c:if test="${list.id==bookParam.booktype}">selected="selected"</c:if>>--${list.name}--</option>
                    </c:forEach>
                </c:if>
            </select>&nbsp;&nbsp;
            图书名称：
            <input name="bookname" type="text" id="bookname" size="10" value="${bookParam.bookname}"/>
            是否借阅
            <select name="isborrow" id="isborrow">
                <option value="-1">--请选择--</option>
                <option value="1" <c:if test="${bookParam.isborrow==1}">selected="selected"</c:if> >--已借阅--</option>
                <option value="2" <c:if test="${bookParam.isborrow==2}">selected="selected"</c:if>>--未借阅--</option>
            </select>&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;
            <input type="hidden" name="pageIndex" id="pageIndex" value="1" />
            <input type="submit" name="btnQuery" id="btnQuery" value="查询" />
            <input type="button" value="添加" onclick='location.href="${pageContext.request.contextPath}/add"'/>
        </form>
    </div>
    <div>
        当前用户：${sessionScope.usercode}
        <a href="javascript:do_delete()">退出</a>
    </div>
    <table width="980" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>图书编号</td>
            <td>图书分类</td>
            <td>图书名称</td>
            <td>作者</td>
            <td>出版社</td>
            <td>操作</td>
        </tr>
        <c:if test="${requestScope.bookPage.list!=null}">
            <c:forEach items="${requestScope.bookPage.list}" var="bookPage">
                <tr>
                    <td>${bookPage.bookcode}</td>
                    <td>${bookPage.name.name}</td>
                    <td>${bookPage.bookname}</td>
                    <td>${bookPage.atuthor.aname}</td>
                    <td>${bookPage.publishpress}</td>
                    <td>
                        <c:if test="${bookPage.isborrow==2}">
                            <a href="${pageContext.request.contextPath}/update/${bills.id}">申请借阅</a>
                        </c:if>
                        <c:if test="${bookPage.isborrow==1}">
                            已借阅&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/update/${bills.id}">修改信息</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>



        <tr>
            <td colspan="10" align="center" valign="middle">
                <a href="javascript:do_page(1)">首页</a>
                <a href="javascript:do_page(${requestScope.bookPage.pageNum-1})">上一页</a>
                <a href="javascript:do_page(${requestScope.bookPage.pageNum+1})">下一页</a>
                <a href="javascript:do_page(${requestScope.bookPage.pages})">尾页</a>
                ${requestScope.bookPage.pageNum}/${requestScope.bookPage.pages}页
            </td>
        </tr>
    </table>

</div>
</body>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="application/javascript">
    function do_page(pno) {
        $("#pageIndex").val(pno);
        $("#searchForm").submit();
    }
    function do_delete(){
        if(confirm("确认退出吗？")){
            location.href = "about:blank";
        }
    }
</script>

</html>

