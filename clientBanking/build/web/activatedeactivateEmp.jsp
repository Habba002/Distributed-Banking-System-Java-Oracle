<%
    if (session.getAttribute("username") == null && session.getAttribute("password") == null) {
        response.sendRedirect("LOGIN.jsp");
    }
%>
<%@page import="thealeke.Thealekeweb"%>
<%@page import="thealeke.Thealekeweb_Service"%>

<%@page import="java.rmi.Naming"%>
<%

   int empid = Integer.parseInt( request.getParameter("empid"));
        String status = request.getParameter("status");
     Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
       boolean ret=false;
      
        if(status.equals("0")){
               ret=proxy.activateemp(empid);
        }
        
        else if(status.equals("1")){
             ret=proxy.deactivateemp(empid);
        }
    
          response.sendRedirect("manage_emp.jsp");



%>
