package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.WorkInfo;

public interface WorkInfoMapper {
    int deleteByPrimaryKey(Integer workInfoId);

    int insert(WorkInfo record);

    int insertSelective(WorkInfo record);

    WorkInfo selectByPrimaryKey(Integer workInfoId);

    int updateByPrimaryKeySelective(WorkInfo record);

    int updateByPrimaryKey(WorkInfo record);
}