<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <%-- 静态包含 --%>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>云仓</span>Admin</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> ${user} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人资料</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <img src="<%=rootPath%>/resources/img/logo-dark.png">
        </div>
    </form>
    <ul class="nav menu">
        <li class="active"><a href="/yuncang/index"><span class="glyphicon glyphicon-home"></span> 起始页</a></li>
        <li><a href="/yuncang/import"><span class="glyphicon glyphicon-shopping-cart"></span> 采购</a></li>
        <li><a href="/yuncang/sale"><span class="glyphicon glyphicon-tag"></span> 销售</a></li>
        <li class="parent"><a href="#sub-item-1" data-toggle="collapse"><span
                class="glyphicon glyphicon-folder-close"></span>
            仓库<span
                    data-toggle="collapse"
                    href="#sub-item-1"
                    class="icon pull-right"><em
                    class="glyphicon glyphicon-s glyphicon-plus"></em></span></a>
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="/yuncang/goods">
                        <span class="glyphicon glyphicon-tags"></span> 商品管理
                    </a>
                </li>
                <li>
                    <a class="" href="/yuncang/proffer">
                        <span class="glyphicon glyphicon-cloud-download"></span> 供货商管理
                    </a>
                </li>
            </ul>
        </li>
        <li><a href="/yuncang/maney"><span class="glyphicon glyphicon-usd"></span> 资金</a></li>

        <li role="presentation" class="divider"></li>

    </ul>
    <div class="attribution">More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> -
        Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></div>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">起始页</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">云仓</h1>
        </div>
    </div><!--/.row-->

    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>

    <div class="row">
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-orange panel-widget">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-tasks glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large"><a href="/yuncang/goods">${goodsBills.size()}</a></div>
                        <div class="text-muted">当前在架商品</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-blue panel-widget ">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-shopping-cart glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large"><a href="/yuncang/import">￥${todayimportTotalPrice}</a></div>
                        <div class="text-muted">今日采购支出</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-teal panel-widget">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-tag glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large"><a href="/yuncang/sale">￥${todaySaleTotalPrice}</a></div>
                        <div class="text-muted">今日营业额</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-red panel-widget">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-stats glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large">￥25.2</div>
                        <div class="text-muted">账户余额</div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">近7天营业额走势</div>
                <div class="panel-body">
                    <div class="canvas-wrapper">
                        <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/.row-->
</div>    <!--/.main-->



</body>
<%@include file="common/foot.jsp" %>
<%-- 时间格式化插件 --%>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment.js"></script>
<%-- 时间格式化插件中文组件 --%>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/locale/zh-cn.js"></script>
<script src="<%=rootPath%>/resources/js/common/chart.min.js"></script>
<script src="<%=rootPath%>/resources/js/common/chart-data.js"></script>
<script>
    $('#calendar').datepicker({});

    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    });
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</html>
