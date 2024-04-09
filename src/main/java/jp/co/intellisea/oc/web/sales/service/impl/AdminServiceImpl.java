package jp.co.intellisea.oc.web.sales.service.impl;

import jp.co.intellisea.oc.web.sales.dao.AdminMapper;
import jp.co.intellisea.oc.web.sales.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password) > 0;
    }
}
