package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.TempIn;
import com.weather.domain.service.TempInService;
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
public class TempInResource {
    @Resource
    private TempInService tempInService;

    @ResponseBody
    @RequestMapping(value = "/InsertTempIn",method = RequestMethod.POST)
    public Response addRecord(@RequestBody @Valid TempIn tempIn,
                              BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）温度传感器信息录入失败");
        }else {

            Date time1 = new Date();
            System.out.println(time1);
            tempIn.setTemperature(tempIn.getTemperature());
            tempIn.setCatchTime(time1.toString());
            tempInService.addRecord(tempIn);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("temperature_indoor",tempIn);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/FindByIdTempIn",method = RequestMethod.GET)
    public Response findRecordById(@Valid TempIn tempIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）温度传感器信息查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            TempIn selectById = tempInService.findRecordById(tempIn.getId());
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("temperature_indoor",selectById);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/FindAutoTempIn",method = RequestMethod.GET)
    public Response findRecordAuto(@Valid TempIn tempIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）温度传感器信息自动查询查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            TempIn selectAuto = tempInService.findRecordAuto();
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("temperature_indoor",selectAuto);
            response.setData(data);
            return response;
        }
    }

}

