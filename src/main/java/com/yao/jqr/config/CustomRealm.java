package com.yao.jqr.config;

import com.yao.jqr.entity.UserEntity;
import com.yao.jqr.service.IUserService;
import com.yao.jqr.util.ContextUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        IUserService userService = ContextUtils.getApplicationContext().getBean(IUserService.class);
        UserEntity userEntity = userService.findByName(userName);
        if (userEntity == null) {
            throw new UnknownAccountException("登录失败：用户不存在!");
        }
        String salt = userEntity.getSalt();
        if(!userEntity.getPassword().equals(DigestUtils.md5Hex(salt + password))){
            throw new IncorrectCredentialsException("登录失败：密码错误!");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity, password, getName());
        return simpleAuthenticationInfo;
    }
}
