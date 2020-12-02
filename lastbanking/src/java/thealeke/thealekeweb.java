/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thealeke;

import entity.Account;
import entity.Address;
import entity.Employee;
import entity.News;
import entity.Transaction;
import entity.Transfer;
import entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import oracle.sql.JAVA_STRUCT;
import oracle.sql.STRUCT;

/**
 *
 * @author ashen
 */
@WebService(serviceName = "thealekeweb")
@Stateless()
public class thealekeweb {
    
    private Connection getConnection() throws Exception{
        // register JDBC driver, optional since java 1.6
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1522:bank", "system", "123");
            return conn;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "check")
    public Account check(@WebParam(name = "accnum") int accnum) {
        Account ac = null;
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from account where account_no = " + accnum);
            if(rs.next()){
                ac = new Account();
                ac.setAccount_no(rs.getInt(1));
                oracle.sql.STRUCT user = (oracle.sql.STRUCT) rs.getObject(2);
                ac.setUserinfo((User) user.toClass(User.class));

                oracle.sql.STRUCT address = (oracle.sql.STRUCT) rs.getObject(3);
                ac.setAddressinfo((Address) address.toClass(Address.class));
                
                ac.setAccount_type(rs.getString(4));
                ac.setBalance(rs.getDouble(5));
                ac.setEmpid(rs.getInt(6));
                ac.setDates(rs.getString(7));
                ac.setStatus(rs.getInt(8));
            }
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ac;
    }
    
