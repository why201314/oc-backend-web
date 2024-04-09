package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.MonthlyWorkInfo;

public interface MonthlyWorkInfoMapper {
    int deleteByPrimaryKey(Integer monthlyWorkInfoId);

    int insert(MonthlyWorkInfo record);

    int insertSelective(MonthlyWorkInfo record);

    MonthlyWorkInfo selectByPrimaryKey(Integer monthlyWorkInfoId);

    int updateByPrimaryKeySelective(MonthlyWorkInfo record);

    int updateByPrimaryKey(MonthlyWorkInfo record);
}