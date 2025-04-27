package jp.co.intellisea.oc.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class CookieInterceptor  implements HandlerInterceptor {
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
        System.out.println("CookieInterceptor postHandle is executed");

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
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
            System.out.println("CookieInterceptor afterCompletion is executed");

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }
}
