/*
 * This is a Web Application for an online book store
 * 
 * 
 */
package amazonbooksapp;

import java.sql.*;
//import java.sql.Date;
import javax.swing.JOptionPane;
//import amazonbooksapp.AmazonBooksDB;

/**
 *
 * @author User
 */
public class AmazonBooksApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    AmazonBooksDB amazon = new AmazonBooksDB();

    amazon.clearTables();
    
    amazon.TablesCheck();
    
    JOptionPane.showMessageDialog(null, "Alllllll Tables created sucessfully!!!!");
    
    
            
    
    
    
    amazon.QuaryOne2OneTable();
    
    amazon.QuaryOne2ManyTable();
    
    amazon.QuaryMany2ManyTable();
   
    boolean continueApp = true;
                
    while(continueApp){
            String choice = JOptionPane.showInputDialog("please select 1 to begin the program, 2-EXIT:");
            int i = Integer.parseInt(choice);
            
           
        switch(i){
            
            case 1: boolean gotInvalid = true;
                
                while(gotInvalid){
                  
                    try { 
                        JOptionPane.showMessageDialog(null,"this One to One quary adds data to the Books ID table and Books Details Table");
                
                        String bknm = JOptionPane.showInputDialog("please enter the books name: ");

                        String bkpr = JOptionPane.showInputDialog("please enter the books price: ");

                        String pubnm = JOptionPane.showInputDialog("please enter the book publisher name: ");


                        String pudt= JOptionPane.showInputDialog("please enter the book publish date(yyy-mm-dd): ");

                        Double bkprc = Double.parseDouble(bkpr);
                        
                        amazon.AddOne2OneTable(bknm, bkprc, pubnm, pudt);
                        
                        gotInvalid = false;  
             
            

                        } catch (NumberFormatException nfe) {

                                String mess;
                                mess = nfe.getMessage();
                                JOptionPane.showMessageDialog(null,"wrong type entered " + mess + " price, please use numbers not letters:" );

                            }
                }
                
                int resp1 = amazon.InterruptOption();
                if(resp1 == JOptionPane.NO_OPTION) {
                    break;
                }
                
                JOptionPane.showMessageDialog(null,"this One to many quary adds data to Customer ID table and Book Orders Table");
                    
                String costName = JOptionPane.showInputDialog("please enter the customer name: ");

                String mail = JOptionPane.showInputDialog("please enter the customer email: ");

                String state = JOptionPane.showInputDialog("please what is the order status:Delivered or Not Delivered: ");

                //int orderID = Integer.parseInt(order_id);

                amazon.AddOne2ManyTable(costName, mail, state);
                int resp2 = amazon.InterruptOption();
                if(resp2 == JOptionPane.NO_OPTION) {
                    break;
                }
                
                
                JOptionPane.showMessageDialog(null,"this One to One quary gets data from Books ID table and Books Details Table");
                    
                String bkname = JOptionPane.showInputDialog("please enter the book name: ");

                String email = JOptionPane.showInputDialog("please enter the customer email: ");

                String custom_name = JOptionPane.showInputDialog("please enter customer name: ");

                //String costumer_order_id = JOptionPane.showInputDialog("please enter customer order ID: ");

                String bookprice = JOptionPane.showInputDialog("please enter book price: ");

                String stats= JOptionPane.showInputDialog("please what is the order status:Delivered or Not Delivered?");


                //int orID = Integer.parseInt(costumer_order_id);
                double bkprice = Double.parseDouble(bookprice);

                amazon.AddMany2ManyTable(custom_name, email, bkname, bkprice, stats);
                int resp3 = amazon.InterruptOption();
                if(resp3 == JOptionPane.NO_OPTION) {
                    break;
                }
                
                
                JOptionPane.showMessageDialog(null,"this One to One quary gets data from Books ID table and Books Details Table");
                amazon.QuaryOne2OneTable();
                int resp4 = amazon.InterruptOption();
                if(resp4 == JOptionPane.NO_OPTION) {
                    break;
                }
                
                
                JOptionPane.showMessageDialog(null,"this One to Many quary gets data from Costumer ID table and Order Details Table");
                    
                amazon.QuaryOne2ManyTable();
                int resp5 = amazon.InterruptOption();
                if(resp5 == JOptionPane.NO_OPTION) {
                    break;
                }
                
                
                JOptionPane.showMessageDialog(null,"this Many to Many quary gets data from Books ID table and Customer ID Table");
                    
                amazon.QuaryMany2ManyTable();
                
                JOptionPane.showMessageDialog(null,"Database interrogation ended: ");
                
                    break;
                    
            case 2: continueApp = false;
                    break;
          
            default: JOptionPane.showMessageDialog(null,"wrong input: ");
                    break;
        
        }
        
        }
        
    JOptionPane.showMessageDialog(null,"Application ended");
    
    amazon.clearTables();
    
    
    
    System.exit(0);
   
    }
    
}
