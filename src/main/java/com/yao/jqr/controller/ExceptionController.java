package com.yao.jqr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.yao.jqr.constant.Code;
import com.yao.jqr.dto.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "com.yao.jqr")
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultException(Exception e) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView fv = new FastJsonJsonView();
        Result result = new Result.Builder().code(Code.INTERNAL_SERVER_ERROR.getCode()).success(false).uiMsg("出错了").msg(e.getMessage()).build();
        JSONObject object = (JSONObject) JSON.toJSON(result);
        fv.setAttributesMap(object);
        mv.setView(fv);
        return mv;
    }
}
