package jp.co.intellisea.oc.web.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
@Component
public class SameSiteSessionCookieFilter implements Filter {

    private static final String SESSION_COOKIE_NAME = "JSESSIONID";
    private static final String SAME_SITE_ATTRIBUTE = "SameSite=None"; // or None/Strict

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response) {
            @Override
            public void addHeader(String name, String value) {
                System.out.println("SameSiteSessionCookieFilter::name:" + name + "value:" + value);
                if (HttpHeaders.SET_COOKIE.equalsIgnoreCase(name) && value.startsWith(SESSION_COOKIE_NAME)) {
                    // Modify the Set-Cookie to add SameSite
                    System.out.println(value + "; " + SAME_SITE_ATTRIBUTE + "; " + "Secure=true");
                    value = value + "; " + SAME_SITE_ATTRIBUTE + "; " + "Secure=true";
                }
                super.addHeader(name, value);
            }
        };

        chain.doFilter(req, wrappedResponse);
    }
}
