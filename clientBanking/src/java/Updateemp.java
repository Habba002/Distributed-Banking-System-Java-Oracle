/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashen
 */
public class Updateemp extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {

            response.sendRedirect("index.jsp");
        }
        PrintWriter r = response.getWriter();

        try {

            ONLINEBANKING int1 = (ONLINEBANKING) Naming.lookup("//localhost:1099/bank");

            String date = new Date().toString();
            String role = "teller";
            String status = "1";
            String FNAME = request.getParameter("FNAME");
            String MNAME = request.getParameter("MNAME");
            String LNAME = request.getParameter("LNAME");
            String GENDER = request.getParameter("GENDER");
            String ADDRESS = request.getParameter("ADDRESS");
            String NATIONALITY = request.getParameter("NATIONALITY");
            String DISTRICT = request.getParameter("DISTRICT");
            String BRANCH = request.getParameter("BRANCH");
            String PNUM = request.getParameter("PNUM");
            String image = "ashu.jpg";
          int empid=Integer.parseInt(request.getParameter("empid"));
           int search=int1.updateEmployee(FNAME, MNAME, LNAME, GENDER, ADDRESS, NATIONALITY, DISTRICT, BRANCH, PNUM,image , date, role, status,empid);
      if(search==1)
           response.sendRedirect("checkEmployee?search="+empid);
      else
            response.sendRedirect("manage_emp.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
