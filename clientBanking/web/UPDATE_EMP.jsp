<%
    if (session.getAttribute("username") == null && session.getAttribute("password") == null) {
        response.sendRedirect("LOGIN.jsp");
    }
%>
<%@page import="thealeke.Thealekeweb"%>
<%@page import="thealeke.Thealekeweb_Service"%>
<%@page import="java.rmi.Naming"%>
<%@page import="thealeke.Employee"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>HTK</title>

        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- page specific plugin styles -->

        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

        <!--[if lte IE 9]>
                <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
        <![endif]-->
        <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

        <!--[if lte IE 9]>
          <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
        <![endif]-->

        <!-- inline styles related to this page -->

        <!-- ace settings handler -->
        <script src="assets/js/ace-extra.min.js"></script>

        <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

        <!--[if lte IE 8]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="no-skin">
          <%@include file="tabmenu.jsp" %>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>
            <%@include file="navigation.jsp" %>


            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>

                            <li>
                                <a href="#">Update</a>
                            </li>

                        </ul><!-- /.breadcrumb -->

                        <!-- /.nav-search -->
                    </div>

                    <div class="page-content">
                        <div class="ace-settings-container" id="ace-settings-container">
                            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                                <i class="ace-icon fa fa-cog bigger-130"></i>
                            </div>

                            <div class="ace-settings-box clearfix" id="ace-settings-box">
                                <div class="pull-left width-50">
                                    <div class="ace-settings-item">
                                        <div class="pull-left">
                                            <select id="skin-colorpicker" class="hide">
                                                <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                                <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                                <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                                <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                            </select>
                                        </div>
                                        <span>&nbsp; Choose Skin</span>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-add-container">
                                            Inside
                                            <b>.container</b>
                                        </label>
                                    </div>
                                </div><!-- /.pull-left -->

                                <div class="pull-left width-50">
                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                                    </div>

                                    <div class="ace-settings-item">
                                        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
                                        <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                                    </div>
                                </div><!-- /.pull-left -->
                            </div><!-- /.ace-settings-box -->
                        </div><!-- /.ace-settings-container -->

                        <%

                            Employee emp = null;
                            int empid=0;
                            try {

                                Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to call login methode
                                Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
                                 empid = Integer.parseInt(request.getParameter("empid"));
                                emp = proxy.checkEmployee(empid);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        %>


                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <form method="get" action="Updateemp" class="form-horizontal" id="sample-form">



                                    <div class="form-group has-success">
                                        <label for="FNAME" class="col-xs-12 col-sm-3 control-label no-padding-right">FIRST NAME</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" id="FNAME"  name="FNAME"  class="width-100" value=<%=emp.getFNAME()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>

                                    <div class="form-group has-success">
                                        <label for="MNAME" class="col-xs-12 col-sm-3 col-md-3 control-label no-padding-right">MIDDLE NAME</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" id="MNAME" name="MNAME" class="width-100" value=<%=emp.getMNAME()%> required="true"  />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>

                                    <div class="form-group has-success">
                                        <label for="LNAME" class="col-xs-12 col-sm-3 control-label no-padding-right">LAST NAME</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" id="LNAME" name="LNAME"  class="width-100" value=<%=emp.getLNAME()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>

                                    <div class="form-group has-success">
                                        <label for="GENDER" class="col-xs-12 col-sm-3 control-label no-padding-right">GENDER</label>

                                        <div class="col-sm-6">



                                            <select name="GENDER" id="GENDER">
                                                <option selected="selected">MALE</option>

                                                <option>FEMALE</option>

                                            </select>
                                        </div>

                                    </div>


                                    <div class="form-group has-success">
                                        <label for="ADDRESS" class="col-xs-12 col-sm-3 col-md-3 control-label no-padding-right"> ADDRESS</label>
                 
                                        <input type="hidden" name="empid"  value=<%=empid %>   class="width-100" required="true"/>
                                        
                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" id="ADDRESS" name="ADDRESS" class="width-100" value=<%=emp.getGENDER()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>
                                    <div class="form-group has-success">
                                        <label for="NATIONALITY" class="col-xs-12 col-sm-3 control-label no-padding-right"> NATIONALITY</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" id="NATIONALITY" NAME="NATIONALITY" class="width-100" value=<%=emp.getNATIONALITY()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>

                                    <div class="form-group has-success">
                                        <label  for="DISTRICT" class="col-xs-12 col-sm-3 control-label no-padding-right">DISTRICT</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" name="DISTRICT" id="DISTRICT" class="width-100" value=<%=emp.getDISTRICT()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group has-success">
                                        <label  for="BRANCH" class="col-xs-12 col-sm-3 control-label no-padding-right">BRANCH</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" name="BRANCH" id="BRANCH" class="width-100" value=<%=emp.getBRANCH()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>
                                    </div>



                                    <div class="form-group has-success">
                                        <label  for="PHONE NUMBER" class="col-xs-12 col-sm-3 control-label no-padding-right">PHONE NUMBER</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" name="PNUM" id="PHONE NUMBER" class="width-100" value=<%=emp.getPNUM()%> required="true" />
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="form-group has-success">
                                        <label for="PHOTO" class="col-xs-12 col-sm-3 control-label no-padding-right">PHOTO</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="file" name="PHOTO" id="id-input-file-2" />

                                            </span>
                                        </div>
                                    </div>



                                    <div class=" clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <center> <button TYPE="submit"  name="submit" class="btn btn-info" type="button">
                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                    UPDATE
                                                </button>

                                                &nbsp; &nbsp; &nbsp;
                                                <button class="btn" type="reset">
                                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                                    Reset
                                                </button></center>
                                        </div>
                                    </div>


                                </form>
                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120">
                            <span class="blue bolder">HTK</span>
                            BANK &copy; 2018
                        </span>

                        &nbsp; &nbsp;

                    </div>
                </div>
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="assets/js/jquery-2.1.4.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
        <script type="text/javascript">
                    if ('ontouchstart' in document.documentElement)
                        document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- page specific plugin scripts -->

        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        <script type="text/javascript">
                    jQuery(function ($) {
                        $('#id-input-file-1 , #id-input-file-2').ace_file_input({
                            no_file: 'No File ...',
                            btn_choose: 'Choose',
                            btn_change: 'Change',
                            droppable: false,
                            onchange: null,
                            thumbnail: false //| true | large
                                    //whitelist:'gif|png|jpg|jpeg'
                                    //blacklist:'exe|php'
                                    //onchange:''
                                    //
                        });
                    });

        </script>
        <!-- inline scripts related to this page -->
    </body>
</html>
