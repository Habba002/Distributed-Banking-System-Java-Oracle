<%
    if(session.getAttribute("username") != null ){
    %>

<%@page import="java.io.PrintWriter"%>
<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try {
                ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">

        <li class="">
            <a href = "/clientBanking/CheckBalence" >
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> CHECK ACCOUNT  </span>
            </a>
            <b class="arrow"></b>
        </li>
        <% 
           if (session.getAttribute("role").equals("client")) {
        %>
        <%}%>
        <% 
           if (session.getAttribute("role").equals("admin") || session.getAttribute("role").equals("teller")) {
        %>
            <li class="">
                <a href="/clientBanking/SDeposite" >
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> SELF-DEPOSITE </span>
                </a>
            </li>
            
            <li class="">
                <a href="DEPOSITE.jsp" >
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> ACCOUNT TRANSFER </span>
                </a>
            </li>
            <li class="">
                <a href="WITHDRAW.jsp">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> WITHDRAW </span>
                </a>
            </li>
            <li class="">
                <a href="TRANSFER.jsp">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> DIRECT TRANSFER </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="">
                <a href="MANAGE_Transfer.jsp">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> MANAGE TRANSFER </span>
                </a>
                <b class="arrow"></b>
            </li>
            <li class="" >
                <a href="CREATEACC.jsp">
                    <i class="menu-icon fa fa-calendar"></i>

                    <span class="menu-text">
                        CREATE ACCOUNT
                    </span>
                </a>

                <b class="arrow"></b>
            </li>        
        <%}%>
        <%  
            if (session.getAttribute("role").equals("admin")) {
        %>

        <li >
            <a href="MANAGE_ACCOUNT.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> MANAGE ACCOUNT </span>
            </a>

            <b class="arrow"></b>
        </li>
        
        <%}%>

        <%            
            if (session.getAttribute("role").equals("admin")) {
        %>

        <li >
            <a href="NewsAdd.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> ADD NEWS </span>
            </a>

            <b class="arrow"></b>
        </li>
        
        <%}%>
         <%                  
            if (session.getAttribute("role").equals("admin")) {
        %>

        <li class="">
            <a href="ADDEMPS.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> ADD EMPLOYEE </span>
            </a>

            <b class="arrow"></b>
        </li>
        <%}%>
          <%                  
            if (session.getAttribute("role").equals("admin")) {
        %>

        <li class="">
            <a href="manage_emp.jsp" >
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> MANAGE EMPLOYEES </span>
            </a>

            <b class="arrow"></b>
        </li>
        
        <%}%>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>
                
<%
    }
%>