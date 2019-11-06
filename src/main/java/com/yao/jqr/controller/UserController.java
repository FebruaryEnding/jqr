package com.yao.jqr.controller;

import com.yao.jqr.constant.UIMsgConstant;
import com.yao.jqr.dto.query.UserQuery;
import com.yao.jqr.dto.result.PageResult;
import com.yao.jqr.dto.result.Result;
import com.yao.jqr.dto.request.UserRequestDTO;
import com.yao.jqr.dto.response.UserResponseDTO;
import com.yao.jqr.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户接口")
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public Result findOne(@PathVariable("id")String id){
        UserResponseDTO responseDTO = userService.findById(id);
        return new Result.Builder().data(responseDTO).uiMsg(UIMsgConstant.GET_SUCCESS).build();
    }


    @ApiOperation("分页多条件查询")
    @GetMapping("")
    public Result pageQuery(UserQuery query){
        PageResult pageResult = userService.pageQuery(query);
        return new Result.Builder().data(pageResult).uiMsg(UIMsgConstant.GET_SUCCESS).build();
    }

}
