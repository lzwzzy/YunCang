package com.yuncang.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.proffer.ProfferDao;
import com.yuncang.entity.ProfferBill;
import com.yuncang.service.ProfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/18.
 * 供货商信息逻辑实现
 */
@Service
public class ProfferServiceImpl implements ProfferService {
    @Autowired
    private ProfferDao profferDao;

    @Override
    public Map<String, Object> queryAllProffer(int pageNumber, int pageSize, String sortOrder, String searchText) throws Exception {
        //在pageBounds构造方法中传入参数，实现分页
        PageBounds pageBounds = new PageBounds(pageNumber, pageSize, Order.formString(sortOrder));
        //调用Dao层方法获取数据集
        List<ProfferBill> profferBills = profferDao.queryAllProffer(pageBounds, searchText);
        //处理数据集->分页
        PageList pageList = (PageList) profferBills;
        //获取总数据数
        int totalCount = pageList.getPaginator().getTotalCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", totalCount);
        map.put("profferBills", pageList);
        return map;
    }

    @Override
    @Transactional
    public boolean insertProfferInfo(String profferedName, String mainBusiness, String contactPerson, String contactPhone, String profferedFax, String profferedAddress, String remarks) throws Exception {
        int isSuccess = profferDao.insertIntoProfferBill(profferedName, mainBusiness, contactPerson, contactPhone, profferedFax, profferedAddress, remarks);
        if (isSuccess > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateProfferInfo(String row, String field) throws Exception {
        //利用jackson将row(json字符串)转化为POJO(GoodsBill)
        ObjectMapper mapper = new ObjectMapper();
        ProfferBill profferBill = mapper.readValue(row, ProfferBill.class);
        int isSuccess = profferDao.updateProfferBill(profferBill, field);
        if (isSuccess > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    @Transactional
    public boolean deleteProfferInfo(List profferIdList) throws Exception {
        int i = profferDao.deleteProfferBill(profferIdList);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ProfferBill> queryAllProffer() {
        List<ProfferBill> profferBills = profferDao.queryAllProffer();
        return profferBills;
    }
}
