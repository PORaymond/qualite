
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Olivier
 */
public class JDBC {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        //Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@//localhost:1521/qualite";

        Connection con;
        
            con = DriverManager.getConnection(url, "hr", "oracle");
            //   con.setAutoCommit(false);
       

        Statement stmt = con.createStatement();
        String query = "select employee_id,first_name,last_name,salary from employees";
        //         String query="select  * from student";
        System.out.println("query:" + query);
        ResultSet rs
                = stmt.executeQuery(query);
        // en utilisant les index
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "   " + rs.getString(2));
        }

        // en utilisant les noms de col
/*	      while(rs.next())
	      {
	      System.out.println(rs.getInt("ID")+ "   "   +rs.getString("NOM") );
	      }*/
        stmt.close();
        System.out.println("ok");

    }

}


