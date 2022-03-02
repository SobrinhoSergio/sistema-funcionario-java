<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresa</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>

<br>

<header>
<div>
	<nav><h2>Sistema Empresa</h2></nav>
	<h3> Usuário: ${cliente.nome} </h3>
</div>
</header>

<section class="container home">
	<a class="link" href="/sisfuncionario/frmsetor.html"> Registrar setor </a> <br>
	<a class="link" href="/sisfuncionario/ServletSetor?acao=listar&nextPage=/setorlistar.jsp"> Listar setor </a> <br>
	<a class="link" href="/sisfuncionario/ServletSetor?acao=listar&nextPage=/frmfuncionario.jsp"> Registrar funcionario </a> <br>
	<a class="link" href="/sisfuncionario/listarfuncionario.jsp"> Listar funcionario </a> <br>
</section>

</body>
</html>