
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;

public class Transfermoney extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {

            response.sendRedirect("index.jsp");
        }
        boolean bool;

        String s_branch = request.getParameter("s_branch");
        String AMOUNT2 = request.getParameter("AMOUNT2");
        String s_firstname = request.getParameter("s_firstname");
        String s_middlename = request.getParameter("s_middlename");
        String s_lastname = request.getParameter("s_lastname");
        String s_address = request.getParameter("s_address");

        String r_firstname = request.getParameter("r_firstname");
        String r_middlename = request.getParameter("r_middlename");
        String r_lastname = request.getParameter("r_lastname");
        String r_address = request.getParameter("r_address");
        String r_phone = request.getParameter("r_phone");
        String r_branch = request.getParameter("r_branch");
        int emp_id = Integer.parseInt(request.getSession().getAttribute("id").toString());
        int amount = Integer.parseInt(request.getParameter("AMOUNT"));
        String date = new Date().toString();
        ONLINEBANKING int1 = null;// interface class
        int confirm = 0;
        try {
            int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");
            PrintWriter out = response.getWriter();
            confirm = int1.transfer(amount, AMOUNT2, s_branch, s_firstname, s_middlename, s_lastname, s_address, date, r_firstname, r_middlename, r_lastname, r_address, r_phone, r_branch, emp_id, 0);
            response.sendRedirect("Transfer_view?search="+confirm);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
