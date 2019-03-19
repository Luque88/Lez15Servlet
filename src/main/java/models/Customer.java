/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tss
 */
public class Customer {
    private int id;
    private String name;
    
    public Customer(int id, String name){
        this.id=id;
        this.name =name;
    }
    
    public int getId(){
       return id;
        
    }
    
   public String getName(){
        return name;
    }

     public void setName(String name ){
         this.name=name;
                 
     }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
  
   
   }
   


    
   