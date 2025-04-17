package jp.co.intellisea.oc.web.sales.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    
    @GetMapping("/index")
    public String index(HttpSession session) {

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
}
