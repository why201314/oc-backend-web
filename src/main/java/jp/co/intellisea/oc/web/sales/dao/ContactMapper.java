package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.Contact;

import java.util.List;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactId);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer contactId);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
    List<Contact> allContact();
    List<Contact> selectByFuzzySearch(String search);
}