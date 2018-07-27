package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.WindDirection;
import com.weather.domain.service.WindDirectionService;
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
public class WindDirectionResource {
    @Resource
    private WindDirectionService windDirectionService;

    @ResponseBody
    @RequestMapping(value = "/WindDirectionInsert",method = RequestMethod.POST)
    public Response addRecord(@RequestBody @Valid WindDirection windDirection,
                              BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室外）风向传感器信息录入失败");
        }else {

            Date time1 = new Date();
            System.out.println(time1);
            windDirection.setWindDirection(windDirection.getWindDirection());
            windDirection.setCatchTime(time1.toString());
            windDirectionService.addRecord(windDirection);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("wind_direction",windDirection);
            response.setData(data);
            return response;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/WindDirectionFindById",method = RequestMethod.GET)
    public Response findRecordById(@Valid WindDirection windDirection, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Responses.errorResponse("（室外）风向传感器信息查询失败");
        }else {
            //查询语句的写法：一定要在声明对象时把值直接赋进去
            WindDirection selectById = windDirectionService.findRecordById(windDirection.getId());
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("wind_direction",selectById);
            response.setData(data);
            return response;
        }
    }

}

