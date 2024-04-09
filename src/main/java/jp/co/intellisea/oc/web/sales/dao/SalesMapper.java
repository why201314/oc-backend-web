package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.Sales;

public interface SalesMapper {
    int deleteByPrimaryKey(Integer salesId);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(Integer salesId);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}