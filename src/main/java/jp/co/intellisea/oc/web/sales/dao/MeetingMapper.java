package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.Meeting;

public interface MeetingMapper {
    int deleteByPrimaryKey(Integer meetingId);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
}