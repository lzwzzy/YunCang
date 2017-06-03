package com.yuncang.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.sale.SaleDao;
import com.yuncang.entity.SaleBill;
import com.yuncang.service.SaleService;
import com.yuncang.util.GetTodayTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by lzw on 2017/5/24.
 * 销售版块逻辑实现
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

    @Override
    public Map<String, Object> queryAllSaleInfo(int pageNumber,
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
        List<SaleBill> saleBills = saleDao.queryAllSaleInfo(pageBounds, datefrom, dateto, isHaveTime);
        //处理数据集->分页
        PageList pageList = (PageList) saleBills;
        //获取总数据数
        int totalCount = pageList.getPaginator().getTotalCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", totalCount);
        map.put("saleBills", pageList);
        return map;
    }

    @Override
    public String maxSaleId() {
        return saleDao.maxSaleId();
    }

    @Override
    @Transactional
    public boolean insertSaleInfo(String saleId, String goodsId, String saleCount, String remarks) throws Exception {
        int isSuccess = saleDao.insertSaleInfo(saleId, goodsId, saleCount, remarks);
        if (isSuccess > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, Object> queryTodaySaleInfo(long fromTime, long toTime) throws Exception {
        //格式化时间戳
        Date datefrom = new Date(fromTime * 1000);
        Date dateto = new Date(toTime * 1000);
        //获取数据
        List<SaleBill> todaySaleInfo = saleDao.queryAllSaleInfo(datefrom, dateto, true);
        int todaySaleTotalCount = 0;
        int todaySaleTotalPrice = 0;
        for (int i = 0; i < todaySaleInfo.size(); i++) {
            todaySaleTotalCount += todaySaleInfo.get(i).getSaleCount();
            todaySaleTotalPrice += todaySaleInfo.get(i).getGoodsBill().getGoodsPrice() * todaySaleInfo.get(i).getSaleCount();
        }

        Map<String, Object> todayInfo = new HashMap<String, Object>();
        todayInfo.put("todaySaleTotalCount", todaySaleTotalCount);
        todayInfo.put("todaySaleTotalPrice", todaySaleTotalPrice);
        return todayInfo;
    }

    @Override
    public Map<String, Object> queryAllSaleInfo() {
        //获取数据
        List<SaleBill> allSaleInfo = saleDao.queryAllSaleInfo();
        int SaleTotalCount = 0;
        int SaleTotalPrice = 0;
        for (int i = 0; i < allSaleInfo.size(); i++) {
            SaleTotalCount += allSaleInfo.get(i).getSaleCount();
            SaleTotalPrice += allSaleInfo.get(i).getGoodsBill().getGoodsPrice() * allSaleInfo.get(i).getSaleCount();
        }

        Map<String, Object> allInfo = new HashMap<String, Object>();
        allInfo.put("SaleTotalCount", SaleTotalCount);
        allInfo.put("SaleTotalPrice", SaleTotalPrice);
        return allInfo;
    }

    @Override
    public Map<String, Object> queryaWeekSaleInfo() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Calendar calendar = new GregorianCalendar();
        int todayCount = 0, todayPrice = 0;
        int _oneDayCount = 0, _oneDayPrice = 0;
        int _twoDayCount = 0, _twoDayPrice = 0;
        int _threeDayCount = 0, _threeDayPrice = 0;
        int _fourDayCount = 0, _fourDayPrice = 0;
        int _fiveDayCount = 0, _fiveDayPrice = 0;
        int _sixDayCount = 0, _sixDayPrice = 0;
        //获取当天的0点和24点的时间对象
        Date todayMorning = new Date(GetTodayTimeStamp.getTimesmorning() * 1000);
        Date todayNight = new Date(GetTodayTimeStamp.getTimesnight() * 1000);
        //获取当天的信息
        List<SaleBill> todayInfo = saleDao.queryAllSaleInfo(todayMorning, todayNight, true);
        for (int i = 0; i < todayInfo.size(); i++) {
            todayCount += todayInfo.get(i).getSaleCount();
            todayPrice += todayInfo.get(i).getGoodsBill().getGoodsPrice() * todayInfo.get(i).getSaleCount();
        }
        map.put("todayCount", todayCount);
        map.put("todayPrice", todayPrice);
/**********************************************************************************/
        //获取前一天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -1);
        Date _oneDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -1);
        Date _oneDayNight = calendar.getTime();
        //获取前一天的信息
        List<SaleBill> _oneDayInfo = saleDao.queryAllSaleInfo(_oneDayMoring, _oneDayNight, true);
        for (int i = 0; i < _oneDayInfo.size(); i++) {
            _oneDayCount += _oneDayInfo.get(i).getSaleCount();
            _oneDayPrice += _oneDayInfo.get(i).getGoodsBill().getGoodsPrice() * _oneDayInfo.get(i).getSaleCount();
        }
        map.put("_oneDayCount", _oneDayCount);
        map.put("_oneDayPrice", _oneDayPrice);
/**********************************************************************************/
        //获取前2天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -2);
        Date _twoDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -2);
        Date _twoDayNight = calendar.getTime();
        //获取前2天的信息
        List<SaleBill> _twoDayInfo = saleDao.queryAllSaleInfo(_twoDayMoring, _twoDayNight, true);
        for (int i = 0; i < _oneDayInfo.size(); i++) {
            _twoDayCount += _oneDayInfo.get(i).getSaleCount();
            _twoDayPrice += _oneDayInfo.get(i).getGoodsBill().getGoodsPrice() * _oneDayInfo.get(i).getSaleCount();
        }
        map.put("_twoDayCount", _twoDayCount);
        map.put("_twoDayPrice", _twoDayPrice);
