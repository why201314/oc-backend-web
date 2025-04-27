package jp.co.intellisea.oc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                //.allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .exposedHeaders("*");
    }

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CookieInterceptor cookieInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/contact")   // 需要拦截的路径
                .excludePathPatterns("/login","/index",  "/login2", "/logout2", "/register", "/css/**", "/js/**"); // 放行路径
       
        registry.addInterceptor(cookieInterceptor)
        .addPathPatterns("/**")   // 需要拦截的路径
        .excludePathPatterns("/register", "/css/**", "/js/**"); // 放行路径

    }
}