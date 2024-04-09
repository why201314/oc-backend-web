package jp.co.intellisea.oc.web.sales.service.impl;

import jp.co.intellisea.oc.web.sales.dao.AccountMapper;
import jp.co.intellisea.oc.web.sales.entity.Account;
import jp.co.intellisea.oc.web.sales.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> allAccount() { return accountMapper.allAccount(); }

    @Override
    public Boolean addAccount(Account account) { return  accountMapper.insert(account) > 0; }

    @Override
    public Boolean deleteAccount(Integer id) { return accountMapper.deleteByPrimaryKey(id) > 0; }

    @Override
    public Account findAccount(Integer id) { return accountMapper.selectByPrimaryKey(id); }

    @Override
    public Boolean updateAccount(Account account) { return accountMapper.updateByPrimaryKey(account) > 0; }


}
