package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> allAccount();
}