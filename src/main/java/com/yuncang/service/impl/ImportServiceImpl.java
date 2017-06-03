package com.yuncang.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.imported.ImportDao;
import com.yuncang.entity.ImportBill;
import com.yuncang.service.ImportService;
import com.yuncang.util.GetTodayTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Transactional
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

    @Override
    public Map<String, Object> queryaWeekImprotInfo() {
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
        List<ImportBill> todayInfo = importDao.queryAllImportInfo(todayMorning, todayNight, true);
        for (int i = 0; i < todayInfo.size(); i++) {
            todayCount += todayInfo.get(i).getImportCount();
            todayPrice += todayInfo.get(i).getImportPrice() * todayInfo.get(i).getImportCount();
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
        List<ImportBill> _oneDayInfo = importDao.queryAllImportInfo(_oneDayMoring, _oneDayNight, true);
        for (int i = 0; i < _oneDayInfo.size(); i++) {
            _oneDayCount += _oneDayInfo.get(i).getImportCount();
            _oneDayPrice += _oneDayInfo.get(i).getImportPrice() * _oneDayInfo.get(i).getImportCount();
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
        List<ImportBill> _twoDayInfo = importDao.queryAllImportInfo(_twoDayMoring, _twoDayNight, true);
        for (int i = 0; i < _oneDayInfo.size(); i++) {
            _twoDayCount += _oneDayInfo.get(i).getImportCount();
            _twoDayPrice += _oneDayInfo.get(i).getImportPrice() * _oneDayInfo.get(i).getImportCount();
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
        List<ImportBill> _threeDayInfo = importDao.queryAllImportInfo(_threeDayMoring, _threeDayNight, true);
        for (int i = 0; i < _threeDayInfo.size(); i++) {
            _threeDayCount += _threeDayInfo.get(i).getImportCount();
            _threeDayPrice += _threeDayInfo.get(i).getImportPrice() * _threeDayInfo.get(i).getImportCount();
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
        List<ImportBill> _fourDayInfo = importDao.queryAllImportInfo(_fourDayMoring, _fourDayNight, true);
        for (int i = 0; i < _fourDayInfo.size(); i++) {
            _fourDayCount += _fourDayInfo.get(i).getImportCount();
            _fourDayPrice += _fourDayInfo.get(i).getImportPrice() * _fourDayInfo.get(i).getImportCount();
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
        List<ImportBill> _fiveDayInfo = importDao.queryAllImportInfo(_fiveDayMoring, _fiveDayNight, true);
        for (int i = 0; i < _fiveDayInfo.size(); i++) {
            _fiveDayCount += _fiveDayInfo.get(i).getImportCount();
            _fiveDayPrice += _fiveDayInfo.get(i).getImportPrice() * _fiveDayInfo.get(i).getImportCount();
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
        List<ImportBill> _sixDayInfo = importDao.queryAllImportInfo(_sixDayMoring, _sixDayNight, true);
        for (int i = 0; i < _sixDayInfo.size(); i++) {
            _sixDayCount += _sixDayInfo.get(i).getImportCount();
            _sixDayPrice += _sixDayInfo.get(i).getImportPrice() * _sixDayInfo.get(i).getImportCount();
        }
        map.put("_sixDayCount", _sixDayCount);
        map.put("_sixDayPrice", _sixDayPrice);


        return map;
    }


}
