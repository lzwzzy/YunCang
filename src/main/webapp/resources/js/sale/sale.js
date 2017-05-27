/**
 * Created by lzw on 2017/5/24.
 * 销售界面交互
 */
$(function () {
    sale.loadTable.init();
});

var sale = {
    URL: {
        loadSaleTableData: function () {
            return '/yuncang/selectSaleInfo';
        },
        newSaleForm: function () {
            return '/yuncang/newSaleForm';
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
                saleCount: {
                    validators: {

                        notEmpty: {
                            message: '出货数量不能为空'
                        },
                        regexp: {
                            regexp: /^[1-9]\d*$/,
                            message: '出货数量必须是正整数'
                        }
                    }
                }
            }
        });
    },
    //添加界面提交按钮被按下逻辑
    addFormSubmit: function () {
        var goodsId = $('#goodsName').val();
        var saleCount = $('#saleCount').val();
        var remarks = $('#remark').val();
        //获取表单验证对象
        var bootstrapValidator = $("#add_form").data('bootstrapValidator');
        //执行验证
        bootstrapValidator.validate();
        //如果验证通过...
        if (bootstrapValidator.isValid()) {
            $.confirm({
                icon: 'glyphicon glyphicon-info-sign',
                title: '提示',
                content: '这个操作需向商家收款,请注意收款',
                type: 'blue',
                theme: 'dark',
                buttons: {
                    continue: {
                        text: '继续',
                        action: function () {
                            //TODO 跳到收款界面...
                            //发送请求(表单异步提交,防止界面出现较大抖动)
                            $.post(sale.URL.newSaleForm(), {
                                goodsId: goodsId,
                                saleCount: saleCount,
                                remarks: remarks
                            }, function (result) {
                                if (result && result['success']) {
                                    //弹出提示
                                    var jc = $.dialog({
                                        icon: 'glyphicon glyphicon-ok-sign',
                                        title: '提示',
                                        content: '出货成功',
                                        type: 'green',
                                        onContentReady: function () {
                                            setTimeout(function () {
                                                jc.close();
                                            }, 1000);//1秒后消失
                                        }
                                    });
                                    //1秒后刷新页面
                                    setTimeout(function () {
                                        window.location.reload();
                                    }, 1000);
                                } else {
                                    //弹出提示
                                    var jc2 = $.dialog({
                                        icon: 'glyphicon glyphicon-remove-sign',
                                        title: '提示',
                                        content: result['errorinfo'],
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
                        text: '放弃'
                    }
                }
            });
        }//Endif


    },
    loadTable: {
        init: function () {
            var from = null;
            var to = null;
            $('#table').bootstrapTable({
                url: sale.URL.loadSaleTableData(),//服务器数据的加载地址
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                sortOrder: "desc",                  //排序方式
                sortName: 'sale_id',               //排序列
                toolbar: '#toolbar',                //工具栏
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
                search: false,                       //是否启用搜索框
                searchOnEnterKey: true,             //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
                striped: true,                      //是否显示行间隔色
                pagination: true,                   //是否显示分页（*）
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: false,                //是否启用点击选中行
                queryParamsType: '',                //设置为 'limit' 则会发送符合 RESTFul 格式的参数.
                queryParams: function (params) {
                    var temp = {
                        pageSize: params.pageSize,
                        pageNumber: params.pageNumber,
                        searchText: params.searchText,
                        sortName: params.sortName,
                        sortOrder: params.sortOrder,
                        fromTime: from,
                        toTime: to
                    };
                    return temp;
                },
                columns: [{
                    field: 'saleId',      //列名
                    title: '流水号',         //列头显示内容
                    align: 'center',      //数据居中显示
                    sortable: true,       //启用排序(默认false)
                    sortName: 'sale_id'  //排序依据(这里修改了bootstrapTable源码,为了将此数据发给后端做处理)
                }, {
                    field: 'goodsBill.goodsName',
                    title: '商品',
                    align: 'center'
                }, {
                    field: 'goodsBill.goodsPrice',
                    title: '单价(售价)',
                    align: 'center',
                    sortable: true,
                    sortName: 'goods_price'
                }, {
                    field: 'saleCount',
                    title: '数量',
                    align: 'center'
                },  {
                    field: 'saleTime',
                    title: '售出时间',
                    align: 'center',
                    sortable: true,
                    sortName: 'sale_time',
                    formatter: function (value, row, index) {//数据格式化
                        //格式化时间（后端传来的是毫秒）
                        return moment(value).format('LLL');
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
            //时间选择器中文包导入
            Flatpickr.localize(Flatpickr.l10ns.zh);
            flatpickr(".date");
            //启动时间选择器
            $('#date_from').flatpickr({
                enableTime: true,
                disableMobile: true,
                utc: true
            });
            $('#date_to').flatpickr({
                enableTime: true,
                disableMobile: true,
                utc: true
            });

            //查询按钮按下
            $('#btn_query').click(function () {
                from = moment($('#date_from').val(), "YYYY-MM-DD HH:mm:ss").format('X');
                to = moment($('#date_to').val(), "YYYY-MM-DD HH:mm:ss").format('X');
                var i = $('#date_from').data();
                console.log(i);
                //刷新表格
                $('#table').bootstrapTable('refresh');
                $('#table').bootstrapTable('resetView');
            });
            //采购表单验证
            sale.formcheck();
            //提交按钮按下
            $('#btn_submit').click(function () {
                sale.addFormSubmit();
            });
        }
    }
};