    @WebMethod(operationName = "check_acc")
    public Account check_acc(@WebParam(name = "username") String username, @WebParam(name = "password") String password){
        Account ac = null;
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            String query = "select * from login_info where username='" + username + "' and password='" + password + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                int accnum = Integer.parseInt(rs.getString("account_no")); 
                
                con = getConnection();
                st = con.createStatement();

                rs = st.executeQuery("select * from account where account_no = " + accnum);
                if(rs.next()){
                    ac = new Account();
                    ac.setAccount_no(1);
                    oracle.sql.STRUCT user = (oracle.sql.STRUCT) rs.getObject(2);
                    ac.setUserinfo((User) user.toClass(User.class));

                    oracle.sql.STRUCT address = (oracle.sql.STRUCT) rs.getObject(3);
                    ac.setAddressinfo((Address) address.toClass(Address.class));

                    ac.setAccount_type(rs.getString(4));
                    ac.setBalance(rs.getDouble(5));
                    ac.setEmpid(rs.getInt(6));
                    ac.setDates(rs.getString(7));
                    ac.setStatus(rs.getInt(8));
                }
                st.close();
                con.close();
                rs.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ac;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "transaction1")
    public ArrayList<Transaction> transaction1(@WebParam(name = "role1") String role1, @WebParam(name = "id1") int id1, @WebParam(name = "accnum1") int accnum1) {
        ArrayList<Transaction> array = null;
        try {

            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs0, rs, rs1;

            Transaction trans = new Transaction();
            if (role1.equals("admin") || role1.equals("teller"))//if the role is either teller or admin
            {
                array = new ArrayList<Transaction>();
            } else if (role1.equals("client"))//if the transaction is made by client
            {
                array = new ArrayList<Transaction>();//creating arraylist to save any transaction related to this account or id

                rs = st.executeQuery("SELECT * FROM transaction WHERE accnum=" + accnum1);
                while (rs.next()) {

                    trans.setAccnum(accnum1);
                    trans.setType(rs.getString("type"));
                    trans.setExecutedby(rs.getString("executedby"));
                    trans.setAmount(rs.getInt("amount"));
                    trans.setDate(rs.getString("date"));
                    rs1 = st.executeQuery("select firstname,middlename from account where account_no=" + accnum1);
                    rs1.next();
                    trans.setName(rs1.getString("firstname") + " " + rs1.getString("middlename"));
                    array.add(trans);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Addnews")
    public boolean Addnews(@WebParam(name = "news") String news, @WebParam(name = "image") String image) {

        boolean bool = false;

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            String date1 = (new Date()) + "";
            String query = "insert into news(date,news,image,status) VALUES('" + date1 + "','" + news + "','" + image + "',1)";

            ts.execute(query);
            bool = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return bool;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Viewnews")
    public ArrayList<News> Viewnews() {
        ArrayList<News> news = new ArrayList();

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from news where Status=1 order by id desc");
            int i = 0;
            while (rs.next()) {
                News nw = new News();
                nw.setText(rs.getString("news"));
                nw.setImage(rs.getString("image"));
                nw.setDate(rs.getString("date"));
                news.add(i, nw);
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return news;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        String bool = null;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String user = username, pass = password;
            String query = "select * from login_info where username='" + user + "' and password='" + pass + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                bool = rs.getString("role")+"-"+rs.getString("account_no"); // getting the id from login table it is primary key
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_accounts")
    public ArrayList<Account> get_accounts() {
        ArrayList<Account> acount = new ArrayList();

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs= ts.executeQuery("SELECT * FROM account");
            while (rs.next()) {
                Account ac = new Account();
                ac.setAccount_no(rs.getInt(1));
                oracle.sql.STRUCT user = (oracle.sql.STRUCT) rs.getObject(2);
                ac.setUserinfo((User) user.toClass(User.class));

                oracle.sql.STRUCT address = (oracle.sql.STRUCT) rs.getObject(3);
                ac.setAddressinfo((Address) address.toClass(Address.class));
                
                ac.setAccount_type(rs.getString(4));
                ac.setBalance(rs.getDouble(5));
                ac.setEmpid(rs.getInt(6));
                ac.setDates(rs.getString(7));
                ac.setStatus(rs.getInt(8));
                acount.add(ac);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return acount;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAccount")
    public Account updateAccount(@WebParam(name = "a") Account a) {
        try {
            Connection con = getConnection();
            STRUCT struct = STRUCT.toSTRUCT(a, null);
            String empid = "3";
            String query = "UPDATE account SET info = ?  WHERE ac.account_no = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(2, a.getAccount_no());
            ps.setObject(1, a);
            ps.executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check(a.getAccount_no());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "activate")
    public boolean activate(@WebParam(name = "accnum") int accnum) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE account SET status=1 where account_no=" + accnum;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deactivate")
    public boolean deactivate(@WebParam(name = "accnum") int accnum) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE account SET status=0 where account_no=" + accnum;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkTransfer")
    public Transfer checkTransfer(@WebParam(name = "id") int id) {

        Transfer tra = new Transfer();
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from all_transaction where id = " + id);
            rs.next();            
            tra.setId(rs.getInt(1));
                tra.setAmount(rs.getInt(7));
                tra.setAmount2(rs.getString(8));
                tra.setDate(rs.getString(9));

                tra.setS_firstname(rs.getString(3));
                tra.setS_middlename(rs.getString(4));
                tra.setS_lastname(rs.getString(5));
                tra.setS_branch(rs.getString(2));
                tra.setS_address(rs.getString(6));

                tra.setR_address(rs.getString(10));
                tra.setR_firstname(rs.getString(11));
                tra.setR_middlename(rs.getString(12));
                tra.setR_lastname(rs.getString(13));
                tra.setR_phone(rs.getString(14));
                tra.setR_branch(rs.getString(15));

                tra.setEmp_id(rs.getInt(16));
                tra.setStatus(rs.getInt(17));
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tra;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_transfers")
    public ArrayList<Transfer> get_transfers() {
        ArrayList<Transfer> tarray = new ArrayList();
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from all_transaction order by id");
            while (rs.next()) {
                Transfer tra = new Transfer();
                tra.setId(rs.getInt(1));
                tra.setAmount(rs.getInt(7));
                tra.setAmount2(rs.getString(8));
                tra.setDate(rs.getString(9));

                tra.setS_firstname(rs.getString(3));
                tra.setS_middlename(rs.getString(4));
                tra.setS_lastname(rs.getString(5));
                tra.setS_branch(rs.getString(2));
                tra.setS_address(rs.getString(6));

                tra.setR_address(rs.getString(10));
                tra.setR_firstname(rs.getString(11));
                tra.setR_middlename(rs.getString(12));
                tra.setR_lastname(rs.getString(13));
                tra.setR_phone(rs.getString(14));
                tra.setR_branch(rs.getString(15));

                tra.setEmp_id(rs.getInt(16));
                tra.setStatus(rs.getInt(17));
                tarray.add(tra);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tarray;
    }

    /**
     * Web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "GrantTranfer")
    public boolean GrantTranfer(@WebParam(name = "id") int id, @WebParam(name = "emp_id") String emp_id) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            String query3 = "call transferconfirm(?,?,?)";
            CallableStatement call = con.prepareCall(query3);
            call.setInt(1, id);
            call.setInt(2, Integer.parseInt(emp_id));
            call.setString(3, new Date().toString());
            call.execute();
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkEmployee")
    public Employee checkEmployee(@WebParam(name = "id") int id) {
        Employee tr = null;
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from employee where id=" + id);
            rs.next();
            tr = new Employee();
            tr.setId(rs.getInt(1));
            oracle.sql.STRUCT user = (oracle.sql.STRUCT) rs.getObject(2);
            tr.setUserinfo((User) user.toClass(User.class));

            oracle.sql.STRUCT address = (oracle.sql.STRUCT) rs.getObject(3);
            tr.setAddressinfo((Address) address.toClass(Address.class));
            tr.setDates(rs.getString(4));
            tr.setStatus(rs.getInt(5));
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tr;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_employees")
    public ArrayList<Employee> get_employees() {
        ArrayList<Employee> emp = new ArrayList();
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from employee");
            while (rs.next()) {
                Employee tr = new Employee();
                tr.setId(rs.getInt(1));
                oracle.sql.STRUCT user = (oracle.sql.STRUCT) rs.getObject(2);
                tr.setUserinfo((User) user.toClass(User.class));
                
                oracle.sql.STRUCT address = (oracle.sql.STRUCT) rs.getObject(3);
                tr.setAddressinfo((Address) address.toClass(Address.class));
                tr.setDates(rs.getString(4));
                tr.setStatus(rs.getInt(5));
                emp.add(tr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return emp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deactivateemp")
    public boolean deactivateemp(@WebParam(name = "empid") int empid) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE employee SET status=0 where id=" + empid;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "activateemp")
    public boolean activateemp(@WebParam(name = "empid") int empid) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE employee SET status=1 where empid=" + empid;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }
}