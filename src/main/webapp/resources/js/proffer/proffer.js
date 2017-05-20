/**
 * Created by lzw on 2017/5/18.
 * 供货商页面交互逻辑
 */

$(function () {
    proffer.loadTable.init();
});
var proffer = {
    URL: {
        loadProfferTableData: function () {
            return '/yuncang/selectProfferInfo';
        },
        insertProfferInfo: function () {
            return '/yuncang/insertProfferInfo';
        },
        updateProfferInfo: function () {
            return '/yuncang/updateProfferInfo';
        },
        deleteProfferInfo: function () {
            return '/yuncang/deleteProfferInfo';
        }
    },
    //表单验证
    formcheck: function () {
        $('#add_form').bootstrapValidator({
            message: 'This value is not valid',
            //live: 'disabled',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-repeat'
            },
            fields: {
                profferName: {
                    validators: {
                        notEmpty: {
                            message: '名称不能为空'
                        }
                    }
                },
                mainBusiness: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空'
                        }
                    }
                },
                contactPerson: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空'
                        }
                    }
                },
                contactPhone: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空'
                        },
                        regexp: {
                            regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                            message: '手机号格式不正确'
                        },
                        stringLength: {
                            min: 11,
                            max: 11,
                            message: '请输入11位手机号码'
                        }
                    }
                },
                profferFax: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空'
                        },
                        regexp: {
                            regexp: /\d{3}-\d{8}|\d{4}-\d{7}/,
                            message: '传真格式不正确'
                        }
                    }
                },
                profferAddress: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空'
                        }
                    }
                }
            }
        });
    },
    //添加界面提交按钮被按下逻辑
    addFormSubmit: function () {
        var name = $('#profferName').val();
        var main = $('#mainBusiness').val();
        var person = $('#contactPerson').val();
        var phone = $('#contactPhone').val();
        var fax = $('#profferFax').val();
        var address = $('#profferAddress').val();
        var remarks = $('#remark').val();
        //获取表单验证对象
        var bootstrapValidator = $("#add_form").data('bootstrapValidator');
        //执行验证
        bootstrapValidator.validate();
        //如果验证通过...
        if (bootstrapValidator.isValid()) {
            //发送请求(表单异步提交,防止界面出现较大抖动)
            $.post(proffer.URL.insertProfferInfo(), {
                name: name,
                main: main,
                person: person,
                phone: phone,
                fax: fax,
                address: address,
                remarks: remarks
            }, function (result) {
                if (result && result['success']) {
                    //添加成功后隐藏弹出框
                    $('#add').modal('hide');
                    //弹出提示
                    var jc = $.dialog({
                        icon: 'glyphicon glyphicon-ok-sign',
                        title: '提示',
                        content: '新增成功',
                        type: 'green',
                        onContentReady: function () {
                            setTimeout(function () {
                                jc.close();
                            }, 1000);//1秒后消失
                        }
                    });
                    //刷新表格
                    setTimeout(function () {
                        $('#table').bootstrapTable('refresh');
                    }, 2000);
                    //重置表单
                    bootstrapValidator.resetForm(true);
                } else {
                    //弹出提示
                    var jc2 = $.dialog({
                        icon: 'glyphicon glyphicon-remove-sign',
                        title: '提示',
                        content: '新增失败',
                        type: 'orange',
                        onContentReady: function () {
                            setTimeout(function () {
                                jc2.close();
                            }, 1000);//1秒后消失
                        }
                    });
                }
            });
        }//Endif


    },
    //删除按钮被按下逻辑
    deleteBtnOncliced: function () {
        //获取被选中列信息
        var seleced = $('#table').bootstrapTable('getSelections');
        var profferIdList = [];
        //提取每行id值,并存放在数组中
        for (var i = 0; i < seleced.length; i++) {
            profferIdList[i] = seleced[i]['profferedId'];
        }
        //提示是否删除
        $.confirm({
            icon: 'glyphicon glyphicon-warning-sign',
            title: '警告',
            content: '确定要删除吗?',
            type: 'red',
            theme: 'dark',
            buttons: {
                ok: {
                    text: '确定(Y)',
                    keys: ['Y'],
                    action: function () {
                        //发送删除请求
                        $.post(proffer.URL.deleteProfferInfo(), {
                            profferIdList: profferIdList
                        }, function (result) {
                            if (result && result['success']) {
                                //弹出提示
                                var jc1 = $.dialog({
                                    icon: 'glyphicon glyphicon-ok-sign',
                                    title: '提示',
                                    content: '删除成功',
                                    type: 'green',
                                    onContentReady: function () {
                                        setTimeout(function () {
                                            jc1.close();
                                        }, 1000);//1秒后消失
                                    }
                                });
                                //刷新表格
                                $('#table').bootstrapTable('refresh');
                            } else {
                                //弹出提示
                                var jc2 = $.dialog({
                                    icon: 'glyphicon glyphicon-remove-sign',
                                    title: '提示',
                                    content: '删除失败',
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
                    text: '取消(N)',
                    keys: ['N']
                }
            }
        });

    },
    //初始化
    loadTable: {
        init: function () {
            $('#table').bootstrapTable({
                url: proffer.URL.loadProfferTableData(),//服务器数据的加载地址
                sidePagination: "server",               //分页方式：client客户端分页，server服务端分页（*）
                sortOrder: "desc",                      //排序方式
                sortName: 'proffered_id',               //排序列
                toolbar: '#toolbar',                    //工具栏
                pageNumber: 1,                          //初始化加载第一页，默认第一页
                pageSize: 5,                           //每页的记录行数（*）
                pageList: [10, 25, 50, 100],            //可供选择的每页的行数（*）
                height: 400,
                contentType: "application/x-www-form-urlencoded;charset=utf-8",//发送到服务器的数据编码类型
                cache: false,                           //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                method: 'post',                         //服务器数据的请求方式 'get' or 'post'
                dataType: 'json',                       //服务器返回的数据类型
                showRefresh: true,                      //显示刷新按钮
                showToggle: true,                       //是否显示 切换试图（table/card）按钮
                showColumns: true,                      //是否显示 内容列下拉框
                search: true,                           //是否启用搜索框
                searchOnEnterKey: true,                 //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
                striped: true,                          //是否显示行间隔色
                pagination: true,                       //是否显示分页（*）
                minimumCountColumns: 2,                 //最少允许的列数
                clickToSelect: false,                   //是否启用点击选中行
                queryParamsType: '',                    //设置为 'limit' 则会发送符合 RESTFul 格式的参数.
                onEditableSave: function (field, row, oldValue, $el) {//修改后的逻辑
                    //请求数据更新地址
                    $.post(proffer.URL.updateProfferInfo(), {
                        //利用工具将row(json数组)转化为json字符串->方便后台读取
                        row: JSON.stringify(row),
                        field: field
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
                            var jc2 = $.dialog({
                                icon: 'glyphicon glyphicon-remove-sign',
                                title: '提示',
                                content: '修改失败',
                                type: 'orange',
                                onContentReady: function () {
                                    setTimeout(function () {
                                        jc2.close();
                                    }, 1000);//1秒后消失
                                }
                            });
                            //刷新表格
                            $('#table').bootstrapTable('refresh');
                        }

                    });
                },
                columns: [{
                    checkbox: true,                     //首列显示checkbox
                    align: 'center'
                }, {
                    field: 'profferedId',               //列名
                    title: '编号',                       //列头显示内容
                    align: 'center',                    //数据居中显示
                    sortable: true,                     //启用排序(默认false)
                    sortName: 'proffered_id'            //排序依据(这里修改了bootstrapTable源码,为了将此数据发给后端做处理)
                }, {
                    field: 'profferedName',
                    title: '供货商',
                    align: 'center',
                    sortable: true,
                    sortName: 'proffered_name',
                    editable: {
                        type: 'text',
                        title: '供货商',
                        validate: function (value) {
                            if (!$.trim(value)) return '名称不能为空';
                        }
                    }
                }, {
                    field: 'mainBusiness',
                    title: '主营业务',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '主营业务',
                        validate: function (value) {
                            if (!$.trim(value)) return '必须有主营业务';
                        }
                    }
                }, {
                    field: 'contactPerson',
                    title: '联系人',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '名称',
                        validate: function (value) {
                            if (!$.trim(value)) return '联系人为必填项';
                        }
                    }
                }, {
                    field: 'contactPhone',
                    title: '联系电话',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '联系电话',
                        validate: function (value) {
                            if (!$.trim(value)) return '手机号不能为空';
                            if (!/^1[3|5|8]{1}[0-9]{9}$/.test(value)) return '手机号格式不正确';
                        }
                    }
                }, {
                    field: 'profferedFax',
                    title: '传真',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '传真',
                        validate: function (value) {
                            if (!$.trim(value)) return '传真号不能为空';
                            if (!/\d{3}-\d{8}|\d{4}-\d{7}/.test(value)) return '传真号格式不正确';
                        }
                    }
                }, {
                    field: 'profferedAddress',
                    title: '地址',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '地址',
                        validate: function (value) {
                            if (!$.trim(value)) return '地址不能为空';
                        }
                    }
                }, {
                    field: 'remarks',
                    title: '备注',
                    align: 'center',
                    editable: {
                        type: 'textarea',
                        title: '备注',
                        emptytext: "暂无"
                    }
                }]
            });

            //表格左上角添加按钮按下
            $('#btn_add').click(function () {
                $('#add').modal({
                    show: true,//显示弹出层
                    backdrop: 'static',//禁止位置关闭
                    keyboard: false//关闭键盘事件
                });
                //添加界面表单验证
                proffer.formcheck();
            });

            //添加界面提交按钮被按下
            $('#btn_submit').click(function () {
                //按下后逻辑
                proffer.addFormSubmit();
            });

            //当没有checkbox被选中时,删除按钮不可选
            $('#table').on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function () {
                $('#btn_delete').prop('disabled', !$('#table').bootstrapTable('getSelections').length);
            });

            //删除按钮被按下
            $('#btn_delete').click(function () {
                //按下后逻辑
                proffer.deleteBtnOncliced();
                $('#btn_delete').prop('disabled', true);
            });

            //修改按钮被按下
            $('#btn_edit').click(function () {
                $.alert({
                    icon: 'glyphicon glyphicon-info-sign',
                    title: '提示',
                    content: '请移步行内修改(表格中带有虚下划线的都可以修改)',
                    type: 'purple',
                    btnClass: 'btn-green'
                });
            });
        }
    }
};