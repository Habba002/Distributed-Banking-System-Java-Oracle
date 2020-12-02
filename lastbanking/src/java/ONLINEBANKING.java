
import entity.Account;
import entity.Employee;
import entity.News;
import entity.Transaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ONLINEBANKING extends Remote {

    public int createAccount(String FNAME, String MNAME, String LNAME, String ADDRESS, String ACCTYPE, String OCCUPTION, String DISTRICT, 
            String BRANCH, double BALANCE, String PNUM, String PHOTO, String GENDER, String NATIONALITY, int STATUS, int empId) throws RemoteException;

    /**
     *
     * @param acNumber
     * @return
     * @throws RemoteException
     */    
    public boolean checkAccount(int acNumber) throws RemoteException;

    public boolean activateemp(int empid) throws RemoteException;

    public boolean deactivateemp(int empid) throws RemoteException;

    public boolean checkBalance(int acNumber, int amount) throws RemoteException;

    /**
     *
     * @param acount
     * @return
     * @throws RemoteException
     */
    public boolean updateAccount(Account acount) throws RemoteException;

    /**
     *
     * @return @throws RemoteException
     */
    public List<Account> getAccounts() throws RemoteException;

    /**
     *
     * @param deposite
     * @return
     * @throws RemoteException
     */
    public boolean deposite(int AMOUNT, String AMOUNT2, int FROM, int TO, String BRANCH, String PNUM, String role) throws RemoteException;

    /**
     *
     * @param withdraw
     * @return
     * @throws RemoteException
     */
    public boolean withdrawRMI(int ACNUMBER, int AMOUNT, String AMOUNT2, String EMP) throws RemoteException;
    
    /**
     *
     * @param tran
     * @return
     * @throws RemoteException
     */
    public int transfer(int amount, String amount2, String s_branch, String s_firstname, String s_middlename, String s_lastname, String s_address, String date, String r_firstname, String r_middlename, 
            String r_lastname, String r_address, String r_phone, String r_branch, int emp_id, int status) throws RemoteException;

    /**
     *
     * @param acNumber
     * @return
     * @throws RemoteException
     */
    public List<Transaction> transaction(String acNumber) throws RemoteException;

    /**
     *
     * @param emp
     * @return
     * @throws RemoteException
     */
    public int addEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, int STATUS) throws RemoteException;
    
    /**
     *
     * @param emp
     * @return
     * @throws RemoteException
     */
    public boolean manageEmployee(Employee emp) throws RemoteException;

    /**
     *
     * @param empId
     * @return
     * @throws RemoteException
     */
    public Employee getEmployee(String empId) throws RemoteException;

    /**
     *
     * @return @throws RemoteException
     */
    public List<Employee> getEmployees() throws RemoteException;

    /**
     *
     * @param newsId
     * @return
     * @throws RemoteException
     */
    public boolean manageNews(String newsId) throws RemoteException;

    /**
     *
     * @param newsId
     * @return
     * @throws RemoteException
     */
    public News getSingleNews(String newsId) throws RemoteException;

    /**
     *
     * @param news
     * @return
     * @throws RemoteException
     */
    public String addNews(News news) throws RemoteException;

    /**
     *
     * @return @throws RemoteException
     */
    public List<News> getNews() throws RemoteException;

    public int updateEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, String STATUS, int empid) throws RemoteException;    
}
