/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;


import  com.ifsp.p1.classes.FabricaConexao;
import java.sql.Connection;
import  com.ifsp.p1.classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class UsuarioDAO{
    private Connection cn;
    
    public UsuarioDAO() throws ClassNotFoundException{
       cn=new FabricaConexao().getConnection();
    }
    
    public void adicionar (Usuario usuario){
        String sql="insert into usuario " +
                "(nome,login,senha) " +
                "values (?,?,?)";
        
         try {
            // prepared statement para insert
            PreparedStatement stmt = cn.prepareStatement(sql);
            
            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getLogin());
            stmt.setString(3,usuario.getSenha());
 

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public void alterar (Usuario usuario){
        String sql="update usuario set nome=?,senha=?,login=? where id=?";
                       
         try {
            // prepared statement para insert
            PreparedStatement stmt = cn.prepareStatement(sql);
            
            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getSenha());
            stmt.setString(3,usuario.getLogin());
            stmt.setInt(4,usuario.getId());
 

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
            
    public Usuario getByLogin(String login)  throws SQLException{
    	Usuario item=null;
    	ResultSet results;
    	
    	try {
                String sql="Select * from usuario where login='" + login + "';";

                PreparedStatement stmt = cn.prepareStatement(sql);    					
                 results = stmt.executeQuery();

                 if (results.next())
                 {
                         item=new Usuario();
                         item.setId(Integer.parseInt(results.getObject("id").toString()));
                         item.setNome(results.getObject("nome").toString());
                         item.setLogin(results.getObject("login").toString());

                         if (results.getObject("senha")!=null){
                            item.setSenha(results.getObject("senha").toString());
                         }

                 }
    				
    					
    					 
    			
    		return item;
    		
    	}
    	catch(SQLException e) {
    		throw e;
    	}
    	}
    
    public List<Usuario> listar()  {
                    List<Usuario> lista =new ArrayList<Usuario>();
                    ResultSet results;            
        try {
            String sql="Select * from usuario;";

            PreparedStatement stmt = cn.prepareStatement(sql);    					
             results = stmt.executeQuery();

             while (results.next())
             {       Usuario item=new Usuario();
                     item.setId(Integer.parseInt(results.getObject("id").toString()));
                     item.setNome(results.getObject("nome").toString());
                     item.setLogin(results.getObject("login").toString());
                     if (results.getObject("senha")!=null){
                        item.setSenha(results.getObject("senha").toString());
                     }

                     lista.add(item);

             }

        return lista;

    }
    catch(SQLException e) {
            throw new RuntimeException(e);
    }
}
        
    private final List<Object[]> indexResults(ResultSet results)
            throws SQLException {
        Object[] values;
        String[] cols = null;
        ResultSetMetaData metadata = null;
        List<Object[]> items = null;
        int ncols = 0;
        
        /*
         * Vamos iterar pelos registros
         */
        while (results.next()) {
            
            /*
             * instancia a lista pela primeira vez, assim como
             * alocamos um array de objetos que vai armazenar as
             * colunas da lista.
             * os dados da estrutura da tabela é obtida através
             * dos metadados.
             */
            if (items == null) {
                items = new ArrayList();
                metadata = results.getMetaData();
                ncols = metadata.getColumnCount();
                cols = new String[ncols];
                for (int i = 1; i <= ncols; i++)
                    cols[i - 1] = metadata.getColumnName(i);
                items.add(cols);
            }
            
            /*
             * transferimos o conteúdo do ResultSet, linha a linha.
             */
            values = new Object[ncols];
            for (int i = 0; i < cols.length; i++)
                values[i] = results.getObject(i + 1);
            items.add(values);
        }
        
        return items;
    }

    public void excluir(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
