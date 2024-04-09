package jp.co.intellisea.oc.web.sales.service;

import jp.co.intellisea.oc.web.sales.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> allAccount();

    Boolean addAccount(Account account);

    Boolean deleteAccount(Integer id);

    Account findAccount(Integer id);

    Boolean updateAccount(Account account);
}
