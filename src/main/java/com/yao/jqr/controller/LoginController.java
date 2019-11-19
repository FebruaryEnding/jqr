package com.yao.jqr.controller;

import com.yao.jqr.constant.UIMsgConstant;
import com.yao.jqr.dto.request.LoginDTO;
import com.yao.jqr.dto.request.UserRequestDTO;
import com.yao.jqr.dto.result.Result;
import com.yao.jqr.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("登录")
@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginDTO.getUserName(), loginDTO.getPassword());
        subject.login(usernamePasswordToken);
        return new Result.Builder().success(true).uiMsg("登录成功").build();
    }

    @ApiOperation("注册")
    @PostMapping("/regest")
    public Result regest(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        userService.regest(userRequestDTO);
        return new Result.Builder().uiMsg(UIMsgConstant.OPERATE_SUCCESS).build();
    }

}
