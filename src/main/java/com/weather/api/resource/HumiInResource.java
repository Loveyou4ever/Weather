package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.HumiIn;
import com.weather.domain.service.HumiInService;
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
public class HumiInResource {
    @Resource
    private HumiInService humiInService;

    @ResponseBody
    @RequestMapping(value = "/InsertHumiIn",method = RequestMethod.POST)
    public Response addRecord(@RequestBody @Valid HumiIn humiIn,
                              BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）湿度传感器信息录入失败");
        }else {

            Date time1 = new Date();
            System.out.println(time1);
            humiIn.setHumidity(humiIn.getHumidity());
            humiIn.setCatchTime(time1.toString());
            humiInService.addRecord(humiIn);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("humidity_indoor",humiIn);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/FindByIdHumiIn",method = RequestMethod.GET)
    public Response findRecordById(@Valid HumiIn humiIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）湿度传感器信息查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            HumiIn selectById = humiInService.findRecordById(humiIn.getId());
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("humidity_indoor",selectById);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/FindAutoHumiIn",method = RequestMethod.GET)
    public Response findRecordAuto(@Valid HumiIn humiIn, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室内）湿度传感器信息自动查询查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            HumiIn selectAuto = humiInService.findRecordAuto();
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("humidity_indoor",selectAuto);
            response.setData(data);
            return response;
        }
    }

}

