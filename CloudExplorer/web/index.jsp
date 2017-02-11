<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CloudExporer</title>
</head>
<body>
<br>
<c:forEach items="${list}" var="item">
    <a href='/dirview?path=<c:out value="${item}"/>'>${item}</a><br>
</c:forEach>
<c:forEach items="${text}" var="str">
    <c:out value="${str}"/><br>
</c:forEach>
<form action="/filecreate">
    <input type="submit" name="create" value="Create New File">
    <input type="text" name="path" size="50">
</form>
<form action="/fileremove">
    <input type="submit" name="create" value="Remove File">
    <input type="text" name="path" size="50">
</form>
</br>
</body>
</html>