/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;

/**
 *
 * @author ashen
 */
public class Transfer_grant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode

        String granter = request.getParameter("granter");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean b = proxy.grantTranfer(id, granter);
        if(b)
            response.sendRedirect("MANAGE_Transfer.jsp");
        else
            response.setContentType("text/html");
            response.getWriter().print("<h2>Cannot Grant Server Error</h2>");
    }

}
