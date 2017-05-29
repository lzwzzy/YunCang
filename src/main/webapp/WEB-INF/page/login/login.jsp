<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/15
  Time: 10:45
  To change this template use File | Settings | File Templates.
  登陆页面
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
    <title>登陆-云仓</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>

    <!-- 图标 -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=rootPath%>/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=rootPath%>/resources/img/favicon.png">
    <!-- 字体 -->
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

    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="网站模板">网站模板</a></div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">


            <!-- Start Sign In Form -->
            <form id="login_form" class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>登陆</h2>
                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input name="username" type="text" class="form-control" id="username" placeholder="用户名"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input name="password" type="password" class="form-control" id="password" placeholder="密码"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="remember"><input type="checkbox" id="remember">记住我(7天)</label>
                </div>
                <div class="form-group">
                    <p>还没有账号? <a href="/yuncang/register">注册</a> | <a href="#">忘记密码?</a></p>
                </div>
                <div class="form-group">
                    <button id="loginBtn" type="button" class="btn btn-primary">
                        登陆
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
</div>

<!-- jQuery -->
<script src="<%=rootPath%>/loginResource/js/jquery.min.js"></script>
<!-- jQuery cookie操作插件 -->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
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

<script src="<%=rootPath%>/resources/js/login/login.js"></script>

</body>
</html>
