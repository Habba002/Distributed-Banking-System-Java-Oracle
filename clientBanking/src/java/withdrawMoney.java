
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class withdrawMoney extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        ONLINEBANKING int1 = null;// interface class

        PrintWriter r = response.getWriter();//for writing in to web
     
        boolean confirm = false;
        try {
            int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        int ACNUMBER = Integer.parseInt(request.getParameter("ACNUMBER"));
        int AMOUNT = Integer.parseInt(request.getParameter("AMOUNT"));
        String AMOUNT2 = request.getParameter("AMOUNT2");

        boolean returnval = int1.withdrawRMI(ACNUMBER, AMOUNT, AMOUNT2, "3");

        if(returnval==true){
            response.sendRedirect("check?search="+ACNUMBER);
        }else
            r.print("<h2>Problem happen whiel performing please try <a href='/clientBanking'>again</a><h2>");
    }
}
