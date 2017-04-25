/**
 * Created by lzw on 2017/4/23.
 */
$(function () {
   register.submit.init();
});
var register={
    URL: {
        isExist: function () {
            return '/yuncang/isExit';
        }

    },
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
                            url: register.URL.isExist(),
                            type: 'GET',
                            delay: 2000,
                            meaage: '手机号已存在'
                        },
                        regexp: {
                            regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                            message: '请输入正确的手机号码'
                        }
                    }
                }
            }
        });
    },
    submit:{
        init: function () {
            register.formcheck();
        }
    }
};