/**********************************************************************************/
        //获取前3天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -3);
        Date _threeDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -3);
        Date _threeDayNight = calendar.getTime();
        //获取前3天的信息
        List<SaleBill> _threeDayInfo = saleDao.queryAllSaleInfo(_threeDayMoring, _threeDayNight, true);
        for (int i = 0; i < _threeDayInfo.size(); i++) {
            _threeDayCount += _threeDayInfo.get(i).getSaleCount();
            _threeDayPrice += _threeDayInfo.get(i).getGoodsBill().getGoodsPrice() * _threeDayInfo.get(i).getSaleCount();
        }
        map.put("_threeDayCount", _threeDayCount);
        map.put("_threeDayPrice", _threeDayPrice);
/**********************************************************************************/
        //获取前4天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -4);
        Date _fourDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -4);
        Date _fourDayNight = calendar.getTime();
        //获取前4天的信息
        List<SaleBill> _fourDayInfo = saleDao.queryAllSaleInfo(_fourDayMoring, _fourDayNight, true);
        for (int i = 0; i < _fourDayInfo.size(); i++) {
            _fourDayCount += _fourDayInfo.get(i).getSaleCount();
            _fourDayPrice += _fourDayInfo.get(i).getGoodsBill().getGoodsPrice() * _fourDayInfo.get(i).getSaleCount();
        }
        map.put("_fourDayCount", _fourDayCount);
        map.put("_fourDayPrice", _fourDayPrice);
/**********************************************************************************/
        //获取前5天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -5);
        Date _fiveDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -5);
        Date _fiveDayNight = calendar.getTime();
        //获取前5天的信息
        List<SaleBill> _fiveDayInfo = saleDao.queryAllSaleInfo(_fiveDayMoring, _fiveDayNight, true);
        for (int i = 0; i < _fiveDayInfo.size(); i++) {
            _fiveDayCount += _fiveDayInfo.get(i).getSaleCount();
            _fiveDayPrice += _fiveDayInfo.get(i).getGoodsBill().getGoodsPrice() * _fiveDayInfo.get(i).getSaleCount();
        }
        map.put("_fiveDayCount", _fiveDayCount);
        map.put("_fiveDayPrice", _fiveDayPrice);
/**********************************************************************************/
        //获取前6天的0点和24点的时间对象
        calendar.setTime(todayMorning);
        calendar.add(calendar.DATE, -6);
        Date _sixDayMoring = calendar.getTime();
        calendar.setTime(todayNight);
        calendar.add(calendar.DATE, -6);
        Date _sixDayNight = calendar.getTime();
        //获取前6天的信息
        List<SaleBill> _sixDayInfo = saleDao.queryAllSaleInfo(_sixDayMoring, _sixDayNight, true);
        for (int i = 0; i < _sixDayInfo.size(); i++) {
            _sixDayCount += _sixDayInfo.get(i).getSaleCount();
            _sixDayPrice += _sixDayInfo.get(i).getGoodsBill().getGoodsPrice() * _sixDayInfo.get(i).getSaleCount();
        }
        map.put("_sixDayCount", _sixDayCount);
        map.put("_sixDayPrice", _sixDayPrice);


        return map;
    }
}
