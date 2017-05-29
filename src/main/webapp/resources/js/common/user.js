/**
 * Created by lzw on 2017/5/28.
 * 用户个人资料界面交互(公共)
 */
$(function () {
    var name, phone, email, sex, userid;
    //个人信息按钮按下
    $('#personInfo').on('click', function () {
        $.confirm({
            type: 'green',
            theme: 'dark',
            buttons: {
                edit: {
                    text: '编辑',
                    btnClass: 'btn-blue',
                    action: function () {
                        $.confirm({
                            title: '编辑个人资料',
                            theme: 'supervan',
                            content: '' +
                            '<form action="" class="formName">' +
                            '<div class="form-group">' +
                            '<label>用户名</label>' +
                            '<input type="text"  placeholder="用户名" class="name form-control" required />' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label>手机号</label>' +
                            '<input type="number"  placeholder="手机号" class="phone form-control" required />' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label>邮箱</label>' +
                            '<input type="email"  placeholder="邮箱" class="email form-control" required />' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label>性别</label>' +
                            '<select class="sex form-control" >' +
                            '<option value="男">男</option>' +
                            '<option value="女">女</option>' +
                            '</select>' +
                            '</div>' +
                            '</form>',
                            buttons: {
                                formSubmit: {
                                    text: '提交',
                                    btnClass: 'btn-blue',
                                    action: function () {
                                        var username = this.$content.find('.name').val();
                                        var userphone = this.$content.find('.phone').val();
                                        var useremail = this.$content.find('.email').val();
                                        var sex = this.$content.find('.sex').val();
                                        if (!username) {
                                            $.alert('用户名不能为空');
                                            return false;
                                        }
                                        if (!/^[a-zA-Z0-9_]+$/.test(username)) {
                                            $.alert('用户名只能包含大写、小写、数字和下划线');
                                            return false;
                                        }
                                        if (!/^.{6,18}$/.test(username)) {
                                            $.alert('用户名长度必须在6到18位之间');
                                            return false;
                                        }


                                        if (!userphone) {
                                            $.alert('手机号不能为空');
                                            return false;
                                        }
                                        if (!/^1[3|5|8]{1}[0-9]{9}$/.test(userphone)) {
                                            $.alert('手机号格式不正确');
                                            return false;
                                        }


                                        if (useremail) {
                                            if (!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(useremail)) {
                                                $.alert('邮箱格式不正确');
                                                return false;
                                            }
                                        }
                                        //验证通过,发送请求
                                        $.post('/yuncang/editPersonInfo', {
                                            username: username,
                                            userphone: userphone,
                                            useremail: useremail,
                                            sex: sex,
                                            userid: userid
                                        }, function (result) {
                                            if (result && result['success']) {
                                                //弹出提示
                                                var jc1 = $.dialog({
                                                    icon: 'glyphicon glyphicon-ok-sign',
                                                    title: '提示',
                                                    content: '修改成功',
                                                    type: 'green',
                                                    onContentReady: function () {
                                                        setTimeout(function () {
                                                            jc1.close();
                                                        }, 1000);//1秒后消失
                                                    }
                                                });
                                            } else {
                                                //弹出提示
                                                var jc2 = $.dialog({
                                                    icon: 'glyphicon glyphicon-remove-sign',
                                                    title: '提示',
                                                    content: result.errorinfo,
                                                    type: 'orange',
                                                    onContentReady: function () {
                                                        setTimeout(function () {
                                                            jc2.close();
                                                        }, 1000);//1秒后消失
                                                    }
                                                });
                                            }
                                        });


                                    }
                                },
                                cancel: {
                                    text: '取消'
                                },
                            },
                            onContentReady: function () {
                                this.$content.find('.name').val(name);
                                this.$content.find('.phone').val(phone);
                                this.$content.find('.email').val(email);
                                this.$content.find('.sex').val(sex);

                            }
                        });
                    }
                },
                cancel: {
                    text: '好的',

                }
            },
            content: function () {
                var self = this;
                return $.ajax({
                    url: '/yuncang/queryPersonInfo',
                    dataType: 'json',
                    method: 'post',
                    data: {
                        username: $('#user').text()
                    }
                }).done(function (result) {
                    if (result && result['success']) {
                        name = result.data.username;
                        phone = result.data.phone;
                        email = result.data.email;
                        sex = result.data.sex;
                        userid = result.data.userid;
                        self.setContent('' +
                            '<div class="form-group">' +
                            '<label class="large">用户名:</label>' +
                            '<span class="large" id="name">' + name + '</span>' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label class="large">手机号:</label>' +
                            '<span class="large" id="phone">' + phone + '</span>' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label class="large">邮箱:</label>' +
                            '<span class="large" id="email">' + email + '</span>' +
                            '</div>' +
                            '<div class="form-group">' +
                            '<label class="large">性别:</label>' +
                            '<span class="large" id="sex">' + sex + '</span>' +
                            '</div>');
                        self.setTitle('个人信息');
                    }
                }).fail(function () {
                    self.setContent('Something went wrong.');
                });
            }
        });
    });

    //设置按钮按下
    $('#setting').on('click', function () {
        $.confirm({
            title: '个人设置',
            content: '<p class="large">密码重置</p>',
            type: 'orange',
            theme: 'dark',
            buttons: {
                continue: {
                    text: '去更改',
                    btnClass: 'btn-orange',
                    action: function () {
                        var jc = $.confirm({
                            title: '身份确认',
                            type: 'blue',
                            content: 'url:/resources/js/common/oldPass.html',
                            buttons: {
                                sayMyName: {
                                    text: '确认',
                                    btnClass: 'btn-blue',
                                    action: function () {
                                        var input = this.$content.find('input#oldPassword').val();
                                        var errorText = this.$content.find('.text-danger');
                                        if (!input) {
                                            errorText.html('此项是必须项').slideDown(200);
                                            return false;
                                        } else {
                                            $.post('/yuncang/dologin', {
                                                username: $('#user').text(),
                                                password: input
                                            }, function (result) {
                                                if (result && result['success']) {
                                                    //弹出提示
                                                    var jc1 = $.dialog({
                                                        icon: 'glyphicon glyphicon-ok-sign',
                                                        title: '提示',
                                                        content: '认证成功',
                                                        type: 'green',
                                                        onContentReady: function () {
                                                            setTimeout(function () {
                                                                jc1.close();
                                                                $.confirm({
                                                                    title: '更改密码',
                                                                    type: 'blue',
                                                                    content: 'url:/resources/js/common/newPass.html',
                                                                    buttons: {
                                                                        sayMyName: {
                                                                            text: '确认',
                                                                            btnClass: 'btn-blue',
                                                                            action: function () {
                                                                                var newPass = this.$content.find('input#newPassword').val();
                                                                                var rePass = this.$content.find('input#rePassword').val();
                                                                                var errorText1 = this.$content.find('.text-danger1');
                                                                                var errorText2 = this.$content.find('.text-danger2');
                                                                                var errorText3 = this.$content.find('.text-danger3');
                                                                                if (!newPass) {
                                                                                    errorText1.html('此项是必须项!').slideDown(200);
                                                                                    return false;
                                                                                }
                                                                                if (!rePass) {
                                                                                    errorText2.html('此项是必须项!').slideDown(200);
                                                                                    return false;
                                                                                }
                                                                                if (newPass !== rePass) {
                                                                                    errorText3.html('两次密码不一致!').slideDown(200);
                                                                                    return false;
                                                                                }
                                                                                $.post('/yuncang/editPassword', {
                                                                                    username: $('#user').text(),
                                                                                    newPassword: rePass
                                                                                }, function (result) {
                                                                                    if (result && result['success']) {
                                                                                        //弹出提示
                                                                                        var jc1 = $.dialog({
                                                                                            icon: 'glyphicon glyphicon-ok-sign',
                                                                                            title: '提示',
                                                                                            content: '修改成功',
                                                                                            type: 'green',
                                                                                            onContentReady: function () {
                                                                                                setTimeout(function () {
                                                                                                    jc1.close();
                                                                                                }, 1000);//1秒后消失
                                                                                            }
                                                                                        });
                                                                                    } else {
                                                                                        //弹出提示
                                                                                        var jc2 = $.dialog({
                                                                                            icon: 'glyphicon glyphicon-remove-sign',
                                                                                            title: '提示',
                                                                                            content: result.errorinfo,
                                                                                            type: 'orange',
                                                                                            onContentReady: function () {
                                                                                                setTimeout(function () {
                                                                                                    jc2.close();
                                                                                                }, 1000);//1秒后消失
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });

                                                                            }
                                                                        },
                                                                        camcel: {
                                                                            text: '取消'
                                                                        }
                                                                    }
                                                                });
                                                            }, 1000);//1秒后消失
                                                        }
                                                    });

                                                } else {
                                                    //验证失败时，弹出提示
                                                    var jc2 = $.dialog({
                                                        icon: 'glyphicon glyphicon-remove-sign',
                                                        title: '提示',
                                                        content: '密码不正确',
                                                        type: 'orange',
                                                        onContentReady: function () {
                                                            setTimeout(function () {
                                                                jc2.close();
                                                            }, 1000);//1秒后消失

                                                            //重新打开身份认证框
                                                            jc.open();
                                                        }
                                                    });
                                                }
                                            })
                                        }
                                    }
                                },
                                later: {
                                    text: '取消'
                                }
                            }
                        });
                    }
                },
                cancel: {
                    text: '取消'
                }
            }
        });
    });

    //注销按钮按下
    $('#logout').on('click', function () {
        $.confirm({
            icon: 'glyphicon glyphicon-warning-sign',
            title: '警告',
            content: '确定要退出吗?退出后您需要重新输入登陆信息',
            type: 'red',
            theme: 'dark',
            autoClose: 'cancel|8000',
            buttons: {
                ok: {
                    text: '确定',
                    action: function () {
                        $.post('/yuncang/logOut', {},
                            function (result) {
                                if (result && result['success']) {
                                    //弹出提示
                                    var jc1 = $.dialog({
                                        icon: 'glyphicon glyphicon-ok-sign',
                                        title: '提示',
                                        content: '注销成功',
                                        type: 'green',
                                        onContentReady: function () {
                                            setTimeout(function () {
                                                jc1.close();
                                                window.location.href = '/yuncang/login';
                                            }, 1000);//1秒后消失
                                        }
                                    });
                                }
                            });
                    }
                },
                cancel: {
                    text: '取消'
                }
            },
        });
    })
});