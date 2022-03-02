<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Funcionário </title>
<link href="css/styles.css" rel="stylesheet">
<body>

<header>
<div>
	<nav><h2><a href="index.jsp">Sistema Empresa</a></h2></nav>
	<h3> Usuário: ${cliente.nome} </h3>
</div>
</header>


<section class="container">
<c:forEach var="funcionario" items="${funcionarios}">
	<p class="lista"> ${funcionario.id} ${funcionario.nome} </p>

</c:forEach>
</section>

</body>
</html>


