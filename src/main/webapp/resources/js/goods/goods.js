/**
 * Created by lzw on 2017/5/12.
 * goods页面操作
 */
$(function () {
    goods.loadTable.init();
});

var goods = {
    URL: {
        //查询全部信息url
        loadGoodsTableData: function () {
            return '/yuncang/selectGoodsInfo';
        },
        //插入数据url
        insertGoodsInfo: function () {
            return '/yuncang/insertGoodsInfo';
        },
        //更新数据url
        updateGoodsInfo: function () {
            return '/yuncang/updateGoodsInfo';
        },
        //删除数据url
        deleteGoodsInfo: function () {
            return '/yuncang/deleteGoodsInfo';
        }
    },
    //表单验证
    formcheck: function (submit) {
        $('form').bootstrapValidator({
            message: 'This value is not valid',
            //当验证未通过时，提交按钮不可选
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-repeat'
            },
            fields: {
                goodsName: {
                    validators: {
                        notEmpty: {
                            message: '商品名称不能为空'
                        }
                    }
                },
                goodsPrice: {
                    validators: {
                        notEmpty: {
                            message: '单价不能为空'
                        },
                        regexp: {
                            regexp: /^\d+(\.\d+)?$/,
                            message: '价格不能是负数'
                        }
                    }
                },
                goodsStock: {
                    validators: {

                        notEmpty: {
                            message: '库存不能为空'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: '库存必须是非负整数'
                        }
                    }
                },
                rmarks: {
                    validators: {
                        stringLength: {
                            max: 300,
                            message: '不能超过300字'
                        }
                    }
                }
            }
        });
    },
    //添加界面提交按钮被按下逻辑
    addFormSubmit: function () {
        var name = $('#goodsName').val();
        var type = $('#goodsType').val();
        var price = $('#goodsPrice').val();
        var stock = $('#goodsStock').val();
        var proffer = $('#proffer').val();
        var state = $('#state').val();
        var remarks = $('#remark').val();
        //发送请求
        $.post(goods.URL.insertGoodsInfo(), {
            name: name,
            type: type,
            price: price,
            stock: stock,
            proffer: proffer,
            state: state,
            remarks: remarks
        }, function (result) {
            if (result && result['success']) {
                //添加成功后隐藏弹出框
                $('#add').modal('hide');
                //弹出提示
                $('#windows_state').modal('show');
                setTimeout(function () {
                    $('#windows_state').modal('hide');
                }, 1200);//1.2秒后消失
                //刷新表格
                $('#table').bootstrapTable('refresh');
            } else {
                alert('添加失败');
            }
        });

    },
    //删除按钮被按下逻辑
    deleteBtnOncliced: function () {
        var seleced = $('#table').bootstrapTable('getSelections');
        var goodsIdList = [];
        for (var i = 0; i < seleced.length; i++) {
            goodsIdList[i] = seleced[i]['goodsId'];
        }
        console.log(goodsIdList);
        //TODO 提示是否删除
        $.post(goods.URL.deleteGoodsInfo(), {
            goodsIdList: goodsIdList
        }, function (result) {
            if (result && result['success']){
                alert("删除成功");
                //刷新表格
                $('#table').bootstrapTable('refresh');
            }else {
                alert(result['errorinfo']);
            }
        });
    },
    //初始化
    loadTable: {
        init: function () {
            $('#table').bootstrapTable({
                url: goods.URL.loadGoodsTableData(),//服务器数据的加载地址
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                sortOrder: "desc",                  //排序方式
                sortName: 'goods_id',               //排序列
                toolbar: '#toolbar',
                pageNumber: 1,                      //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                height: 400,
                contentType: "application/x-www-form-urlencoded;charset=utf-8",//发送到服务器的数据编码类型
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                method: 'post',                     //服务器数据的请求方式 'get' or 'post'
                dataType: 'json',                   //服务器返回的数据类型
                showRefresh: true,                  //显示刷新按钮
                showToggle: true,                   //是否显示 切换试图（table/card）按钮
                showColumns: true,                  //是否显示 内容列下拉框
                search: true,                       //是否启用搜索框
                searchOnEnterKey: true,             //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
                striped: true,                      //是否显示行间隔色
                pagination: true,                   //是否显示分页（*）
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: false,                //是否启用点击选中行
                queryParamsType: '',                //设置为 'limit' 则会发送符合 RESTFul 格式的参数.
                onEditableSave: function (field, row, oldValue, $el) {//修改后的逻辑
                    //请求数据更新地址
                    $.post(goods.URL.updateGoodsInfo(), {
                        //利用工具将row(json数组)转化为json字符串->方便后台读取
                        row: JSON.stringify(row),
                        field: field
                    }, function (result) {
                        if (result && result['success']) {
                            alert("修改成功");
                        } else {
                            alert("修改失败");
                            //刷新表格
                            $('#table').bootstrapTable('refresh');
                        }
                        console.log(result);
                    });
                },
                columns: [{
                    checkbox: true,//首列显示checkbox
                    align: 'center'
                }, {
                    field: 'goodsId',      //列名
                    title: '编号',         //列头显示内容
                    align: 'center',      //数据居中显示
                    sortable: true,       //启用排序(默认false)
                    sortName: 'goods_id'  //排序依据(这里修改了bootstrapTable源码,为了将此数据发给后端做处理)
                }, {
                    field: 'goodsName',
                    title: '名称',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '名称',
                        validate: function (value) {
                            if (!$.trim(value)) return '名称不能为空';
                        }
                    }
                }, {
                    field: 'goodsPrice',
                    title: '单价(售)',
                    align: 'center',
                    sortable: true,
                    sortName: 'goods_price',
                    editable: {
                        type: 'text',
                        title: '单价',
                        validate: function (value) {
                            if (!$.trim(value)) return '单价不能为空';
                            if (!/^\d+(\.\d+)?$/.test(value)) return "单价不能为负数";
                        }
                    }
                }, {
                    field: 'goodsStock',
                    title: '库存',
                    align: 'center',
                    editable: {
                        type: 'text',
                        title: '库存',
                        validate: function (value) {//字段验证
                            if (!$.trim(value)) return '库存不能为空';
                            if (!/^\d+$/.test(value)) return "库存不能为负数";
                        }
                    }
                }, {
                    field: 'goodsType',
                    title: '分类',
                    align: 'center',
                    editable: {
                        type: 'select',                          //编辑框的类型。支持text|textarea|select|date|checklist等
                        title: '分类',                            //编辑框的标题
                        source: [{value: '1', text: '手机数码'},   //编辑框内容
                            {value: '2', text: '百货'},
                            {value: '3', text: '图书'},
                            {value: '0', text: '其他'}]
                    }
                }, {
                    field: 'profferedId',
                    title: '供货商',
                    align: 'center',
                    editable: {
                        type: 'select',
                        title: '供货商',
                        source: [{value: "800001", text: "辽宁大连供货商"},
                            {value: "800002", text: "北京供货商"}]
                    }
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    align: 'center',
                    sortable: true,
                    sortName: 'create_time',
                    formatter: function (value, row, index) {//数据格式化
                        //格式化时间（后端传来的是毫秒）
                        return moment(value).format('LLL');
                    }
                }, {
                    field: 'state',
                    title: '状态',
                    align: 'center',
                    editable: {
                        type: 'select',
                        title: '状态',
                        source: [{value: "1", text: "上架中"},
                            {value: "0", text: "已下架"}]
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
                goods.formcheck();
            });

            //添加界面提交按钮被按下
            $('#btn_submit').click(function () {
                //按下后逻辑
                goods.addFormSubmit();
            });

            //删除按钮被按下
            $('#btn_delete').click(function () {
                //按下后逻辑
                goods.deleteBtnOncliced();
            })

        }
    }


}