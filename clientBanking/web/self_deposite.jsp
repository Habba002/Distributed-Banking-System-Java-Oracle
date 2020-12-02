<%
    if (session.getAttribute("username") == null && session.getAttribute("password") == null) {
        response.sendRedirect("LOGIN.jsp");
    }
%>
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
        <div class="main-container ace-save-state" id="main-container">
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
                                    <a href="#">Teller</a>
                                </li>

                                <li>
                                    <a href="#">SELF-DEPOSITE</a>
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

                            <div class="row">
                                <div class="col-xs-12">
                                    <!-- PAGE CONTENT BEGINS -->
                                    <form method="post" action="/clientBanking/SDeposite" class="form-horizontal" id="sample-form">

                                    <div class="form-group has-success">
                                        <label FOR="TO" class="col-xs-12 col-sm-3 control-label no-padding-right">TO</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="number" id="TO" placeholder="TO" name="TO" class="width-100" required="true"/>
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                            <span id="error1"></span>
                                        </div>
                                    </div>
                                    <div class="form-group has-success">
                                        <label for="AMOUNT" class="col-xs-12 col-sm-3 control-label no-padding-right">AMOUNT</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="number" name="AMOUNT" id="AMOUNT" placeholder="AMOUNT" class="width-100" required="true"/>
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                            <span id="error2"></span>
                                        </div>

                                    </div>
                                    <div class="form-group has-success">
                                        <label for="AMOUNT2" class="col-xs-12 col-sm-3 control-label no-padding-right">AMOUNT IN WORD</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" name="AMOUNT2" id="AMOUNT2" placeholder="AMOUNT iIN WORD" class="width-100" required="true"/>
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>

                                    </div>


                                    <div class="form-group has-success">
                                        <label FOR="BRANCH"  class="col-xs-12 col-sm-3 control-label no-padding-right">BRANCH</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="text" name="BRANCH" placeholder="BRANCH" id="BRANCH" class="width-100" required="true"/>
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group has-success">
                                        <label FOR="PHONE" class="col-xs-12 col-sm-3 control-label no-padding-right">PHONE NUMBER</label>

                                        <div class="col-xs-12 col-sm-5">
                                            <span class="block input-icon input-icon-right">
                                                <input type="tel"name="PNUM" id="PHONE" placeholder="PHONE NUMBER" class="width-100" required="true"/>
                                                <i class="ace-icon fa fa-check-circle"></i>
                                            </span>
                                            <span id="error4"></span>
                                        </div>
                                    </div>

                                        <div class=" clearfix form-actions">
                                            <div class="col-md-offset-3 col-md-9">
                                                <center> <button name="sub" id="submit" value="submit" class="btn btn-info" type="submit">
                                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                                        Submit
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
                <%@include file="footer.jsp" %>
                <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
                </a>
            </div><!-- /.main-container -->

            <!-- basic scripts -->

            <!--[if !IE]> -->
            <script src="assets/js/jquery-2.1.4.min.js"></script>

            <!-- <![endif]-->

            <!--[if IE]>
    
    <![endif]-->

            <script type="text/javascript">
                    if ('ontouchstart' in document.documentElement)
                        document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");



            </script>
            <script src="assets/js/jquery.js" type="text/javascript"></script>
            <script type="text/javascript">
                function disable() {// THE SENDER OR RECEIVER ACCOUNT MUST BE FILLED BEFORE AMOUNT
                    if ($("#TO").val() == "")
                    {
                        $("#submit").prop("disabled", true);
                        $("#AMOUNT").prop("disabled", true);
                        $("#AMOUNT").val("");
                        $("#AMOUNT2").prop("disabled", true);
                        $("#AMOUNT2").val("");
                    }
                }
                disable();
                    $("#TO").keyup(function () {
                        var abe = $("#TO").val();

                        disable();
                        $.ajax({
                            type: 'GET',
                            url: 'ajax?status=account',
                            data: {value: abe},
                            success: function (text) {
                                if (text == "no")
                                {
                                    $("#AMOUNT").prop("disabled", true);
                                    $("#AMOUNT").val("");

                                    $("#AMOUNT2").val("");
                                    $("#AMOUNT2").prop("disabled", true);
                                    $("#error1").css("color", "red");
                                    $("#error1").text("the account number don't exist!");
                                    $("#submit").prop("disabled", true);

                                    $("#TO").css("color", "red");

                                } else if (text == "yes")
                                {
                                    $("#AMOUNT").prop("disabled", false);
                                    $("#AMOUNT2").prop("disabled", false);
                                    $("#error1").text("");
                                    $("#submit").prop("disabled", false);

                                    $("#TO").css("color", "green");


                                    if ($("#FROM").val() == $("#TO").val())
                                    {
                                        $("#error1").text("The sender and reciever account must be diffrent!!");
                                        $("#submit").prop("disabled", true);
                                        $("#AMOUNT").prop("disabled", true);
                                        $("#AMOUNT2").prop("disabled", true);
                                        $("#error1").css("color", "red");
                                    } else {
                                        $("#error1").text("");
                                        $("#submit").prop("disabled", false);
                                        $("#AMOUNT").prop("disabled", false);
                                        $("#AMOUNT2").prop("disabled", false);

                                    }


                                }
                            }
                        });
                    })

            </script>
            <!-- page specific plugin scripts -->

            <!-- ace scripts -->
            <script src="assets/js/ace-elements.min.js"></script>
            <script src="assets/js/ace.min.js"></script>
            <!-- inline scripts related to this page -->
    </body>
</html>