<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/15
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String rootPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>

    <title>供货商管理</title>
    <%-- 静态包含 --%>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
    <%-- 表格 --%>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.css" rel="stylesheet">
    <%-- 下拉菜单 --%>
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css" rel="stylesheet">
    <%-- 行内编辑 --%>
    <link href="https://cdn.bootcss.com/x-editable/1.5.1/bootstrap3-editable/css/bootstrap-editable.css"
          rel="stylesheet">
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
        <li><a href="/yuncang/sale"><span class="glyphicon glyphicon-tag"></span> 销售</a></li>
        <li class="parent"><a href="#"><span class="glyphicon glyphicon-folder-close"></span> 仓库<span
                data-toggle="collapse" href="#sub-item-1"
                class="icon pull-right"><em
                class="glyphicon glyphicon-s glyphicon-plus"></em></span></a>
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="/yuncang/goods">
                        <span class="glyphicon glyphicon-share-alt"></span> 商品管理
                    </a>
                </li>
                <li>
                    <a class="" href="/yuncang/proffer">
                        <span class="glyphicon glyphicon-share-alt"></span> 供货商管理
                    </a>
                </li>
            </ul>
        </li>
        <li><a href="/yuncang/maney"><span class="glyphicon glyphicon-usd"></span> 资金</a></li>
        <li><a href="/yuncang/chart"><span class="glyphicon glyphicon-list-alt"></span> 报表</a></li>
        <li class="parent ">
            <a href="#">
                <span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-2"
                                                                              class="icon pull-right"><em
                    class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-2">
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
            <li class="active">后台管理</li>
            <li class="active">供货商管理</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">供货商信息</h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">供货商信息</div>
                <div class="panel-body">
                    <div id="toolbar" class="btn-group">
                        <button id="btn_add" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                        </button>
                        <button id="btn_edit" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                        </button>
                        <button id="btn_delete" type="button" class="btn btn-default" disabled>
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                    </div>
                    <table id="table" data-row-style="rowStyle">
                    </table>
                </div>
            </div>
        </div><!-- /.col-->
    </div><!-- /.row -->
    <div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新增供货商</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="add_form">
                        <div class="form-group">
                            <label for="profferName" class="col-sm-2 control-label">供货商:</label>
                            <div class="col-sm-6">
                                <input name="profferName" type="text" class="form-control" id="profferName"
                                       placeholder="供货商">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mainBusiness" class="col-sm-2 control-label">主营业务:</label>
                            <div class="col-sm-6">
                                <input name="mainBusiness" type="text" class="form-control" id="mainBusiness"
                                       placeholder="主营业务">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contactPerson" class="col-sm-2 control-label">联系人:</label>
                            <div class="col-sm-6">
                                <input name="contactPerson" type="text" class="form-control" id="contactPerson"
                                       placeholder="联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contactPhone" class="col-sm-2 control-label">联系电话:</label>
                            <div class="col-sm-6">
                                <input name="contactPhone" type="number" class="form-control" id="contactPhone"
                                       placeholder="手机号/固定电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="profferFax" class="col-sm-2 control-label">传真:</label>
                            <div class="col-sm-6">
                                <input name="profferFax" type="text" class="form-control" id="profferFax"
                                       placeholder="传真号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="profferAddress" class="col-sm-2 control-label">地址:</label>
                            <div class="col-sm-6">
                                <input name="profferAddress" type="text" class="form-control" id="profferAddress"
                                       placeholder="地址信息">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="remark" class="col-sm-2 control-label">备注</label>
                            <div class="col-sm-6">
                                <textarea name="remark" class="form-control" id="remark"
                                          placeholder="请输入备注"></textarea>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="btn_submit">添加</button>
                    </div>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div><!--/.main-->


</body>
<%@include file="common/foot.jsp" %>
<%-- 行内修改插件 --%>
<script src="https://cdn.bootcss.com/x-editable/1.5.1/bootstrap3-editable/js/bootstrap-editable.js"></script>
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
<%-- bootstrapTable 表内编辑插件 --%>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.js"></script>
<script src="<%=rootPath%>/resources/js/proffer/proffer.js" type="text/javascript"></script>
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
