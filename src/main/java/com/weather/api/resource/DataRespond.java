package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  19:32
 */
@Controller
public class DataRespond {
    @Resource
    private IlluminationInService illuminationInService;
    @Resource
    private TempInService tempInService;
    @Resource
    private TempOutService tempOutService;
    @Resource
    private HumiInService humiInService;
    @Resource
    private HumiOutService humiOutService;
    @Resource
    private IlluminationOutService illuminationOutService;
    @Resource
    private AirSpeedService airSpeedService;
    @Resource
    private AtmoPreService atmoPreService;
    @Resource
    private WindDirectionService windDirectionService;
    @Resource
    private UltravioletService ultravioletService;

    @ResponseBody
    @RequestMapping(value = "/OutdoorRespond",method = RequestMethod.GET)
    public Response OutdoorRespond() {
        //Response response = Responses.successResponse();
        HashMap<String, String> data = new HashMap<>();
        data.put("air_speed",String.valueOf(this.airSpeedService.findRecordAuto().getAirSpeed()));
        data.put("temperature_out",String.valueOf(this.tempOutService.findRecordAuto().getTemperature()));
        data.put("humidity_out",String.valueOf(this.humiOutService.findRecordAuto().getHumidity()));
        data.put("illumination_out",String.valueOf(this.illuminationOutService.findRecordAuto().getIllumination()));
        data.put("air_speed",String.valueOf(this.airSpeedService.findRecordAuto().getAirSpeed()));
        data.put("atmo_pressure",String.valueOf(this.atmoPreService.findRecordAuto().getAtmosphericPressure()));
        data.put("wind_direction",String.valueOf(this.windDirectionService.findRecordAuto().getWindDirection()));
        data.put("ultraviolet",String.valueOf(this.ultravioletService.findRecordAuto().getUltraviolet()));
        return Responses.successResponse(data);

    }
    @ResponseBody
    @RequestMapping(value = "/IndoorRespond",method = RequestMethod.GET)
    public Response IndoorRespond(){
        //Response response = Responses.successResponse();
        HashMap<String, String> data = new HashMap<>();
        data.put("temperature_in",String.valueOf(this.tempInService.findRecordAuto().getTemperature()));
        data.put("humidity_in",String.valueOf(this.humiInService.findRecordAuto().getHumidity()));
        data.put("illumination_in",String.valueOf(this.illuminationInService.findRecordAuto().getIllumination()));
        return Responses.successResponse(data);
    }
}
