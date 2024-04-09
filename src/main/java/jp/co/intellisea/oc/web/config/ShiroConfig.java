package jp.co.intellisea.oc.web.config;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        return new MyRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        // 定义过滤器链
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new FormAuthenticationFilter()); // 认证过滤器，用于处理登录跳转
        filters.put("cors", new CorsFilter()); // 添加跨域过滤器
        factoryBean.setFilters(filters);

        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        // 匿名访问 /login
        filterChainDefinitionMap.put("/login/**", "anon");
        // 管理员角色才能访问 /contact 及其后续路径
        filterChainDefinitionMap.put("/contact/**", "authc, roles[admin]");
        // 其他路径需要认证
        filterChainDefinitionMap.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 设置登录页面
        factoryBean.setLoginUrl("http://192.168.0.103:3000/login");

        return factoryBean;
    }

}
