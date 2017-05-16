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
        $('form').bootstrapValidator({
            message: 'This value is not valid',
            //当验证未通过时，提交按钮不可选
            submitButtons: 'input[type="button"]',
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
                //判断输入框是否为空
                if ((username.trim() != null || username != "" || username.trim() != undefined)
                    && (password.trim() != null || password != "" || password.trim() != undefined)) {
                    //向服务器发送ajax请求
                    $.post(login.URL.dologin(), {
                        username: $('#username').val(),
                        password: $('#password').val()
                    }, function (result) {
                        //结果判断
                        if (result && result['success']) {
                            window.location.href = login.URL.index();
                        } else {
                            //验证失败时，弹出提示
                            $('#fail').hide().html('<label class="label label-danger">用户名或密码错误!</label>').show(300);
                            //用户名密码置空
                            $('#username').val("");
                            $('#password').val("");
                            /*
                             **延时消失提示1
                             setTimeout(function () {
                             $('#fail').hide(300);
                             },2000)
                             */
                            //延时消失提示2
                            $('#fail').delay(2000).hide(300);

                        }
                    });
                } else {
                    //如果为空，直接刷新
                    window.location.reload();
                }

            });


        }
    }
}