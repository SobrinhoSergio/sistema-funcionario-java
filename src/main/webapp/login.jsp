<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body{
	background-color: black;
	font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
   	height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-image: linear-gradient(45deg, cyan, yellow);
}

p{
	font-size: 20px;
}

header{
	position: fixed;
	width: 100%;
	background-color: rgba(0,0,0,0.7);
	top: 0;
	color: #fff;
	
}

header div{
	padding: 20px 90px;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
}

header nav h2{
	color: #fff;
	font-size: 27px;
}

.container{
	background-color: #fff;
	border-radius: 8px;
	padding: 30px;
	text-align: center;

}

input[type='text']{
	height: 40px;
	width: 300px;
	border: 1px solid #f4f4f4;
	outline: none;
}

input[type='password']{
	height: 40px;
	width: 300px;
	border: 1px solid #f4f4f4;
	outline: none;
}


input[type='submit']{
	height: 40px;
	width: 100px;
	border: 1px solid #f4f4f4;
	outline: none;
	cursor: pointer;
	font-size: 20px;
}

input[type='submit']:hover{
	background-color: dodgerblue;
	color: #fff;
}

.senha{
	margin: 20px 0;
}

</style>

</head>
<body>

<header>
<div>
	<nav><h2>Sistema Empresa</h2></nav>
	<h3> Logar-se </h3>
</div>
</header>

<section class="container">
<form action="/sisfuncionario/ServletCliente" method="post">
<div>
	<p>Login</p> <input type="text" name="login"> 
</div>
<div class="senha">
	<p>Senha </p><input type="password" name="pass"> 
</div>
	<input type="hidden" name="acao" value="logar"> 
	<input type="submit">
</form>
</section>
<p> ${erro}
</body>
</html>