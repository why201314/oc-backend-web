package jp.co.intellisea.oc.web.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jp.co.intellisea.oc.web.sales.constants.CommonConstants;
import jp.co.intellisea.oc.web.sales.utils.SessionUtils;

@Component
public class CookieSettingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000"); // 或指定域名
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {

                String value = cookie.getValue();
                System.out.println("Found cookie value: " + value);
                // 你可以根据 cookie 做一些认证、判断
                break;

            }
        } else {
            System.out.println("doFilterInternal No cookies found.");
        }
    
        // 如果是预检请求（OPTIONS请求），直接返回
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
                                        
        String[] excluedPath = new String[] {"/index","/top", "/logout2"};
        List<String> excluedPathList = Arrays.asList(excluedPath);
        String uri = request.getRequestURI();
        System.out.println("doFilterInternal getRequestURI: uri::"+ uri);
        if(excluedPathList.contains(uri)){
            filterChain.doFilter(request, response);
            System.out.println("no need for doFilterInternal");
            return ;
        }

        HttpSession session = request.getSession(false);
            // Subject subject = SecurityUtils.getSubject();
            // Session shiroSession = subject.getSession();
        
        if(session == null || session.getId() == null){
            System.out.println("session is null， sendRedirect to index");
            response.sendRedirect("/index");
            return;
        } else {

            ResponseCookie cookie = ResponseCookie.from("JSESSIONID", session.getId())
            .httpOnly(true)
            .path("/")
            .sameSite("None")
            .secure(true)
            .build();
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        }
        System.out.println("doFilterInternal is executed");

        

        filterChain.doFilter(request, response);
    }
}
