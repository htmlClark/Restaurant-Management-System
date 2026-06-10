package MainClasses;
import Database.DB_Connection;
import MainPlacementFrame.*;

public class mainClass {
    public static void main(String[] args) 
    {
        LoginPage prod = new LoginPage();
        prod.setVisible(true);
        
         DB_Connection.getConnection();
        
//        homePage HomePage = new homePage();
//        HomePage.setVisible(true);
}}
