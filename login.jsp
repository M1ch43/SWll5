<%-- 
    Document   : login
    Created on : 23/03/2019, 13:48:09
    Author     : Elienai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            if (request.getAttribute("erro") !=null){
        %>
        <script type="text/javascript">alert("<%= request.getAttribute("erro") %>")</script>
        
        <%}%>
    </head>
    <body>
         
        <form name="frmLogin" action="Autenticacao" method="POST">
      
        
        <table border="0" align="center">
            <thead>
                <tr>
                    <th colspan="2">Autenticacao</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Login</td>
                    <td> <input type="text" name="login" value="" size="20" /> </td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td> <input type="password" name="senha" value="" size="20" /> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Entrar" name="btnLogin" /> </td>
                </tr>
            </tbody>
        </table>
            
  </form>
         
    </body>
</html>
