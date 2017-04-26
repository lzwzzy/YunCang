/**
 * Created by lzw on 2017/4/23.
 */
var t = 3;
var register={
    URL: {
        isExist: function () {
            return '/yuncang/isExit';
        },
        doregister: function () {
            return '/yuncang/doregister';
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

            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-repeat'
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
                        remote: {
                            url: register.URL.isExist(),
                            type: 'GET',
                            delay: 2000,
                            message: '用户名已存在'


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
                        },
                        stringLength: {
                            min: 6,
                            max: 12,
                            message: '密码必须在6到12位之间'
                        }
                    }
                },
                repassword: {
                    validators: {
                        identical: {
                            field: 'password',
                            message: '两次密码不一致'
                        },
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                phone: {
                    validators: {
                        notEmpty: {
                            message: '手机号不能为空'
                        },
                        stringLength: {
                            min: 11,
                            max: 11,
                            message: '请输入11位手机号码'
                        },
                        remote:{
                            //每2秒向服务器发送一次请求，判断手机号是否存在
                            url: register.URL.isExist(),
                            type: 'GET',
                            delay: 2000,
                            message: '手机号已存在'
                        },
                        regexp: {
                            //手机号正则表达式(中国)
                            regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                            message: '请输入正确的手机号码'
                        }
                    }
                },
                agree: {
                    validators: {
                        notEmpty: {
                            message: '请同意用户协议'
                        }
                    }
                }
            }
        });
    },
    //延时操作
    showTime: function () {
        document.getElementById('sec').innerText = t;
        if(--t===0){
            //计时为0时跳转到登陆界面
            window.location.href= register.URL.login();
        }
    },
    submit:{
        init: function () {

            //表单验证
            register.formcheck();
            //点击提交后...
            $('#submit').click(function () {
                //获取表单内容
                var phone = $('#phone').val();
                var username = $('#username').val();
                var password = $('#password').val();
                var repassword = $('#password_confirm').val();
                var successModel = $('#successModal');
               if (phone.trim()!=0 && username.trim()!="" && password.trim()!="" && repassword!=""){
                   //发送ajax请求
                   $.post(register.URL.doregister(),{
                       //参数
                       username: username,
                       phone: phone,
                       password: password
                   },function (result) {
                       console.log('result:'+result);//TODO
                       if (result && result['success']){
                           //显示注册成功提示弹窗
                           successModel.modal({
                               show: true,//显示弹出层
                               backdrop: 'static',//禁止位置关闭
                               keyboard: false//关闭键盘事件
                           });
                           //并且在3秒后跳转到登陆页面
                           //每秒执行一次,showTime()
                           window.setInterval("register.showTime()",1000);
                       }
                   });
               }
            });
        }
    }
};