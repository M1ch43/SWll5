

<%@page import="com.ifsp.p2.classes.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="/menu.jsp"/> 
     
<%--
        <%
           Cliente cliente = (Cliente) request.getAttribute("cli");
           
        %>
--%>
<jsp:useBean id="cli" scope="request" class="com.ifsp.p2.classes.Cliente" />

        <form name="frmCadastro" action="ClienteServlet">
     
            <table border="0" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Cadastro de Clientes Edição</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Id</td>
                        <td> <input type="text" name="id" value="${cli.id}" size="10" /> </td>
                    </tr>
                    
                    <tr>
                        <td>Nome</td>
                        <td> <input type="text" name="nome" value="${cli.nome}" size="50" /> </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="${cli.email}" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Cpf</td>
                        <td><input type="text" name="cpf" value="${cli.cpf}" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Rg</td>
                        <td><input type="text" name="rg" value="${cli.rg}" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Idade</td>
                        <td><input type="number" name="idade" value="${cli.idade}" size="10" /></td>
                    </tr>
                    <tr>
                        <td>Logradouro</td>
                        <td><input type="text" name="logradouro" value="${cli.endereco.logradouro}" size="50" /></td>
                    </tr>
                    <tr>
                        <td>CEP</td>
                        <td><input type="text" name="cep" value="${cli.endereco.cep}" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Cidade</td>
                        <td><input type="text" name="cidade" value="${cli.endereco.cidade}" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Bairro</td>
                        <td><input type="text" name="bairro" value="${cli.endereco.bairro}" size="50" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Gravar" name="btnGravar" /> </td>
                        <td><input type="reset" value="Limpar" name="btnLimpar" /> </td>
                    </tr>
                    <input type="text" name="acao" value="edit" hidden="true">
                </tbody>
            </table>
        </form>
<jsp:include page="/footer.jsp"/> 
