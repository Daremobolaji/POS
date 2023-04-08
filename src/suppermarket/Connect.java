/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppermarket;

/**
 *
 * @author OYEBANJI
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.ClassNotFoundException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connect {
   
   
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

 

   
    public static Connection connected(){
    
    String user ="root";
     String pass ="";
     String url  ="jdbc:mysql://localhost:3306/supermarket";
   
     try{
 Connection   connection = DriverManager.getConnection(url,user,pass);
     
     return connection;
     }catch(Exception e){
     System.out.println(e);
     e.printStackTrace();
     return null;
     }
    
    
   
    
    }
    
    
}
