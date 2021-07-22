

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/menu.jsp"/> 


        
        <form name="frmCadastro" action="ClienteServlet">
     
            <table border="0" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Cadastro de Clientes</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nome</td>
                        <td> <input type="text" name="nome" value="" size="50" /> </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Cpf</td>
                        <td><input type="text" name="cpf" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Rg</td>
                        <td><input type="text" name="rg" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Idade</td>
                        <td><input type="number" name="idade" value="" size="10" /></td>
                    </tr>
                    <tr>
                        <td>Logradouro</td>
                        <td><input type="text" name="logradouro" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>CEP</td>
                        <td><input type="text" name="cep" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Cidade</td>
                        <td><input type="text" name="cidade" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Bairro</td>
                        <td><input type="text" name="bairro" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Gravar"/> </td>
                        <td><input type="reset" value="Limpar" name="btnLimpar" /> </td>
                    </tr>
                <input type="text" name="acao" value="new" hidden="true">
                </tbody>
            </table>
        </form>
<jsp:include page="/footer.jsp"/> 
