/**
 * Created by lzw on 2017/4/23.
 */
$(function () {
    login.check.init();
});
var login = {
    URL: {
        dologin: function () {
            return '/yuncang/dologin';
        },
        index: function () {
            return '/yuncang/index';
        },
        login: function () {
            return '/yuncang/login';
        }

    },
    //表单验证
    formcheck: function () {
        $('#login_form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '用户名长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        }

                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        });
    },
    check: {
        init: function () {

            login.formcheck();
            //如果cookie中有用户信息就可直接访问主页
            //TODO

            //登陆验证
            $('#loginBtn').click(function () {
                var username = $('#username').val();
                var password = $('#password').val();
                //获取表单验证对象
                var bootstrapValidator = $("#login_form").data('bootstrapValidator');
                //执行验证
                bootstrapValidator.validate();
                //如果验证通过...
                if (bootstrapValidator.isValid()) {
                    //向服务器发送ajax请求
                    $.post(login.URL.dologin(), {
                        username: username,
                        password: password
                    }, function (result) {
                        //结果判断
                        if (result && result['success']) {
                            var jc = $.dialog({
                                icon: 'glyphicon glyphicon-ok-sign',
                                title: '提示',
                                content: '登陆成功',
                                type: 'green',
                                onContentReady: function () {
                                    setTimeout(function () {
                                        jc.close();
                                    }, 1000);//1秒后消失
                                }
                            });
                            //判断是否点击记住我,如果点击则写入cookie
                            if ($('#remember').is(':checked')) {
                                $.cookie('username', username, {expires: 7, path: '/yuncang'});
                            }
                            setTimeout(function () {
                                window.location.href = login.URL.index();
                            }, 1500);//1.5秒后进入主界面
                        } else {
                            //验证失败时，弹出提示
                            var jc2 = $.dialog({
                                icon: 'glyphicon glyphicon-remove-sign',
                                title: '提示',
                                content: '用户名或密码错误',
                                type: 'orange',
                                onContentReady: function () {
                                    setTimeout(function () {
                                        jc2.close();
                                    }, 1000);//1秒后消失
                                }
                            });
                            //用户名密码置空
                            $('#username').val("");
                            $('#password').val("");
                        }
                    });
                }

            });


        }
    }
}