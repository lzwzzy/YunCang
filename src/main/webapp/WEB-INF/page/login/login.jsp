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
<html>
<head>
    <title>Forms</title>
    <<%-- 静态包含 --%>
    <%@include file="/WEB-INF/page/common/head.jsp" %>
</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">登陆</div>
            <div class="panel-body">
                <form role="form" method="post">
                    <fieldset>

                        <div class="form-group ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                                <input class="form-control" id="username" placeholder="用户名" name="username" type="text"
                                       autofocus>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input class="form-control" id="password" placeholder="密码" name="password"
                                       type="password">
                            </div>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">记住我
                            </label>
                        </div>
                        <div>
                            <input id="loginBtn" type="button" class="btn btn-success" value="登陆">
                            <a href="/yuncang/register" class="btn btn-success">注册</a>
                            <span id="fail" class="glyphicon"></span>
                        </div>


                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->


<script type="text/javascript">
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
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
</body>
<%@include file="/WEB-INF/page/common/foot.jsp" %>
<script src="<%=rootPath%>/resources/js/login/login.js" type="text/javascript"></script>
</html>
