
<%@page import="thealeke.Thealekeweb"%>
<%@page import="thealeke.Thealekeweb_Service"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
  

    Thealekeweb_Service  service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
    Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
    String bool = null;
    String username = request.getParameter("username");//request.getParameter("username");//getting the value of username from login.jsp form
    String pass = request.getParameter("password");;//request.getParameter("password");//getting the value of password from login.jsp form

    bool = proxy.login(username, pass);//calling the server methode login to authorize the user

    if (bool != null) {
        
        session= request.getSession();
        session.setAttribute("username", username);//saving the username on session so that it can be available(accessable) in all page
        session.setAttribute("password", pass);//saving the password on session so that it can be available(accessable) in all page
        String role = bool.split("-")[0];
        session.setAttribute("role", role);//saving the role on session to know who is accessing like client or teller or admin so that it can be available(accessable) in all page
        session.setAttribute("id", bool.split("-")[1]);
        
        if (role.equalsIgnoreCase("client")) {
            response.sendRedirect("/clientBanking/CheckBalence");

        } else if (role.equalsIgnoreCase("admin")) {
            response.sendRedirect("MANAGE_ACCOUNT.jsp");

        } else if (role.equalsIgnoreCase("teller")) {
            response.sendRedirect("check_account_1.jsp");
        }
        else{
        PrintWriter pr=response.getWriter();
        pr.print(bool);
        }
    } else {
        response.sendRedirect("LOGIN.jsp");
    }


%>