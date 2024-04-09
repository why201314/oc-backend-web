package jp.co.intellisea.oc.web.sales.controller;

import com.alibaba.fastjson.JSONObject;
import jp.co.intellisea.oc.web.sales.common.ErrorMessage;
import jp.co.intellisea.oc.web.sales.common.SuccessMessage;
import jp.co.intellisea.oc.web.sales.entity.Employee;
import jp.co.intellisea.oc.web.sales.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public JSONObject addEmployee(HttpServletRequest req,
                                 @RequestParam("id") Integer employeeId,
                                 @RequestParam("name") String name,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("code") Integer employeeCode,
                                 @RequestParam("duty") String duty
    ){
        Employee employee = new Employee();
        employee.setEmployeeCode(employeeCode);
        employee.setEmployeeId(employeeId);
        employee.setName(name);
        employee.setMail(mail);
        employee.setDuty(duty);
        boolean res = employeeService.addEmployee(employee);
        if(res)
            return new SuccessMessage("adding successful!", true).getMessage();
        return new ErrorMessage("adding error.").getMessage();
    }
}