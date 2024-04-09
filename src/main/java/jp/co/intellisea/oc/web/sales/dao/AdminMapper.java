package jp.co.intellisea.oc.web.sales.dao;

import jp.co.intellisea.oc.web.sales.entity.Admin
        ;

public interface AdminMapper {
    int verifyPassword(String username, String password);
}