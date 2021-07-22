/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class ClienteDAO {

    List<Cliente> lista = new ArrayList<Cliente>();
    
    private Connection cn ;
    
    public ClienteDAO() throws ClassNotFoundException{
        cn=new FabricaConexao().getConnection();
    }
    
    public String Incluir(Cliente cli) throws SQLException{
        String retorno="OK";
        String sql="insert into cliente (nome,email,cpf,rg,idade,logradouro,cep,cidade,bairro)" +
                "values (?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement pr=cn.prepareStatement(sql);
            
            pr.setString(1,cli.getNome());
            pr.setString(2,cli.getEmail());
            pr.setString(3,cli.getCpf());
            pr.setString(4,cli.getRg());
            pr.setString(5,String.valueOf(cli.getIdade()));
            pr.setString(6,cli.getEndereco().getLogradouro());
            pr.setString(7,cli.getEndereco().getCep());
            pr.setString(8,cli.getEndereco().getCidade());
            pr.setString(9,cli.getEndereco().getBairro());
            
            pr.execute();
            //cn.close();
            
        }catch (SQLException ex){
            retorno="ERRO";
            throw new RuntimeException(ex);
        }
        
        return retorno;
    }
    
 
    public String Alterar(Cliente cli) throws SQLException
    {
        String retorno = "OK";
        String sql="update cliente set nome=?,email=?,cpf=?," +
                "rg=?,idade=?,logradouro=?,cep=?,cidade=?,"+
                "bairro=? where id=?";
                 
  
        try{
            PreparedStatement pr=cn.prepareStatement(sql);
            
            pr.setString(1,cli.getNome());
            pr.setString(2,cli.getEmail());
            pr.setString(3,cli.getCpf());
            pr.setString(4,cli.getRg());
            pr.setString(5,String.valueOf(cli.getIdade()));
            pr.setString(6,cli.getEndereco().getLogradouro());
            pr.setString(7,cli.getEndereco().getCep());
            pr.setString(8,cli.getEndereco().getCidade());
            pr.setString(9,cli.getEndereco().getBairro());
            pr.setString(10, String.valueOf(cli.getId()));
            
            pr.execute();
            //cn.close();
            
        }catch (SQLException ex){
            retorno="ERRO";
            throw new RuntimeException(ex);
        }
                
        
        
        return retorno;
    }
     
    public String Excluir(int id) throws SQLException
    {
        String retorno = "OK";
        String sql="delete from cliente where id=?";
              
  
        try{
            PreparedStatement pr=cn.prepareStatement(sql);            
            pr.setString(1, String.valueOf(id)); 
            pr.execute();
            //cn.close();
            
        }catch (SQLException ex){
            retorno="ERRO";
            throw new RuntimeException(ex);
        }
                
        
        
        return retorno;
    }
    
    public Cliente GetById(String id) throws SQLException
    {      
        Cliente cli = new Cliente();
        ResultSet retorno;
        try{
            String sql = "Select * from cliente where id=?;";
            
            PreparedStatement smt=cn.prepareStatement(sql);
            smt.setString(1, id);
          
            
            retorno=smt.executeQuery();
            
            while (retorno.next()){
                cli=new Cliente();
                cli.setEndereco(new Endereco());
                cli.getEndereco().setBairro(retorno.getString("bairro").toString());
                cli.getEndereco().setCep(retorno.getString("cep").toString());
                cli.getEndereco().setCidade(retorno.getString("cidade").toString());
                cli.getEndereco().setLogradouro(retorno.getString("logradouro"));
                cli.setCpf(retorno.getString("cpf").toString());
                cli.setEmail(retorno.getString("email").toString()); 
                cli.setNome(retorno.getString("nome").toString());  
                cli.setRg(retorno.getString("rg").toString());
                cli.setIdade(retorno.getInt("idade"));
                cli.setId(Integer.parseInt(retorno.getString("id").toString()));
                     
            }
        }catch (SQLException ex){
            throw ex;
        }
        
        
        return cli;
    }
        
    public List<Cliente> getAll() throws SQLException{        
        Cliente cli;
        List<Cliente> li=new ArrayList<Cliente>();
        ResultSet retorno;
        try{
            String sql = "Select * from cliente;";
            PreparedStatement smt=cn.prepareStatement(sql);
            
            retorno=smt.executeQuery();
            
            while (retorno.next()){
                cli=new Cliente();
                cli.setEndereco(new Endereco());
                cli.getEndereco().setBairro(retorno.getString("bairro").toString());
                cli.getEndereco().setCep(retorno.getString("cep").toString());
                cli.getEndereco().setCidade(retorno.getString("cidade").toString());
                cli.getEndereco().setLogradouro(retorno.getString("logradouro"));
                cli.setCpf(retorno.getString("cpf").toString());
                cli.setEmail(retorno.getString("email").toString()); 
                cli.setNome(retorno.getString("nome").toString());  
                cli.setRg(retorno.getString("rg").toString());
                cli.setIdade(retorno.getInt("idade"));
                cli.setId(Integer.parseInt(retorno.getString("id").toString()));
                li.add(cli);               
            
            }
            
            
            
        }
        catch (SQLException ex){
        
            throw new RuntimeException(ex);
        }
                
        return li;
    }
    
    
}
