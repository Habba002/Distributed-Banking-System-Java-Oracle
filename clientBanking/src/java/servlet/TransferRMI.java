//package servlet;
//
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.rmi.Naming;
//import java.util.Date;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class TransferRMI extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {
//
//            response.sendRedirect("index.jsp");
//        }
//        boolean bool;
//        Transfer tran = new Transfer();
//        tran.setAmount(Integer.parseInt(request.getParameter("AMOUNT")));
//        tran.setS_branch(request.getParameter("s_branch"));
//        tran.setAmount2(request.getParameter("AMOUNT2"));
//        tran.setS_firstname(request.getParameter("s_firstname"));
//        tran.setS_middlename(request.getParameter("s_middlename"));
//        tran.setS_middlename(request.getParameter("s_lastname"));
//        tran.setS_address(request.getParameter("s_address"));
//        tran.setDate(new Date().toString());
//        tran.setR_firstname(request.getParameter("r_firstname"));
//        tran.setR_middlename(request.getParameter("r_middlename"));
//        tran.setR_lastname(request.getParameter("r_lastname"));
//        tran.setR_address(request.getParameter("r_address"));
//        tran.setR_phone(request.getParameter("r_phone"));
//        tran.setR_branch(request.getParameter("r_branch"));
//        tran.setEmp_id("emp3");
//
//        ONLINEBANKING int1 = null;// interface class
//        boolean confirm = false;
//        try {
//            int1 = (ONLINEBANKING) Naming.lookup("//localhost:4499/ashu");
//            bool = int1.transfer(tran);
//            PrintWriter out = response.getWriter();
//            out.print(bool + "ashu");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//}
