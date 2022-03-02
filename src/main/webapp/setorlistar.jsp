<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Setor </title>
<link href="css/styles.css" rel="stylesheet">
<body>

<header>
<div>
	<nav><h2><a href="index.jsp">Sistema Empresa</a></h2></nav>
	<h3> Usuário: ${cliente.nome} </h3>
</div>
</header>


<section class="container">
<c:forEach var="setor" items="${setores}">
	<p class="lista"> ${setor.id} ${setor.descricao} </p>

</c:forEach>
</section>

</body>
</html>


