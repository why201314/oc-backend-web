package jp.co.intellisea.oc.web.sales.service;

import jp.co.intellisea.oc.web.sales.entity.Employee;
import jp.co.intellisea.oc.web.sales.service.impl.EmployeeServiceImpl;

import javax.annotation.Resource;

public interface EmployeeService {
    boolean addEmployee(Employee employee);

    boolean deleteEmployee(int id);
}

