/*
 * This is a Desktop Application for an online book store
 * 
 * 
 */
package amazonbooksapp;

import java.sql.*;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Akomere Peter Akpoveso 20152086
 * 
 */
public class AmazonBooksDB {
    

/**
 *
 * @author Akomere Peter Akpoveso 20152086
 */

    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";
    
    //private int ordID = 1000;
    
    private int costID = 1;
    
    private int bookID = 10;
    
    //private int bookdet_ID = 100;

  
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void createCustomerTable() {
        
        int result;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "CREATE TABLE CUSTOMERID20152086(ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                + "NAME VARCHAR(30),"
                + "EMAIL VARCHAR(30))";
          
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count from create = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }

    }
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void createBookTable() {
        
        int result;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "CREATE TABLE BOOKID20152086(BOOKID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), BOOKNAME VARCHAR(30), PRICE REAL)";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count from create = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }

    }
    
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void createBookDetTable() {
        
        int result;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "CREATE TABLE BOOKDET20152086(BOOKDETID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), PUBLISHER VARCHAR(30), PUBDT DATE, BOOKDETAILID INTEGER, FOREIGN KEY(BOOKDETAILID) REFERENCES BOOKID20152086(BOOKID))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count from create = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }

    }
   
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void createOrderTable() {
        
        int result;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "CREATE TABLE ORDER20152086(ORDERID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1), CUSTOMERID INTEGER,"
                + " BOOKID INTEGER, STATUS VARCHAR(30),"
                + "FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERID20152086(ID), FOREIGN KEY (BOOKID)"
                + "REFERENCES BOOKID20152086(BOOKID))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count from create = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }

    }
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void addRowCustomer(String name, String email) {
        
        
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "INSERT INTO CUSTOMERID20152086(NAME, EMAIL) VALUES (?,?) ";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            // set parameter value (note: indicies start with 1)
            //stmt.setInt(1,id );
            stmt.setString(1,name);
            stmt.setString(2,email);
            
           
            if(stmt.executeUpdate() == 1){
                //costID++;
          
            }

            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
    }
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void addRowBook(String name, double price) {
        
        
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        
        
        String sql = "INSERT INTO BOOKID20152086(BOOKNAME, PRICE) VALUES (?,?) ";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            // set parameter value (note: indicies start with 1)
            //stmt.setInt(1,id );
            
             
            
            stmt.setString(1,name);
            stmt.setDouble(2,price);
             //stmt.setInt(3,bookdet_ID++);
            
            
           
            if(stmt.executeUpdate() == 1){
                //bookID++;
       
            }

            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
    }
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void addRowBookDet (String pubname, String sqldt) {
        
        
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        
        
        
        String sql = "INSERT INTO BOOKDET20152086(PUBLISHER, PUBDT, BOOKDETAILID) VALUES (?,?,?)";
        // use try with resource
        try(Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement stmt = connect.prepareStatement(sql);
            ){

            // set parameter value (note: indicies start with 1)
            
            
                
           try { // second try to detect failure of transaction
                 
              
              stmt.setString(1,pubname);
              stmt.setDate(2,Date.valueOf(sqldt));
              stmt.setInt(3,bookID);
            
           
            if(stmt.executeUpdate() == 1){
                bookID++;
            } 

                // execute first statement
                

            } catch (IllegalArgumentException iae) {
               
                String mess;
                mess = iae.getMessage();
                JOptionPane.showMessageDialog(null,"wrong type for number or date format:" + mess);
                connect.rollback();
                JOptionPane.showMessageDialog(null, "Rollback: row adding failed");
                bookID--;
            }
        }
       
         catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());
            }
        }
            
    
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void addRowOrderTable(String status) {
        
        
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "INSERT INTO ORDER20152086(CUSTOMERID, BOOKID, STATUS) VALUES(?,?,?)";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            
            
            stmt.setInt(1,costID);
            stmt.setInt(2,bookID);
            stmt.setString(3,status);
            //stmt.setDate(4,Date.valueOf(dt));
           
            if(stmt.executeUpdate() == 1){
                costID++;
                bookID++;
                //ordID++;
            }

            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
    }
    

    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */ 
    public void QuaryOne2OneTable() {
            
        ResultSet result;
            
        String data = "";
        JOptionPane.showMessageDialog(null, "Quarying one to on");   
        //String sql = "CREATE TABLE CUSTOMERID20152086(ID INTEGER PRIMARY KEY, NAME VARCHAR(30))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {
            result = stmt.executeQuery("SELECT * FROM BOOKID20152086 INNER JOIN BOOKDET20152086 "
                    + "ON BOOKID = BOOKDETAILID");
            
            while(result.next()){
                data += "\nBook ID: " + result.getInt(1) + "||book name: " + result.getString(2)+ "||book details id: "
                        + result.getInt(3) + "||Publisher: "+ result.getString(4) ;   
            }
            JOptionPane.showMessageDialog(null, data);
        }catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
 
    }

   /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */ 
    public void QuaryOne2ManyTable() {
            
        ResultSet result;
            
        String data = "";
            
        //String sql = "CREATE TABLE CUSTOMERID20152086(ID INTEGER PRIMARY KEY, NAME VARCHAR(30))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {
            result = stmt.executeQuery("SELECT * FROM ORDER20152086 INNER JOIN CUSTOMERID20152086 ON CUSTOMERID = ID");
            
            while(result.next()){
                data += "\nCostumerID: " + result.getInt(1) + "||name: " + result.getString(2)+ "||Order id: " + result.getInt(3) ;   
            }
            JOptionPane.showMessageDialog(null, data);
        }catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
 
    }
    
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void QuaryMany2ManyTable() {
            
            ResultSet result;
            
            String data = "";
            
        //String sql = "CREATE TABLE CUSTOMERID20152086(ID INTEGER PRIMARY KEY, NAME VARCHAR(30))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {
            result = stmt.executeQuery("SELECT * FROM ORDER20152086 INNER JOIN CUSTOMERID20152086 ON ORDER20152086.CUSTOMERID = CUSTOMERID20152086.ID INNER JOIN BOOKID20152086 ON ORDER20152086.BOOKID = BOOKID20152086.BOOKID");
            
            while(result.next()){
                data += "\nID: " + result.getInt(1) + "||name: " + result.getString(2)+ "||book id: "
                        + result.getInt(3) + "||book name: "+ result.getString(4) ;   
            }
            JOptionPane.showMessageDialog(null, data);
        }catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
 
    }
    
    
    
    //declare that this will throw illigal date format exception
    public void AddOne2OneTable(String book, Double price, String publisher, String dt) {
        
        addRowBook(book, price);
        
        addRowBookDet(publisher, dt);
   }
    
    public void AddOne2ManyTable(String costu_name, String cost_email, String st) {
        
        addRowCustomer(costu_name, cost_email);
        
        addRowOrderTable(st);

    }
    
    public void AddMany2ManyTable(String cost_name, String cost_email, String bookname, double price, String stat) {
        
        addRowCustomer(cost_name, cost_email);
        addRowBook(bookname, price);
        bookID--;
        
        addRowOrderTable(stat);
    
    }
    
     /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void AddMultipleRowsToTables(){
        
        addRowCustomer("Akomere Akpoveso", "akomere.akpox@gmail.com");
        addRowBook("How to be a rich man", 50);
        addRowBookDet("Harvard Business School", "2009-09-08");
        bookID--;
        addRowOrderTable("Y");
       
        
        addRowCustomer("Jesse Akume", "jesse.akum@gmail.com");
        addRowBook("Adastra: A new world", 59);
        addRowBookDet("Allan and Grants", "2019-08-08");
        bookID--;
        addRowOrderTable("N");
        
        
        
        addRowCustomer("Vahida Shafik", "vahid.shaf@gmail.com");
        addRowBook("The Great ShOwman", 22);
        addRowBookDet("Princeton", "2000-07-08");
        bookID--;
        addRowOrderTable("Y");
        
        
        addRowCustomer("Arnold Cave", "arnold.cave@gmail.com");
        addRowBook("Small Steps, Big Goals", 12);
        addRowBookDet("Cleveland Press", "1999-10-08");
        bookID--;
        addRowOrderTable("N");
        
        
        addRowCustomer("Park Stone", "park.stone@gmail.com");
        addRowBook("House of Cards", 10);
        addRowBookDet("Oakwoods Ltd.", "1999-08-08");
        bookID--;
        addRowOrderTable("Y");
        
        
        addRowCustomer("Alan Lam", "alan.lam@gmail.com");
        addRowBook("How to train a dragon", 5);
        addRowBookDet("Praggish Publishers", "2019-08-08");
        bookID--;
        addRowOrderTable("N");
  
    }
    
    public int InterruptOption(){
        
        int result = JOptionPane.showConfirmDialog(null,"If you wish to end the program say yes?",null, JOptionPane.YES_NO_OPTION);
        
        return result;     
    }
    
  
   
    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     
    public void AddMultipleRows2BooktTables(){
        
        //addRowBook("How to be a rich man", 50);
        
        //bookID++;
        
       
        
        //bookID++;
        
        
        //bookID++;
        
        
        
        
        
        //bookID++;
        
       
        //bookID++;
   
    }*/

    
    
    /**
     * @param args the command line arguments
     */
    
    public void TablesCheck(){

        /*String sql1= "DROP TABLE BOOKDET20152086";
        
        String sql2= "DROP TABLE ORDER20152086";
        
        String sql3= "DROP TABLE BOOKID20152086";
        
        String sql4= "DROP TABLE CUSTOMERID20152086";
        
        
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // disable auto commit
            //JOptionPane.showMessageDialog(null, "Start Transaction - disable auto commit");
            connect.setAutoCommit(false);
            try { // second try to detect failure of transaction*/

                // execute first statement
                //stmt.executeUpdate(sql1);
                // execute second statement
                //stmt.executeUpdate(sql2);
                
                //stmt.executeUpdate(sql3);
                
                //stmt.executeUpdate(sql4);
             
                // don't forget to commit or rollback
                // at this location, we have success: commit
                //connect.commit();

            //} catch (SQLException sqle) {
                // failure: rollback transaction
                
                /*String mezz = sqle.getMessage();
                JOptionPane.showMessageDialog(null,mezz );
                connect.rollback();

            } finally {
                // don't forget to enable auto commit after your transaction
                JOptionPane.showMessageDialog(null, "Ensuring Tables Availbility...");
                connect.setAutoCommit(true);*/
                
                createBookTable();
       
                createCustomerTable();
       
                createOrderTable();
                
                JOptionPane.showMessageDialog(null, "creating Det");
       
                createBookDetTable();
               
                JOptionPane.showMessageDialog(null, "Inserting multiple info");
                
                AddMultipleRowsToTables();
                JOptionPane.showMessageDialog(null, "Tables filled succesfully");
            
                //JOptionPane.showMessageDialog(null, "order tables succefull");
            
           /* }
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());

        }*/
    }
    
    public void clearTables(){

        String sql1= "DROP TABLE BOOKDET20152086";
        
        String sql2= "DROP TABLE ORDER20152086";
        
        String sql3= "DROP TABLE BOOKID20152086";
        
        String sql4= "DROP TABLE CUSTOMERID20152086";
        
        
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // disable auto commit
            //JOptionPane.showMessageDialog(null, "Start Transaction - disable auto commit");
            connect.setAutoCommit(false);
            try { // second try to detect failure of transaction

                // execute first statement
                stmt.executeUpdate(sql1);
                // execute second statement
                stmt.executeUpdate(sql2);
                
                stmt.executeUpdate(sql3);
                
                stmt.executeUpdate(sql4);
             
                // don't forget to commit or rollback
                // at this location, we have success: commit
                connect.commit();

            } catch (SQLException sqle) {
                // failure: rollback transaction
                
                String mezz = sqle.getMessage();
                JOptionPane.showMessageDialog(null,mezz );
                connect.rollback();

            } finally {
                // don't forget to enable auto commit after your transaction
                JOptionPane.showMessageDialog(null, "Tables cleared");
                connect.setAutoCommit(true);
            
            }
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());

        }
    }
    
    
    
}
    

