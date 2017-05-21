package com.yuncang.dao.proffer;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.ProfferBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lzw on 2017/5/12.
 * 供货商持久层代码
 */
public interface ProfferDao {
    /**
     * 根据查询条件查询供货商信息
     *
     * @param pageBounds 分页信息
     * @param searchText 搜索条件
     * @return 符合条件的对象集合
     * @throws Exception
     */
    List<ProfferBill> queryAllProffer(@Param("pageBounds") PageBounds pageBounds,
                                      @Param("searchText") String searchText) throws Exception;


    /**
     * 插入供货商信息
     *
     * @param profferedName    供货商名称
     * @param mainBusiness     主营业务
     * @param contactPerson    联系人
     * @param contactPhone     联系电话
     * @param profferedFax     传真
     * @param profferedAddress 地址
     * @param remarks          备注
     * @return 受影响行数
     * @throws Exception
     */
    int insertIntoProfferBill(
            @Param("profferedName") String profferedName,
            @Param("mainBusiness") String mainBusiness,
            @Param("contactPerson") String contactPerson,
            @Param("contactPhone") String contactPhone,
            @Param("profferedFax") String profferedFax,
            @Param("profferedAddress") String profferedAddress,
            @Param("remarks") String remarks) throws Exception;

    int updateProfferBill(@Param("profferBill") ProfferBill profferBill,
                          @Param("field") String field)throws Exception;


    /**
     * 删除供货商信息
     * @param profferIdList 供货商id集合
     * @return 受影响行数
     * @throws Exception
     */
    int deleteProfferBill(List profferIdList)throws Exception;


    List<ProfferBill> queryAllProffer();

}
