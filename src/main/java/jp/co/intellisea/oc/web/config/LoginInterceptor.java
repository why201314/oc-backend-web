package jp.co.intellisea.oc.web.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false); // 不创建新 Session
        // Subject subject = SecurityUtils.getSubject();
        // Session shiroSession = subject.getSession(false);
        // shiroSession.getAttribute("username");
        // System.out.println("start login filter for" + shiroSession.getAttribute("username"));
        String[] excluedPath = new String[] {"/login","login2","/index","top"};
        List<String> excluedPathList = Arrays.asList(excluedPath);
        String uri = request.getRequestURI();
        System.out.println("getRequestURI: uri::"+ uri);
        if(excluedPathList.contains(uri)){
            System.out.println("getRequestURI: true");
            return true;
        }

        javax.servlet.http.Cookie[] cookies = request.getCookies();
        System.out.println("preHandle is executed");
        if (cookies != null) {
            for (Cookie cookie : cookies) {

                String value = cookie.getValue();
                System.out.println("Found cookie value: " + value);
                // 你可以根据 cookie 做一些认证、判断
                break;

            }
        } else {
            System.out.println("No cookies found.");
        }
    
        // Subject subject = SecurityUtils.getSubject();
        // Session shiroSession = subject.getSession();
        if(session == null) {
            System.out.println("session is null");
            response.sendRedirect("/index");
            return false;
        }
        if(session.getAttribute("username") != null){
            System.out.println("isAuthenticated: true");
            return true;
        }
        // if (subject.isAuthenticated()) {
        //     System.out.println("isAuthenticated: true");
        //     return true;
        // }
        System.out.println("isAuthenticated: false");
        response.sendRedirect("/index");
        return false;

        // System.out.println("start login filter for" + request.getRequestURI());
        // if (session != null && session.getAttribute("username") != null) {
        //     return true; // 已登录，放行
        // }

        // // 未登录，重定向到登录页或返回 401
        // System.out.println("redirect login");
        // response.sendRedirect("/login");
        // return false;
    }
     @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        String contextPath = request.getContextPath();
        String sessionId = request.getSession().getId();

        // Build cookie with attributes
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID", sessionId)
                .httpOnly(true)
                .secure(true) // Set true in production if using HTTPS
                .path(contextPath)
                .sameSite("None") // Or "None" for cross-site
                .build();
    System.out.println("postHandle is executed");

        //response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                           Object handler, Exception  ex) throws Exception {
        String contextPath = request.getContextPath();
        String sessionId = request.getSession().getId();

        // Build cookie with attributes
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID", sessionId)
                .httpOnly(true)
                .secure(true) // Set true in production if using HTTPS
                .path(contextPath)
                .sameSite("None") // Or "None" for cross-site
                .build();
            System.out.println("afterCompletion is executed");

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }
}
