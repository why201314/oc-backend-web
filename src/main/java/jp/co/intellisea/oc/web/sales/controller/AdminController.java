package jp.co.intellisea.oc.web.sales.controller;

import com.alibaba.fastjson.JSONObject;
import jp.co.intellisea.oc.web.sales.common.ErrorMessage;
import jp.co.intellisea.oc.web.sales.common.SuccessMessage;
import jp.co.intellisea.oc.web.sales.service.impl.AdminServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject loginStatus(HttpServletRequest req, HttpSession session,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password
                                     ){

        System.out.println(username + password);
        //AuthenticationToken token = new UsernamePasswordToken(username, password);
        Boolean res = adminService.verifyPassword(username, password);
        //System.out.println("Verification result: " + res);
        //System.out.println(token);
        if (res) {
            session.setAttribute("username", username);
            //Subject currentUser = SecurityUtils.getSubject();

            // Shiro session
            //Subject subject = SecurityUtils.getSubject();
            //Session shiroSession = subject.getSession();
            //shiroSession.setAttribute("username", username);

            //currentUser.login(token);
            //System.out.println(currentUser.hasRole("admin") + "::" + currentUser.isAuthenticated());
            return new SuccessMessage<>("登录成功").getMessage();
        } else {
            return new ErrorMessage("用户名或密码错误").getMessage();
        }

    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    public String login3(HttpServletRequest req, HttpSession session,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password
                                     ){

        System.out.println(username + password);
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        Boolean res = adminService.verifyPassword(username, password);
        //System.out.println("Verification result: " + res);
        //System.out.println(token);
        if (res) {
            session.setAttribute("username", username);
            Subject currentUser = SecurityUtils.getSubject();

            // Shiro session
            Subject subject = SecurityUtils.getSubject();
            Session shiroSession = subject.getSession();
            shiroSession.setAttribute("username", username);

            currentUser.login(token);
            System.out.println(currentUser.hasRole("admin") + "::" + currentUser.isAuthenticated());
            return "redirect:/contact";
        } else {
            return "index";
        }

        
    }

    @GetMapping("/authorizationInfo")
    public String getAuthorizationInfo() {
        // 获取当前登录用户的 Subject 对象
        Subject currentUser = SecurityUtils.getSubject();

        // 检查用户是否已经认证成功
        if (currentUser.isAuthenticated()) {
            // 获取用户的授权信息
            String authorizationInfo = currentUser.getPrincipal().toString();
            return "Authorization Info: " + authorizationInfo;
        } else {
            return "User is not authenticated.";
        }
    }


}
