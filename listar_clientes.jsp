<%-- 
    Document   : listar_clientes
    Created on : 28/09/2019, 13:21:31
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ifsp.p1.classes.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:include page="/menu.jsp"/> 

<%--
<%
    List<Cliente> lista =(ArrayList<Cliente>) request.getAttribute("clientes");
%>
--%>
<jsp:useBean id="a" scope="request" class="com.ifsp.p1.classes.Cliente"/>



<table border="1" align="center" style="border-collapse: collapse; margin-top: 25px;" 
       cellpadding="5px" 
       >
    
    <tr>
        <td>Id</td>
        <td>Nome</td>
        <td>Email</td>
        <td>Cpf</td>
        <td>Rg</td>
        <td>Idade</td>
        <td>Logradouro</td>
        <td>Cidade</td>
        <td>Cep</td>
        <td>Bairro</td>   
        <td>Editar</td>
        <td>Excluir</td>
            
    </tr>
    
    <c:forEach  items="${clientes}" var="a">
    <tr>
        <td>${a.id}</td>
        <td>${a.nome}</td>
        <td>${a.email}</td>
        <td>${a.cpf}</td>
        <td>${a.rg}</td>
        <td>${a.idade}</td>
        <td>${a.endereco.logradouro}</td>
        <td>${a.endereco.cidade}/td>
        <td>${a.endereco.cep}</td>
        <td>${a.endereco.bairro}</td> 
        <td>
            <a href="ClienteServlet?id=${c.id}&acao=list">Editar</a>
        </td>
        <td>
            <a href="ClienteServlet?id=${c.id}&acao=del">Excluir</a>
        </td>        
    </tr>
    
  </c:forEach>
    
</table>

<jsp:include page="/footer.jsp"/> 

