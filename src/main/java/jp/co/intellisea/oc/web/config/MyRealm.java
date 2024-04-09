package jp.co.intellisea.oc.web.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class MyRealm extends AuthorizingRealm {

    // 重写认证方法，用于验证用户身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // 从 HttpSession 中获取管理员信息
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        String storedUsername = (String) session.getAttribute("username");
        System.out.println(storedUsername);
        // 验证用户名
        if (storedUsername != null && storedUsername.equals(username)) {
            // 这里省略密码验证，你可以根据需要自行实现
            return new SimpleAuthenticationInfo(username, upToken.getPassword(), getName());
        } else {
            throw new UnknownAccountException("用户名不存在或不匹配");
        }
    }

    // 重写授权方法，用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 添加角色和权限信息，根据需要进行配置
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("admin:manage");
        return authorizationInfo;
    }
}
