
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addemployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession(false).getAttribute("role") != null && request.getSession(false).getAttribute("role").equals("admin")) {

        PrintWriter r = response.getWriter();

        try {
            ONLINEBANKING int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");
            String date = new Date().toString();
            String role = "teller";
            int status = 1;
            String FNAME = request.getParameter("FNAME");
            String MNAME = request.getParameter("MNAME");
            String LNAME = request.getParameter("LNAME");
            String GENDER = request.getParameter("GENDER");
            String ADDRESS = request.getParameter("ADDRESS");
            String NATIONALITY = request.getParameter("NATIONALITY");
            String DISTRICT = request.getParameter("DISTRICT");
            String BRANCH = request.getParameter("BRANCH");
            String PNUM = request.getParameter("PNUM");
            String image = "";

            int search=int1.addEmployee(FNAME, MNAME, LNAME, GENDER, ADDRESS, NATIONALITY, DISTRICT, BRANCH, PNUM,image , date, role, status);            
            response.sendRedirect("checkEmployee?search="+search);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        }else
            response.sendRedirect("/clientBanking");
    }
}
