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
<html>
<head>
    <title>Create Account</title>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
    <link href="/resources/css/templatemo_style.css" rel="stylesheet">
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">Create Account</h1>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-create-account templatemo-container" role="form" method="post">
            <div class="form-inner">

                <div class="form-group">
                    <div class="col-md-6">

                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input name="phone" type="text" class="form-control" id="phone" placeholder="输入手机号">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="username" type="text" class="form-control" id="username" placeholder="输入用户名">
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-6">

                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input name="password" type="password" class="form-control" id="password"
                                   placeholder="请输入密码">
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input name="repassword" type="password" class="form-control" id="password_confirm"
                                   placeholder="再次输入">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label><input type="checkbox" id="agree" name="agree">我同意 <a href="javascript:;"
                                                                                     data-toggle="modal"
                                                                                     data-target="#templatemo_modal">用户协议</a>
                            以及 <a href="#">用户须知.</a></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="submit" value="Submit" id="submit" class="btn btn-success">
                        <div class="pull-right" class="col-md-12">
                            <label>
                                已有账号<a href="/yuncang/login">返回登陆</a>
                            </label>
                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
            </div>
            <div class="modal-body">
                <p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5
                    Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum.
                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur
                    ac, vestibulum at eros.</p>
                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue
                    laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent
                    commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper
                    nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
                    dapibus ac facilisis in, egestas eget quam.</p>
                <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel
                    scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor
                    auctor.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

</body>
<script src="<%=rootPath %>/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"></script>

<script src="<%=rootPath%>/resources/js/register/register.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        register.submit.init();
    });
</script>
</html>
