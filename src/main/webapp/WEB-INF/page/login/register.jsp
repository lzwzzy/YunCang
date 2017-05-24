<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/22
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String rootPath = request.getContextPath();
%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册-云仓</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=rootPath%>/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=rootPath%>/resources/img/favicon.png">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

    <%-- bootstrap基本样式 --%>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%-- jquery-confirm弹出框插件样式 --%>
    <link href="https://cdn.bootcss.com/jquery-confirm/3.2.0/jquery-confirm.min.css" rel="stylesheet">
    <%-- 表单验证插件样式 --%>
    <link href="http://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=rootPath%>/loginResource/css/animate.css">
    <link rel="stylesheet" href="<%=rootPath%>/loginResource/css/style.css">


    <!-- Modernizr JS -->
    <script src="<%=rootPath%>/loginResource/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="/loginResource/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-4 col-md-offset-4">


            <!-- Start Sign In Form -->
            <form class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>新用户注册</h2>

                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input name="username" type="text" class="form-control" id="username" placeholder="用户名"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="phone" class="sr-only">手机号</label>
                    <input name="phone" type="number" class="form-control" id="phone" placeholder="手机号"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input name="password" type="password" class="form-control" id="password" placeholder="密码"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="repassword" class="sr-only">再次输入</label>
                    <input name="repassword" type="password" class="form-control" id="repassword" placeholder="再次输入"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="agree"><input name="agree" type="checkbox" id="agree">同意<a href="javascript:;"
                                                                                           data-toggle="modal"
                                                                                           data-target="#templatemo_modal">用户协议</a></label>
                </div>
                <div class="form-group">
                    <p>已有账号? <a href="/yuncang/login">返回登陆</a></p>
                </div>
                <div class="form-group">
                    <button id="btn_register" type="button" class="btn btn-primary">
                        注册
                    </button>
                </div>
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>
    <div class="row" style="padding-top: 60px; clear: both;">
        <div class="col-md-12 text-center">
            <p>
                <small>&copy; 2017 All Rights Reserved.云仓</small>
            </p>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">取消</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户协议</h4>
                </div>
                <div class="modal-body">
                    <p>根本就没有这个协议,没办法,</p>
                    <p>必须得模仿的像一些啊所以这里有个百度的连接</p>
                    <p>有兴趣的话就点开看看吧<a rel="nofollow"
                                     href="https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%E6%88%91%E4%B8%BA%E4%BB%80%E4%B9%88%E8%BF%99%E4%B9%88%E5%82%BB%E9%80%BC&rsv_pq=96dfbbd00000ad82&rsv_t=eafc01yQ9WLng7I0k4BswuXLh0qreFo7%2FVI%2BsXSny5DHrLNRo6W3gQhqhl8&rqlang=cn&rsv_enter=1&rsv_sug3=21&rsv_sug1=20&rsv_sug7=100">不要点我</a>
                    </p></p>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <%-- Model2 注册成功弹出框--%>
    <div id="successModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title text-center">
                        注册成功
                    </h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <h5 class="text-center">
                            <span id="sec"></span>秒后跳转至登陆页面
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="<%=rootPath%>/loginResource/js/jquery.min.js"></script>
    <%-- jquery-confirm弹窗插件 --%>
    <script src="https://cdn.bootcss.com/jquery-confirm/3.2.0/jquery-confirm.min.js"></script>
    <!-- Bootstrap -->
    <script src="<%=rootPath%>/loginResource/js/bootstrap.min.js"></script>
    <!-- Placeholder -->
    <script src="<%=rootPath%>/loginResource/js/jquery.placeholder.min.js"></script>
    <!-- Waypoints -->
    <script src="<%=rootPath%>/loginResource/js/jquery.waypoints.min.js"></script>
    <%-- 表单验证插件 --%>
    <script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
    <%-- 表单验证插件中文组件 --%>
    <script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"></script>
    <!-- Main JS -->
    <script src="<%=rootPath%>/loginResource/js/main.js"></script>
    <script src="<%=rootPath%>/resources/js/register/register.js"></script>

</body>
</html>


