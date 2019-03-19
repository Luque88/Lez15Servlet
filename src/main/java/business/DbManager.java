/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import models.Customer;
import business.DSManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named("db")
public class DbManager {
    
     public List<Customer> searchCustomer(String search) {

        try {
            Connection cn = DSManager.connection();
            List<Customer> result = new ArrayList<>();
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers "
                    + " where customerName like '" + search + "%' order by customerName")) {
                while (query.next()) {
                    result.add(new Customer(query.getInt("customerNumber"),
                            query.getString("customerName")));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }
}

    
    
    
    
   
        
       
          
    

