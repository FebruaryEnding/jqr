package com.yao.jqr.controller;


import com.yao.jqr.constant.UIMsgConstant;
import com.yao.jqr.dto.result.Result;
import com.yao.jqr.util.TklUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("淘口令接口")
@RestController
@RequestMapping("api/tkl")
public class TKLController {

    @Autowired
    private TklUtils tklUtils;

    @ApiOperation("查询淘口令")
    @GetMapping("/{tkl}")
    public Result findByTKL(@PathVariable("tkl")String tkl) throws Exception {
        String s = tklUtils.parsingTKL(tkl);
        return new Result.Builder().data(s).uiMsg(UIMsgConstant.GET_SUCCESS).build();
    }
}
