package jp.co.intellisea.oc.web.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false); // 不创建新 Session

        if (session != null && session.getAttribute("username") != null) {
            return true; // 已登录，放行
        }

        // 未登录，重定向到登录页或返回 401
        response.sendRedirect("/login");
        return false;
    }
}
