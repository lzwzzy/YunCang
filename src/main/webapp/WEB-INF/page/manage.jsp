<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/15
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>商品管理</title>
    <%-- 静态包含 --%>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
    <%-- 表格 --%>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.css" rel="stylesheet">
    <%-- 下拉菜单 --%>
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css" rel="stylesheet">
    <%-- 行内编辑 --%>
    <link href="https://cdn.bootcss.com/x-editable/1.5.1/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet">
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
        <li><a href="/yuncang/index"><span class="glyphicon glyphicon-dashboard"></span> 起始页</a></li>
        <li><a href="/widgets.html"><span class="glyphicon glyphicon-th"></span> 采购</a></li>
        <li><a href="/charts.html"><span class="glyphicon glyphicon-stats"></span> 销售</a></li>
        <li class="active"><a href="/tables.html"><span class="glyphicon glyphicon-list-alt"></span> 仓库</a></li>
        <li><a href="/forms.html"><span class="glyphicon glyphicon-pencil"></span> 资金</a></li>
        <li><a href="/panels.html"><span class="glyphicon glyphicon-info-sign"></span> 报表 &amp; Panels</a></li>
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
            <li class="active">后台管理</li>
            <li class="active">商品管理</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">商品管理</h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">商品信息</div>
                <div class="panel-body">
                    <div id="toolbar" class="btn-group">
                        <button id="btn_add" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                        </button>
                        <button id="btn_edit" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                        </button>
                        <button id="btn_delete" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                    </div>
                    <table id="table" data-row-style="rowStyle">
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->
    <div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新增商品</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="goodsName" class="col-sm-2 control-label">商品名称:</label>
                            <div class="col-sm-6">
                                <input name="goodsName" type="text" class="form-control" id="goodsName"
                                       placeholder="商品名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsType" class="col-sm-2 control-label">类别:</label>
                            <div class="col-sm-6">
                                <select class="selectpicker" id="goodsType">
                                    <option value="1">手机数码</option>
                                    <option value="2">百货</option>
                                    <option value="3">图书</option>
                                    <option value="0">其它</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsPrice" class="col-sm-2 control-label">单价:</label>
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input name="goodsPrice" type="number" class="form-control" id="goodsPrice"
                                           placeholder="金额(售)">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsStock" class="col-sm-2 control-label">库存:</label>
                            <div class="col-sm-6">
                                <input name="goodsStock" type="number" class="form-control" id="goodsStock"
                                       placeholder="初始库存">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="proffer" class="col-sm-2 control-label">供货商:</label>
                            <div class="col-sm-6">
                                <select class="selectpicker" id="proffer">
                                    <option value="800002">北京供货商</option>
                                    <option value="800001">辽宁大连供货商</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="state" class="col-sm-2 control-label">状态:</label>
                            <div class="col-sm-6">
                                <select class="selectpicker" id="state">
                                    <option value="1">上架中</option>
                                    <option value="0">已下架</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="remark" class="col-sm-2 control-label">备注</label>
                            <div class="col-sm-6">
                                <textarea name="remarks" class="form-control" id="remark"
                                          placeholder="请输入备注"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" id="btn_submit" value="添加"/>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <%-- 状态弹出框 --%>
    <div id="windows_state" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
         aria-labelledby="mySmallModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title">提示</h3>
                </div>
                <div class="modal-body">
                    添加成功!
                </div>
            </div>
        </div>
    </div>
</div><!--/.main-->


<script>
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
</body>
<%@include file="common/foot.jsp" %>
<script src="https://cdn.bootcss.com/x-editable/1.5.1/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="<%=rootPath%>/resources/js/common/bootstrap-table.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/locale/zh-cn.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/i18n/defaults-zh_CN.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.js"></script>
<script src="<%=rootPath%>/resources/js/goods/goods.js" type="text/javascript"></script>
</html>
