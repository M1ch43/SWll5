

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<style>
#menu ul {
width: 100%;
height: auto;
padding: 10px;
margin: 0;
background-color: #069;
list-style: none; 

}
#menu ul li {
display: inline; 

}
#menu ul li a {
padding: 2px 10px;
display: inline-block;
margin-left: 15px;
background-color: #069;
color: #fff;
text-decoration: none; 


border-bottom: 3px solid #069;
}
#menu ul li a:hover { 

color: #f5f5f5;
border-bottom: 3px solid #f5f5f5;
}
</style>

<nav id="menu">
<ul>
<li> <a href="cadastro.jsp">Cadastro</a></li>
<li> <a href="deposito.jsp">Depositar</a></li>
<li> <a href="saque.jsp">Sacar</a></li>
</ul>
</nav>
	

