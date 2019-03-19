/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import models.Customer;
import business.DbManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author tss
 */
 



@WebServlet("/customer-search")
public class CustomerSearch extends HttpServlet{
    
    
   
    @Inject
    DbManager manager;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         System.out.println("start ricerca clienti...");

        String search = req.getParameter("search");

        System.out.println("ricerca di: " + search);

        PrintWriter wr = resp.getWriter();
        
       
    
        List<Customer> customers = manager.searchCustomer(search);
        
        wr.println("<h1>Risultato ricerca</h1>");
        
        wr.println("<ul>");
        
        customers.forEach(c -> wr.println("<li>" + c.getName() + "</li>"));
        
        wr.println("</ul>");
        
    }

}
