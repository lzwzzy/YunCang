package com.yuncang.service;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/18.
 * 供货商信息逻辑
 */
public interface ProfferService {
    /**
     * 查询全部供货商信息
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param searchText 搜索条件
     * @return Map中包含totalCount:总记录数
     * profferBills:某页的数据
     * @throws Exception
     */
    Map<String, Object> queryAllProffer(int pageNumber, int pageSize, String sortOrder, String searchText) throws Exception;

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
    boolean insertProfferInfo(
            String profferedName,
            String mainBusiness,
            String contactPerson,
            String contactPhone,
            String profferedFax,
            String profferedAddress,
            String remarks) throws Exception;

    /**
     * 更新供货商信息
     *
     * @param row   要更新的行的全部信息
     * @param field 要更新的列的全部信息
     * @return 是否更新成功
     * @throws Exception
     */
    boolean updateProfferInfo(String row, String field) throws Exception;

    /**
     * 删除供货商信息
     *
     * @param profferIdList 要删除的供货商的id的集合
     * @return 是否删除成功
     * @throws Exception
     */
    boolean deleteProfferInfo(List profferIdList) throws Exception;
}
