<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h2>Expense Details</h2>
	<p><a href="/expenses">Go back</a></p>
	<p><b>Expense Name:</b> <c:out value="${gasto.getExpense_name() }" /></p>
	<p><b>Expense Description:</b> <c:out value="${gasto.getDescription() }" /></p>
	<p><b>Vendor:</b> <c:out value="${gasto.getVendor() }" /></p>
	<p><b>Amount Spent:</b> $<c:out value="${gasto.getAmount() }" /></p>
</body>
</html>