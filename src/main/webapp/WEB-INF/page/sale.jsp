<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/15
  Time: 10:44
  To change this template use File | Settings | File Templates.
  销售界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String rootPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <title>销售</title>
    <<%-- 静态包含 --%>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
    <%-- 表格 --%>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.css" rel="stylesheet">
    <%-- 下拉菜单 --%>
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css" rel="stylesheet">
    <%-- 日期选择器插件样式 --%>
    <link href="https://cdn.bootcss.com/flatpickr/2.6.1/flatpickr.css" rel="stylesheet">
    <%--<link href="https://cdn.bootcss.com/flatpickr/2.6.1/rtl/themes/dark.rtl.css" rel="stylesheet">--%>
    <style>
        .checkbox, .radio {
            padding: 0;
            margin: 0;
        }

        .fixed-table-container .bs-checkbox .th-inner {
            padding: 8px;
        }

        .fixed-table-pagination .pagination a {
            padding: 12px 10px;
            line-height: 16px;
        }

        .pagination li {
            margin-right: 0;
        }

        .pagination li.disabled.active > a,
        .pagination li.disabled.active > span {
            color: #fff;
            background-color: #1abc9c;
        }
    </style>
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
                            class="glyphicon glyphicon-user"></span> 用户 <span class="caret"></span></a>
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
            <input type="text" class="form-control" placeholder="搜索">
        </div>
    </form>
    <ul class="nav menu">
        <li><a href="/yuncang/index"><span class="glyphicon glyphicon-home"></span> 起始页</a></li>
        <li><a href="/yuncang/import"><span class="glyphicon glyphicon-shopping-cart"></span> 采购</a></li>
        <li class="active"><a href="/yuncang/sale"><span class="glyphicon glyphicon-tag"></span> 销售</a></li>
        <li><a href="/yuncang/goods"><span class="glyphicon glyphicon-folder-close"></span> 仓库</a></li>
        <li><a href="/yuncang/maney"><span class="glyphicon glyphicon-usd"></span> 资金</a></li>
        <li><a href="/yuncang/chart"><span class="glyphicon glyphicon-list-alt"></span> 报表</a></li>
        <li class="parent ">
            <a href="#">
                <span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-1"
                                                                              class="icon pull-right"><em
                    class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
                    </a>
                </li>
            </ul>
        </li>
        <li role="presentation" class="divider"></li>
        <li><a href="login/login.jsp"><span class="glyphicon glyphicon-user"></span> 用户</a></li>
    </ul>
    <div class="attribution">Template by <a href="http://www.medialoot.com/item/lumino-admin-bootstrap-template/">Medialoot</a>
    </div>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">销售</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">销售</h1>

        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body tabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab1" data-toggle="tab">销售记录</a></li>
                        <li><a href="#tab2" data-toggle="tab">销售单</a></li>
                        <li><a href="#tab3" data-toggle="tab">销售分析</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1">
                            <h4>Tab 1</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec
                                hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a
                                tincidunt odio auctor. </p>
                        </div>
                        <div class="tab-pane fade" id="tab2">
                            <h4>Tab 2</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec
                                hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a
                                tincidunt odio auctor. </p>
                        </div>
                        <div class="tab-pane fade" id="tab3">
                            <h4>Tab 3</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec
                                hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a
                                tincidunt odio auctor. </p>
                        </div>
                    </div>
                </div>
            </div><!--/.panel-->
        </div><!--/.col-->
    </div>

</div>    <!--/.main-->


</body>
<%@include file="common/foot.jsp" %>
<%-- 日期选择器插件 --%>
<script src="https://cdn.bootcss.com/flatpickr/2.6.1/flatpickr.js"></script>
<%-- 日期选择器插件中文组件 --%>
<script src="https://cdn.bootcss.com/flatpickr/2.6.1/l10n/zh.js"></script>
<%-- bootstrapTable插件--%>
<script src="<%=rootPath%>/resources/js/common/bootstrap-table.js"></script>
<%-- bootstrapTable插件中文组件 --%>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>
<%-- 时间格式化插件 --%>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment.js"></script>
<%-- 时间格式化插件中文组件 --%>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/locale/zh-cn.js"></script>
<%-- 表单验证插件 --%>
<script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<%-- 表单验证插件中文组件 --%>
<script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"></script>
<%-- 下拉菜单插件 --%>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
<%-- 下拉菜单插件中文组件 --%>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/i18n/defaults-zh_CN.js"></script>
<script>
    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</html>
