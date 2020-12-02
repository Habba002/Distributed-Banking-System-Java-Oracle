
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createNewAccount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter r = response.getWriter();

        try {
            ONLINEBANKING int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");
            String ACCTYPE = request.getParameter("ACCTYPE");
            String OCCUPTION = request.getParameter("OCCUPTION");
            String FNAME = request.getParameter("FNAME");
            String LNAME = request.getParameter("LNAME");
            String MNAME = request.getParameter("MNAME");
            String GENDER = request.getParameter("GENDER");
            String PHOTO = "12.jpg";
            String PNUM = request.getParameter("PNUM");
            int BALANCE = Integer.parseInt(request.getParameter("BALANCE"));
            String NATIONALITY = request.getParameter("NATIONALITY");
            String BRANCH = request.getParameter("BRANCH");
            String ADDRESS = request.getParameter("ADDRESS");
            String DISTRICT = request.getParameter("DISTRICT");
            int empId = Integer.parseInt(request.getSession().getAttribute("id").toString());
            int returnval = int1.createAccount(FNAME, MNAME, LNAME, ADDRESS, ACCTYPE, OCCUPTION, DISTRICT, BRANCH, BALANCE, PNUM, PHOTO, GENDER, NATIONALITY, 1,empId);
            if (returnval > 0) {
                response.sendRedirect("check?search=" + returnval);
            } else {
                response.sendRedirect("CREATEACC.jsp");

            }
            r.print(returnval);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
