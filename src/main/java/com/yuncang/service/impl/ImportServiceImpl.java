package com.yuncang.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.imported.ImportDao;
import com.yuncang.entity.ImportBill;
import com.yuncang.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/20.
 * 采购页逻辑实现
 */
@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private ImportDao importDao;

    @Override
    public Map<String, Object> queryAllImportInfo(int pageNumber,
                                                  int pageSize,
                                                  String sortOrder,
                                                  long fromTime,
                                                  long toTime) throws Exception {
        //在pageBounds构造方法中传入参数，实现分页
        PageBounds pageBounds = new PageBounds(pageNumber, pageSize, Order.formString(sortOrder));
        //调用Dao层方法获取数据集
        List<ImportBill> importBills = importDao.queryAllImportInfo(pageBounds, fromTime, toTime);
        //处理数据集->分页
        PageList pageList = (PageList) importBills;
        //获取总数据数
        int totalCount = pageList.getPaginator().getTotalCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", totalCount);
        map.put("importBills", pageList);
        return map;
    }

    @Override
    public String maxImportId() {
        String maxImportId = importDao.maxImportId();
        return maxImportId;
    }

    @Override
    public boolean insertImportInfo(String importId, String goodsId, String profferId, String importPrice, String importCount, String remarks) throws Exception {
        int isSuccess = importDao.insertImportInfo(importId, goodsId, profferId, importPrice, importCount, remarks);
        if (isSuccess > 0) {
            return true;
        } else {
            return false;
        }
    }
}
