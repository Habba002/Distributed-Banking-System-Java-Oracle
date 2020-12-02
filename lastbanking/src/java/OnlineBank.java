
import entity.Account;
import entity.Deposite;
import entity.Employee;
import entity.News;
import entity.Transaction;
import entity.Transfer;
import entity.Withdraw;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Date;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class OnlineBank extends UnicastRemoteObject implements ONLINEBANKING {

    Statement st = null;
    Connection con = null;

    public OnlineBank() throws RemoteException {
        super();
        try {
            con = getConnection();
            st = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
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

    @Override
    public int createAccount(String FNAME, String MNAME, String LNAME, String ADDRESS, String ACCTYPE, String OCCUPTION, 
            String DISTRICT, String BRANCH, double BALANCE, String PNUM, String PHOTO, String GENDER, String NATIONALITY, 
            int STATUS, int empId) throws RemoteException {
        int value = 0;
        try {
            Connection con = getConnection();
            String date = new Date().toString();
            String query = "call createaccount(?,?,?,?,?,?,?,?)";
            CallableStatement ps = con.prepareCall(query);
            
            StructDescriptor sc = StructDescriptor.createDescriptor("SYSTEM.USERINFO", con);    
            int account_no = (int)(Math.random() * 10000);
            
            Object[] object = new Object[]{FNAME, MNAME, LNAME, GENDER, PNUM, OCCUPTION,PHOTO};
            STRUCT user = new STRUCT(sc, con, object);
            
            object = new Object[]{ADDRESS, NATIONALITY, DISTRICT, BRANCH};
            sc = StructDescriptor.createDescriptor("SYSTEM.ADDRESS", con);    
            STRUCT address = new STRUCT(sc, con, object);
            ps.setInt(1, account_no);
            ps.setObject(2, user);
            ps.setObject(3, address);
            ps.setString(4, ACCTYPE);
            ps.setDouble(5, BALANCE);
            ps.setInt(6, empId);
            ps.setString(7, date);
            ps.setInt(8, STATUS);
            ps.execute();

            Statement ts = con.createStatement();
            query = "INSERT INTO client_login (account_no, username, password, role) VALUES ("+account_no+", '"+FNAME.toLowerCase()+"', '123456', 'client')";
            ts.execute(query);
            st.close();
            con.close();
            value = account_no;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }

    @Override
    public boolean checkBalance(int acNumber, int amount) throws RemoteException {
        boolean rt = false;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("select balance as balance from account where account_no = " + acNumber);
            if (rs.next()) {
                int bal = rs.getInt(1);
                if (bal >= amount) {
                    rt = true;
                }
            }

            st.close();
            con.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rt;
    }

    /**
     *
     * @param acNumber
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean checkAccount(int acNumber) throws RemoteException {

        boolean rt = false;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from baccount where account_no=" + acNumber);
            if (rs.next()) {
                rt = true;
            }

            st.close();
            con.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rt;
    }

    @Override
    public boolean updateAccount(Account acount) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAccounts() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposite(int AMOUNT, String AMOUNT2, int FROM, int TO, String BRANCH, String PNUM, String role) throws RemoteException {

        boolean bool = false;
        String date = new Date().toString();
        try {
            Connection con = getConnection();
            
            String update;
            if(FROM == 0)
                    update = "call selfdeposite(?, ?, ?, ?, ?, ?, ?, ?)";
            else
                update = "call accdeposite(?, ?, ?, ?, ?, ?, ?, ?)";
            
            CallableStatement ps = con.prepareCall(update);
            ps.setInt(1, AMOUNT);
            ps.setString(2, AMOUNT2);
            ps.setInt(3, TO);
            ps.setInt(4, FROM);
            ps.setString(5, BRANCH);
            ps.setString(6, PNUM);
            ps.setString(7, date);
            ps.setString(8, role);
            ps.execute();
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return bool;

    }

    @Override
    public boolean withdrawRMI(int ACNUMBER, int AMOUNT, String AMOUNT2, String EMP) throws RemoteException {

        boolean return_value = false;
        ResultSet rs = null;
        String date = new Date().toString();
        
        try {
            Connection con = getConnection();
            String update = "call withdrawadd(?, ?, ?, ?, ?)";
            
            CallableStatement ps = con.prepareCall(update);
            ps.setInt(1, ACNUMBER);
            ps.setInt(2, AMOUNT);
            ps.setString(3, date);
            ps.setString(4, EMP);
            ps.setString(5, AMOUNT2);
            ps.execute();
            return_value = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return return_value;

    }

    @Override
    public int transfer(int amount, String amount2, String s_branch, String s_firstname, String s_middlename, String s_lastname, String s_address,
            String date, String r_firstname, String r_middlename, String r_lastname, String r_address, String r_phone, String r_branch, int emp_id, int status) throws RemoteException {

        int bool = 0;

        String query = "INSERT INTO transfer (id, amount,amount2, s_branch, s_firstname, s_middlename, s_lastname,"
                + "s_address,dates,r_firstname,r_middlename,r_lastname,"
               + "r_phone,r_branch,emp_id,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            int conf_num = (int)(Math.random() * 10000);
            ps.setInt(1, conf_num);
            ps.setInt(2, amount);
            ps.setString(3, amount2);
            ps.setString(4, s_branch);
            ps.setString(5, s_firstname);
            ps.setString(6, s_middlename);
            ps.setString(7, s_lastname);
            ps.setString(8, s_address);
            ps.setString(9, date);
            ps.setString(10, r_firstname);
            ps.setString(11, r_middlename);
            ps.setString(12, r_lastname);
            ps.setString(13, r_phone);
            ps.setString(14, r_branch);
            ps.setInt(15, emp_id);
            ps.setInt(16, status);
            ps.execute();
            bool = conf_num;

        } catch (Exception ex) {

            ex.printStackTrace();
        }        
        return bool;
    }

    @Override
    public List<Transaction> transaction(String acNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean manageEmployee(Employee emp) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployee(String empId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getEmployees() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean manageNews(String newsId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public News getSingleNews(String newsId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addNews(News news) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<News> getNews() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, int STATUS) throws RemoteException {
        int emp = 0;
        try {
            Connection con = getConnection();
            
            String date = new Date().toString();
            String query = "call createemployee(?, ?, ?, ?, ?)";            
            CallableStatement ps = con.prepareCall(query);
            
            StructDescriptor sc = StructDescriptor.createDescriptor("SYSTEM.USERINFO", con);   
            Object[] object = new Object[]{FNAME, MNAME, LNAME, GENDER, PNUM, "Employee",PHOTO};
            STRUCT user = new STRUCT(sc, con, object);
            
            object = new Object[]{ADDRESS, NATIONALITY, DISTRICT, BRANCH};
            sc = StructDescriptor.createDescriptor("SYSTEM.ADDRESS", con);    
            STRUCT address = new STRUCT(sc, con, object);
            
            int id = (int)(Math.random() * 100000);
            ps.setInt(1, id);
            ps.setObject(2, user);
            ps.setObject(3, address);
            ps.setString(4, date);
            ps.setInt(5, STATUS);
            ps.execute();
           
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from employee order by id desc");
            if(rs.next()){
                emp = rs.getInt("id");            
                con = getConnection();
                Statement ts = con.createStatement();
                query = "INSERT INTO login (account_no, username, password, role) VALUES ("+emp+", '"+FNAME.toLowerCase()+"', '123456', 'teller')";
                ts.executeUpdate(query);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    @Override
    public int updateEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, String STATUS, int empid) throws RemoteException {
        int i = 0;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();

            String query = "UPDATE employee SET firstname='" + FNAME + "',middlename='" + MNAME + "',lastname='" + LNAME + "',address='" + ADDRESS + "',nationality='" + NATIONALITY + "',date='" + Date + "',district='" + DISTRICT + "',branch='" + BRANCH + "',pnum='" + PNUM + "',gender='" + GENDER + "',status='" + STATUS + "' WHERE empid=" + empid;
            ts.executeUpdate(query);
            i = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean activateemp(int empid) throws RemoteException {
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

    @Override
    public boolean deactivateemp(int empid) throws RemoteException {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
           String query = "UPDATE employee SET status=0 where empid=" + empid;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }
}
