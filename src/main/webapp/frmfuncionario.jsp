<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Funcionário</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>

<header>
<div>
	<nav><h2><a href="index.jsp">Sistema Empresa</a></h2></nav>
	<h3> Usuário: ${cliente.nome} </h3>
</div>
</header>


<section class="container form-funcionario">
<form action="/sisfuncionario/ServletFuncionario">
<div class="nome">
	<p>Nome: </p>
	<input type="text" name="nome">
</div>

<div class="prof">
	<p>Profissão: </p>
	<input type="text" name="profissao"> 
</div>

<select name="idSetor">
<c:forEach var="setor" items="${setores}">
	<option value=${setor.id}> ${setor.descricao} </option>
</c:forEach>
</select>
<input type="hidden" name="acao" value="add"> 
<input type="submit">
</form>
</section>

</body>
</html>