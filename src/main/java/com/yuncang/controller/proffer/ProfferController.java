package com.yuncang.controller.proffer;

import com.yuncang.dto.PageForBootstrap;
import com.yuncang.dto.Result;
import com.yuncang.entity.ProfferBill;
import com.yuncang.service.ProfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/16.
 * 供货商信息控制层
 */
@Controller
@RequestMapping(value = "yuncang")
public class ProfferController {

    @Autowired
    private ProfferService profferService;

    @RequestMapping(value = "/proffer")
    public String proffer() {
        return "proffer";
    }

    /**
     * 供货商信息
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param sortName   排序参照列
     * @param searchText 查询条件
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/selectProfferInfo", method = RequestMethod.POST)
    public PageForBootstrap<List<ProfferBill>> profferInfo(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                           @RequestParam(required = false) String sortOrder,
                                                           @RequestParam(required = false) String sortName,
                                                           @RequestParam(required = false) String searchText) {

        try {
            //拼接排序字符串
            String sort = sortName + "." + sortOrder;
            //获取数据
            Map<String, Object> map = profferService.queryAllProffer(pageNumber, pageSize, sort, searchText);
            List<ProfferBill> rows = (List<ProfferBill>) map.get("profferBills");
            //获取总数据量
            int total = (Integer) map.get("totalCount");
            if (rows != null && total != 0) {
                //如果拿到数据,封装数据(json)返回前端->bootstrapTable要求返回的数据必须包括total,rows
                return new PageForBootstrap<List<ProfferBill>>(true, total, rows);
            } else {
                //无数据返回失败信息
                return new PageForBootstrap<List<ProfferBill>>(false, "暂无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PageForBootstrap<List<ProfferBill>>(false, "数据获取失败");
        }
    }


    /**
     * 插入供货商信息
     *
     * @param name    供货商名称
     * @param main    主营业务
     * @param person  联系人
     * @param phone   手机号
     * @param fax     传真
     * @param address 地址
     * @param remarks 备注
     * @return 是否插入成功
     */
    @ResponseBody
    @RequestMapping(value = "/insertProfferInfo", method = RequestMethod.POST)
    public Result insertProffer(@RequestParam(required = false) String name,
                                @RequestParam(required = false) String main,
                                @RequestParam(required = false) String person,
                                @RequestParam(required = false) String phone,
                                @RequestParam(required = false) String fax,
                                @RequestParam(required = false) String address,
                                @RequestParam(required = false) String remarks) {
        try {
            boolean isSuccess = profferService.insertProfferInfo(name, main, person, phone, fax, address, remarks);
            if (isSuccess) {
                return new Result(true);
            } else {
                return new Result(false, "新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败");
        }

    }

    /**
     * 更新供货商信息
     *
     * @param row   所更新行的全部信息
     * @param field 所更新列的信息
     * @return 更新是否成功
     */
    @ResponseBody
    @RequestMapping(value = "/updateProfferInfo", method = RequestMethod.POST)
    public Result updateProfferInfo(@RequestParam String row,
                                    @RequestParam String field) {
        try {
            boolean isSuccess = profferService.updateProfferInfo(row, field);
            if (isSuccess) {
                return new Result(true);
            } else {
                return new Result(false, "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新失败");
        }
    }

    /**
     * 删除供货商信息
     *
     * @param profferIdList 要删除的供货商id集合
     * @return 是否删除成功
     */
    @ResponseBody
    @RequestMapping(value = "/deleteProfferInfo", method = RequestMethod.POST)
    public Result deleteProfferInfo(@RequestParam(value = "profferIdList[]", required = false) List profferIdList) {
        try {
            boolean isSuccess = profferService.deleteProfferInfo(profferIdList);
            if (isSuccess) {
                return new Result(true);
            } else {
                return new Result(false, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
