package com.xbao.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice
 * 注解作用：
 * 1.全局异常处理
 * 2.全局数据绑定
 * 3.全局数据预处理
 */
@ControllerAdvice
public class GlobalHandler {


    /**
     * 全局异常处理
     * ExceptionHandler 内获取异常并自行封装异常信息
     * @ExceptionHandler(value = MyException.class)
     * 返回前端
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");
        return mv;
    }

    /**
     * 全局数据绑定
     * @return
     */
    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        HashMap<String, Object> map = new HashMap<>();
        /*map.put("age", 99);
        map.put("gender", "男");*/
        return map;
    }

    /**
     * 全局数据预处理
     * 详细使用见（https://www.cnblogs.com/lenve/p/10748453.html）
     * @param binder
     */
    @InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }
    /*@InitBinder("a")
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }*/

}
