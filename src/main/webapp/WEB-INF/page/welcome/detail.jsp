<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/5/29
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String rootPath = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Learn &mdash; Free Website Template, Free HTML5 Template by freehtml5.co</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Website Template by freehtml5.co"/>
    <meta name="keywords"
          content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive"/>


    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/magnific-popup.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/owl.theme.default.min.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="<%=rootPath%>/welcomeResource/css/style.css">

    <!-- Modernizr JS -->
    <script src="<%=rootPath%>/welcomeResource/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="/welcomeResource/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <nav class="fh5co-nav" role="navigation">
        <div class="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 text-right">
                        <p class="num">Call: +01 123 456 7890</p>
                        <ul class="fh5co-social">
                            <li><a href="#"><i class="icon-twitter"></i></a></li>
                            <li><a href="#"><i class="icon-dribbble"></i></a></li>
                            <li><a href="#"><i class="icon-github"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="top-menu">
            <div class="container">
                <div class="row">
                    <div class="col-xs-1">
                        <div id="fh5co-logo"><a href="/">云仓<span>.</span></a></div>
                    </div>
                    <div class="col-xs-11 text-right menu-1">
                        <ul>
                            <li><a href="/">首页</a></li>
                            <li class="has-dropdown active">
                                <a href="/detail">内容</a>
                                <ul class="dropdown">
                                    <li><a href="/yuncang/sale">销售</a></li>
                                    <li><a href="/yuncang/import">采购</a></li>
                                    <li><a href="/yuncang/goods">商品管理</a></li>
                                    <li><a href="/yuncang/maney">资金管理</a></li>
                                </ul>
                            </li>
                            <li><a href="/contact">联系我们</a></li>
                            <li class="btn-cta"><a href="/yuncang/login"><span>登陆</span></a></li>
                            <li class="btn-cta"><a href="/yuncang/register"><span>注册</span></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </nav>

    <header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner"
            style="background-image:url(<%=rootPath%>/welcomeResource/images/img_bg_2.jpg);"
            data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center">
                    <div class="display-t">
                        <div class="display-tc animate-box" data-animate-effect="fadeIn">
                            <h1>内容</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div id="fh5co-started" style="background-image:url(<%=rootPath%>/welcomeResource/images/img_bg_2.jpg);">
        <div class="overlay"></div>
        <div class="container">
            <div class="row animate-box">
                <div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
                    <h2>尽情使用吧!</h2>
                    <p>请您在使用过程中将您遇到的bug信息反馈给我们</p>
                </div>
            </div>
            <div class="row animate-box">
                <div class="col-md-8 col-md-offset-2 text-center">
                    <p><a href="/yuncang/index" class="btn btn-default btn-lg">start</a></p>
                </div>
            </div>
        </div>
    </div>

    <footer id="fh5co-footer" role="contentinfo">
        <div class="container">
            <div class="row row-pb-md">
                <div class="col-md-3 fh5co-widget">
                    <h4>关于我们</h4>
                    <p>云仓,致力于解决线上电商的线下问题,让管理线下的仓库不再困难!</p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
                    <h4>本项目参考网站</h4>
                    <ul class="fh5co-footer-links">
                        <li><a href="https://www.alipay.com/">支付宝</a></li>
                        <li><a href="http://www.lk361.com/">来肯云商</a></li>
                        <li><a href="http://wangwang.taobao.com/">阿里旺旺</a></li>
                        <li><a href="http://www.cssmoban.com/">模板之家</a></li>
                    </ul>
                </div>

                <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
                    <h4>本项目各框架官网</h4>
                    <ul class="fh5co-footer-links">
                        <li><a href="https://spring.io/">Spring</a></li>
                        <li><a href="http://www.mybatis.org/mybatis-3/zh/">Mybatis中文文档</a></li>
                        <li><a href="http://v3.bootcss.com/">Bootstrap3中文文档</a></li>
                    </ul>
                </div>

                <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
                    <h4>本项目参考开源框架GitHub地址</h4>
                    <ul class="fh5co-footer-links">
                        <li><a href="https://github.com/twbs/bootstrap">Bootstrap</a></li>
                        <li><a href="https://github.com/spring-projects">Spring</a></li>
                        <li><a href="https://github.com/mybatis/mybatis-3/tree/master/src/site">Mybatis</a></li>
                    </ul>
                </div>

                <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
                    <h4>本项目使用的前端插件(very good!)</h4>
                    <ul class="fh5co-footer-links">
                        <li><a href="http://momentjs.cn/docs/#/get-set/get/">Moment.js</a></li>
                        <li><a href="http://www.runoob.com/manual/Flat-UI/">Flat-UI</a></li>
                        <li><a href="http://craftpip.github.io/jquery-confirm/">jQuery-Confirm</a></li>
                        <li><a href="http://bootstrap-table.wenzhixin.net.cn/zh-cn/">Bootstrap-table(表格)</a></li>
                        <li><a href="http://silviomoreto.github.io/bootstrap-select/examples/">select2(下拉菜单)</a></li>
                        <li><a href="http://vitalets.github.io/x-editable/">x-editable(行内编辑)</a></li>
                        <li><a href="https://chmln.github.io/flatpickr/localization/">flatpickr(日期选择器)</a></li>
                    </ul>
                </div>
            </div>

            <div class="row copyright">
                <div class="col-md-12 text-center">
                    <p>
                        <small class="block">&copy; 2017 All Rights Reserved.云仓</small>
                    </p>
                    <p>
                    <ul class="fh5co-social-icons">
                        <li><a href="#"><i class="icon-twitter"></i></a></li>
                        <li><a href="#"><i class="icon-facebook"></i></a></li>
                        <li><a href="#"><i class="icon-linkedin"></i></a></li>
                        <li><a href="#"><i class="icon-dribbble"></i></a></li>
                    </ul>
                    </p>
                </div>
            </div>

        </div>
    </footer>
</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>

<!-- jQuery -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="<%=rootPath%>/welcomeResource/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.stellar.min.js"></script>
<!-- Carousel -->
<script src="<%=rootPath%>/welcomeResource/js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="<%=rootPath%>/welcomeResource/js/jquery.magnific-popup.min.js"></script>
<script src="<%=rootPath%>/welcomeResource/js/magnific-popup-options.js"></script>
<!-- Main -->
<script src="<%=rootPath%>/welcomeResource/js/main.js"></script>

</body>
</html>


