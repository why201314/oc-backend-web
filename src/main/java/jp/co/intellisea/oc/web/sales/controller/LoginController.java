package jp.co.intellisea.oc.web.sales.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import jp.co.intellisea.oc.web.sales.service.impl.AdminServiceImpl;


@Controller
public class LoginController {
    
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/index")
    public String index(HttpSession session) {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest req, HttpSession session,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password
                                     ){
                                     
                                        return "index";
                                    }

    @RequestMapping(value = "/loginpost", method = RequestMethod.POST)
    public String loginpost(HttpServletRequest req, HttpSession session,
                                        @RequestParam("username") String username,
                                        @RequestParam("password") String password
                                        ){
                                        
                                        return "index";
                                    }

                                                                    
    @GetMapping("/api/auth/status")
    public ResponseEntity<?> checkAuth(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Not logged in");
        }
    }

    @RequestMapping(value = "/logout2")
    public String logout2(HttpServletRequest req, HttpSession session
                                        ){
                                        
                                        session.invalidate();
                                        return "index";
     }

     @RequestMapping(value = "/login2", method = RequestMethod.POST)
     public String loginStatus2(HttpServletRequest req, HttpSession session,
                                      @RequestParam("username") String username,
                                      @RequestParam("password") String password
                                      ){
          Boolean res = adminService.verifyPassword(username, password);
          System.out.println("login2" + username + password);
          if (res) {
             session.setAttribute("username", username);
             return "redirect:/contact";
         } else {
             return "index";
         }
    }
}
