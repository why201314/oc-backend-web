package jp.co.intellisea.oc.web.sales.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    

    public static String getValueFromCookie(HttpServletRequest request, String key){
    
        javax.servlet.http.Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(key)){
                    return cookie.getValue();
                }
                break;
            }
        } else {
            System.out.println("No cookies found.");
        }
        return "";
        
    }

    public static Cookie getCookie(HttpServletRequest request, String key){
    
        javax.servlet.http.Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(key)){
                    return cookie;
                }
                break;
            }
        } else {
            System.out.println("No cookies found.");
        }
        return null;
        
    }
}
