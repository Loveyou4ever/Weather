package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.IlluminationIn;
import com.weather.domain.service.IlluminationInService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  16:56
 */
@Controller
public class IlluminationInResource {
    @Resource
    private IlluminationInService illuminationInService;

    @ResponseBody
    @RequestMapping(value = "/IlluminationInInesrt",method = RequestMethod.POST)
    public Response addRecord(@RequestBody @Valid IlluminationIn illuminationIn,
                              BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）光照强度传感器信息录入失败");
        }else {

            Date time1 = new Date();
            System.out.println(time1);
            illuminationIn.setIllumination(illuminationIn.getIllumination());
            illuminationIn.setCatchTime(time1.toString());
            illuminationInService.addRecord(illuminationIn);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("illumination_indoor",illuminationIn);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/IlluminationInFindById",method = RequestMethod.GET)
    public Response findRecordById(@Valid IlluminationIn illuminationIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）光照强度传感器信息查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            IlluminationIn selectById = illuminationInService.findRecordById(illuminationIn.getId());
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("illumination_indoor",selectById);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/FindAutoIlluminationIn",method = RequestMethod.GET)
    public Response findRecordAuto(@Valid IlluminationIn illuminationIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）光照传感器信息自动查询查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            IlluminationIn selectAuto = illuminationInService.findRecordAuto();
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("illumination_indoor",selectAuto);
            response.setData(data);
            return response;
        }
    }

}

