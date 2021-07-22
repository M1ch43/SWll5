/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.servlet;

import com.ifsp.p1.classes.Cliente;
import com.ifsp.p1.classes.ClienteDAO;
import com.ifsp.p1.classes.ClienteDAOHB;
import com.ifsp.p1.classes.Endereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elienai
 */
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try{
            Cliente c=new Cliente();
            Endereco e =new Endereco();
            ClienteDAO da=new ClienteDAO();
            ClienteDAOHB hb = new ClienteDAOHB();
            List<Cliente> clientes =new ArrayList<Cliente>();
            String acao = request.getParameter("acao"); 

            if (!acao.equals("list") && !acao.equals("del"))
            {
                c.setNome(request.getParameter("nome"));
                c.setEmail(request.getParameter("email"));
                c.setIdade(Integer.parseInt(request.getParameter("idade")));
                c.setCpf(request.getParameter("cpf"));
                c.setRg(request.getParameter("rg"));

                c.setLogradouro(request.getParameter("logradouro"));
                c.setCidade(request.getParameter("cidade"));
                c.setBairro(request.getParameter("bairro"));
                c.setCep(request.getParameter("cep"));


            //    c.setEndereco(e); 

                if (acao.equals("new")){
                    //da.Incluir(c);
                    hb.adicionar(c);
                }else if (acao.equals("edit")){
                    c.setId(Integer.parseInt(request.getParameter("id")));
                    //da.Alterar(c);
                    hb.alterar(c);
                }

                //clientes=da.getAll();
                clientes=hb.listar();
                
                request.setAttribute("clientes", clientes);
                request.getRequestDispatcher("listar_clientes.jsp").forward(request, response);                
            }else{
                if (acao.equals("list")){
                    Cliente cli=new Cliente();
                    cli =da.GetById(request.getParameter("id"));               
                    request.setAttribute("cli", cli);
                    request.getRequestDispatcher("editar_cliente.jsp").forward(request, response);                
                }else{
                    da.Excluir(Integer.parseInt(request.getParameter("id")));
                    clientes=da.getAll();
                    request.setAttribute("clientes", clientes);
                    request.getRequestDispatcher("listar_clientes.jsp").forward(request, response);                      
                    
                }
            }
                            

            
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
