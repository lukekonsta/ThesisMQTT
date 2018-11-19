/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class GetDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
                // TODO code application logic here
        Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
        
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_database","root","");

            // 2. Create a statement
            myStmt = myConn.createStatement();
            
            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select Key_Value from table_one");
			
            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("Key_Value"));
            }            
                                  
            
        
        }catch(Exception exc){
            exc.printStackTrace();
        
        }
        // TODO code application logic here
    }
    
}
