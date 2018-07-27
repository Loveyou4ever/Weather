package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.AtmoPre;
import com.weather.domain.service.AtmoPreService;
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
public class AtmoPreResource {
    @Resource
    private AtmoPreService atmoPreService;

    @ResponseBody
    @RequestMapping(value = "/AtmoPreInsert",method = RequestMethod.POST)
    public Response addRecord(@RequestBody @Valid AtmoPre atmoPre,
                              BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室外）气压传感器信息录入失败");
        }else {

            Date time1 = new Date();
            System.out.println(time1);
            atmoPre.setAtmosphericPressure(atmoPre.getAtmosphericPressure());
            atmoPre.setCatchTime(time1.toString());
            atmoPreService.addRecord(atmoPre);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("atmospheric_pressure",atmoPre);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/AtmoPreFindById",method = RequestMethod.GET)
    public Response findRecordById(@Valid AtmoPre atmoPre, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室外）气压传感器信息查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            AtmoPre selectById = atmoPreService.findRecordById(atmoPre.getId());
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("atmospheric_pressure",selectById);
            response.setData(data);
            return response;
        }
    }

}

