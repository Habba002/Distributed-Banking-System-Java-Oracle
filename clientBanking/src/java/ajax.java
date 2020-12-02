
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter r=response.getWriter();
            int accnum=Integer.parseInt(request.getParameter("value"));
            String st=request.getParameter("status");
            ONLINEBANKING int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");
            if(st.equals("account"))
            {
                 
            if(int1.checkAccount(accnum))
                r.print("yes");
            else
                r.print("no");
            
            }else
            {
                int ac=Integer.parseInt(st);
                if(int1.checkBalance(accnum, ac)==true)
                    r.print("yes");
                else
                r.print("no");
            
            }
        } catch (Exception e) {
        }
    }

}
