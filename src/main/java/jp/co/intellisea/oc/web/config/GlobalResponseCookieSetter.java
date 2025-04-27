package jp.co.intellisea.oc.web.config;

import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseCookieSetter implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true; // Apply to all responses
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest) {
            HttpSession session = ((ServletServerHttpRequest) request).getServletRequest().getSession(false); // false = don't create new session
            if (session != null) {
                ResponseCookie cookie = ResponseCookie.from("JSESSIONID", session.getId())
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("None")
                .build();

                response.getHeaders().add(HttpHeaders.SET_COOKIE, cookie.toString());
                System.out.println("Session attribute: JSESSIONID" );
            }
        }
        


        return body;
    }
}
