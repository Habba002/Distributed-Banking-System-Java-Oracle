package servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thealeke.Account;
import thealeke.Address;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;
import thealeke.User;

/**
 *
 * @author ashen
 */
public class UPDATE_ACC extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {

            response.sendRedirect("index.jsp");
        }

        Account ac = new Account();

        ac.setAccountNo(Integer.parseInt(request.getParameter("accnum")));
        ac.setAccountType(request.getParameter("ACCTYPE"));
        
        User user = new User();
        user.setFirstname(request.getParameter("FNAME"));
        user.setMiddlename(request.getParameter("MNAME"));
        user.setLastname(request.getParameter("LNAME"));
        user.setGender(request.getParameter("GENDER"));
        user.setPhoneNo(request.getParameter("PNAME"));
        user.setPhoto("");
        user.setOccupation(request.getParameter("OCCUPTION"));
        ac.setUserinfo(user);
        
        Address address = new Address();
        address.setAddress(request.getParameter("ADDRESS"));
        address.setBranch(request.getParameter("BRANCH"));
        address.setNationality(request.getParameter("NATIONALITY"));
        address.setDistrict(request.getParameter("DISTRICT"));
        ac.setAddressinfo(address);
        
        ac.setBalance(Double.parseDouble(request.getParameter("BALANCE")));
        Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
        Account a = proxy.updateAccount(ac);
        response.sendRedirect("accountCheck?search=" + a.getAccountNo());
    }
}