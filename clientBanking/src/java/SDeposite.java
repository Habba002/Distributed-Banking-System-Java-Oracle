/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Habib
 */
public class SDeposite extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("self_deposite.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        
        int ACNUMBER = Integer.parseInt(request.getParameter("TO"));
        int AMOUNT = Integer.parseInt(request.getParameter("AMOUNT"));
        String AMOUNT2 = request.getParameter("AMOUNT2");
        String BRANCH = request.getParameter("BRANCH");
        String pnumber = request.getParameter("PNUMBER");
        String role=(String) request.getSession(false).getAttribute("role");

        boolean returnval = int1.deposite(AMOUNT, AMOUNT2, 0, ACNUMBER, BRANCH, pnumber, role);

        if(returnval==true){
            response.sendRedirect("check?search="+ACNUMBER);
        }else
            r.print("<h2>Problem happen whiel performing please try <a href='/clientBanking'>again</a><h2>");
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
