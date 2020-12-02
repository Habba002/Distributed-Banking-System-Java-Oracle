<%
    if (session.getAttribute("username") == null && session.getAttribute("password") == null) {
        response.sendRedirect("LOGIN.jsp");
    }
%>
<%@page import="java.io.IOException"%>
<%@page import="thealeke.Thealekeweb"%>
<%@page import="thealeke.Thealekeweb_Service"%>
<%
   int accnum = Integer.parseInt( request.getParameter("accnum"));
        String status = request.getParameter("status");
        Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
       boolean ret=false;
        if(status.equals("0")){
               ret=proxy.deactivate(accnum);
        }
        
        else if(status.equals("1")){
             ret=proxy.activate(accnum);
        }
    
          response.sendRedirect("MANAGE_ACCOUNT.jsp");



%>
