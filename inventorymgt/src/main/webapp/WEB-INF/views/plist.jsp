<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>All Phone</title>
</head>
<body>

<h1>Listing all Phone</h1>


<c:forEach items="${phone}"  var="phone">

Id is :<c:out value="${phone.getId()}"  />
<br>
name is :<c:out value="${phone.getName()}"  /><br>
Supplier is :<c:out value="${phone.getSupplier().getName()}"  /><br>
StorageMemory is :<c:out value="${phone.getStoragesize()}"  />

<br>
</c:forEach>

</body>
</html>