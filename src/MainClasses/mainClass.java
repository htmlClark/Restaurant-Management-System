package MainClasses;
import Database.DB_Connection;

public class mainClass {
    public static void main(String[] args) 
    {
        //checking db connection
         DB_Connection.getConnection();
        
        homePage HomePage = new homePage();
        HomePage.setVisible(true);
}}
