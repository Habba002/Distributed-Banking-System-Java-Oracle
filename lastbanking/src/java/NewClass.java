
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashen
 */
public class NewClass {
    public static void main(String[] args) {
        
        int emp=1;
        int amount=100;
        String query = "INSERT INTO transfer(s_branch, s_firstname, s_middlename, s_lastname, "
                + "s_address, amount, amount2, date, r_firstname, r_middlename, r_lastname, "
                + "r_address, r_phone, r_branch, emp_id,status) VALUES ('" + "s_branch"+ "',"
                + "'" + "s_firstname" + "','" + "s_middlename" + "','" + "s_lastname" + "'"
                + ",'" + "s_address "+ "'," +amount + ",'" + "amount2" + "','" + "date" + "'"
                + ",'" + "r_firstname" + "','" + "r_middlename" + "','" + "r_lastname" + "',"
                + "'" + "r_address" + "','" + "r_phone" + "','" + "r_branch" + "',"+emp+",1)";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://DESKTOP-DJBRCV9\\BANK3;databaseName=bank";
            Connection con = DriverManager.getConnection(URL, "sa", "147369");
            Statement st = con.createStatement();
            st.execute(query);
            String q="select * from transfer order by id desc ";
            ResultSet Rs= st.executeQuery(q);
            Rs.next();
          int  bool = Rs.getInt("id");
            System.out.println(bool);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
   
}
