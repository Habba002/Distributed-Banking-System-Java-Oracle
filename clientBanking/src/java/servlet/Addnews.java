package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;

public class Addnews extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {

            response.sendRedirect("index.jsp");
        }

        String news = request.getParameter("content");//for getting the value of news from Newsadd.jsp page

        Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
        boolean bool = proxy.addnews(news, "12.jpg");

        response.sendRedirect("MANAGE_ACCOUNT.jsp");
        if (bool) {

        }

    }

}
