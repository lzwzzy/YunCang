package com.yuncang.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.imported.ImportDao;
import com.yuncang.entity.ImportBill;
import com.yuncang.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        //设置查询标志位
        boolean isHaveTime = false;
        //格式化时间戳
        Date datefrom = new Date(fromTime * 1000);
        Date dateto = new Date(toTime * 1000);

        if (fromTime != 0 && toTime != 0) {
            isHaveTime = true;
        }
        //在pageBounds构造方法中传入参数，实现分页
        PageBounds pageBounds = new PageBounds(pageNumber, pageSize, Order.formString(sortOrder));
        //调用Dao层方法获取数据集
        List<ImportBill> importBills = importDao.queryAllImportInfo(pageBounds, datefrom, dateto, isHaveTime);
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

    @Override
    public Map<String, Object> queryAllImportInfo(long fromTime, long toTime) {

        //格式化时间戳
        Date datefrom = new Date(fromTime * 1000);
        Date dateto = new Date(toTime * 1000);
        //获取数据
        List<ImportBill> todayImportInfo = importDao.queryAllImportInfo(datefrom, dateto, true);
        int todayimportTotalCount = 0;
        int todayimportTotalPrice = 0;
        for (int i = 0; i < todayImportInfo.size(); i++) {
            todayimportTotalCount += todayImportInfo.get(i).getImportCount();
            todayimportTotalPrice += todayImportInfo.get(i).getImportPrice() * todayImportInfo.get(i).getImportCount();
        }

        Map<String, Object> todayInfo = new HashMap<String, Object>();
        todayInfo.put("todayimportTotalCount", todayimportTotalCount);
        todayInfo.put("todayimportTotalPrice", todayimportTotalPrice);
        return todayInfo;
    }

    @Override
    public Map<String, Object> queryAllImportInfo() {
        List<ImportBill> importBills = importDao.queryAllImportInfo();
        int importTotalCount = 0;
        int importTotalPrice = 0;
        for (int i = 0; i < importBills.size(); i++) {
            importTotalCount += importBills.get(i).getImportCount();
            importTotalPrice += importBills.get(i).getImportPrice() * importBills.get(i).getImportCount();
        }
        Map<String, Object> allInfo = new HashMap<String, Object>();
        allInfo.put("importTotalCount", importTotalCount);
        allInfo.put("importTotalPrice", importTotalPrice);
        return allInfo;
    }


}
