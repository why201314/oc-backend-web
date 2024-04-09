package jp.co.intellisea.oc.web.sales;

import jp.co.intellisea.oc.web.config.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyRealmTest {

    private DefaultSecurityManager securityManager;

    @Before
    public void setUp() {
        // 创建自定义 Realm 实例
        MyRealm realm = new MyRealm();

        // 设置 SecurityManager
        securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        // 将 SecurityManager 设置为静态单例
        SecurityUtils.setSecurityManager(securityManager);
    }

    @After
    public void tearDown() {
        // 清除 SecurityManager
        SecurityUtils.setSecurityManager(null);
    }

    @Test
    public void testAuthorization() {
        // 创建用户认证的 Subject
        Subject currentUser = SecurityUtils.getSubject();

        // 模拟用户登录，假设用户名为 "testUser"，密码为 "password"
        UsernamePasswordToken token = new UsernamePasswordToken("Reth", "password");
        currentUser.login(token);

        // 检查用户是否已经认证成功
        assert currentUser.isAuthenticated();

        // 打印当前用户的授权信息
        System.out.println("用户角色：" + currentUser.getPrincipal());
        System.out.println("是否拥有 admin 角色：" + currentUser.hasRole("admin"));
        System.out.println("是否拥有 admin:manage 权限：" + currentUser.isPermitted("admin:manage"));
    }
}
