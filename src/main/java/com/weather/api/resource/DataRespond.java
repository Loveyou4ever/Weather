package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.model.AirSpeed;
import com.weather.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.Date;
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
    @Resource
    private ControllerService controllerService;

    @ResponseBody
    @RequestMapping(value = "/Respond",method = RequestMethod.GET)
    public Response Respond() {
        HashMap<String, String> data = new HashMap<>();
        data.put("air_speed",String.valueOf(this.airSpeedService.findRecordAuto().getAirSpeed()));
        data.put("temperature_out",String.valueOf(this.tempOutService.findRecordAuto().getTemperature()));
        data.put("humidity_out",String.valueOf(this.humiOutService.findRecordAuto().getHumidity()));
        data.put("illumination_out",String.valueOf(this.illuminationOutService.findRecordAuto().getIllumination()));
        data.put("atmo_pressure",String.valueOf(this.atmoPreService.findRecordAuto().getAtmosphericPressure()));
        data.put("wind_direction",String.valueOf(this.windDirectionService.findRecordAuto().getWindDirection()));
        data.put("ultraviolet",String.valueOf(this.ultravioletService.findRecordAuto().getUltraviolet()));
        data.put("temperature_in",String.valueOf(this.tempInService.findRecordAuto().getTemperature()));
        data.put("humidity_in",String.valueOf(this.humiInService.findRecordAuto().getHumidity()));
        data.put("illumination_in",String.valueOf(this.illuminationInService.findRecordAuto().getIllumination()));
        return Responses.successResponse(data);

    }

    @ResponseBody
    @RequestMapping(value = "/NonAuto",method = RequestMethod.GET)
    public Response NonAuto(com.weather.domain.model.Controller controller) {
            Date time1 = new Date();
            System.out.println(time1);
            controller.setAutoFlag(0);
            controller.setOperationTime(time1.toString());
            controllerService.addRecord(controller);
            Response response = Responses.successResponse();
            HashMap<String, Object> data = new HashMap<>();
            data.put("controller", controller);
            response.setData(data);
            return response;
    }

    @ResponseBody
    @RequestMapping(value = "/Auto",method = RequestMethod.GET)
    public Response Auto(com.weather.domain.model.Controller controller) {
        Date time1 = new Date();
        System.out.println(time1);
        controller.setAutoFlag(1);
        controller.setOperationTime(time1.toString());
        controllerService.addRecord(controller);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("controller", controller);
        response.setData(data);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/Raspberry",method = RequestMethod.GET)
    public Response PacketToRaspberry(){
        HashMap<String, String> data = new HashMap<>();
        int auto_flag = controllerService.findRecordAuto().getAutoFlag();
        if (auto_flag == 0){
            data.put("mode",String.valueOf(auto_flag));
            System.out.println("人工控制");
        }
        else if (auto_flag == 1) {
            data.put("mode", String.valueOf(auto_flag));
            System.out.println("自动控制");
            if (tempOutService.findRecordAuto().getTemperature() > tempInService.findRecordAuto().getTemperature()) {
                System.out.println("Air Conditioner On!");
                data.put("code_temperature", String.valueOf(1001));
            }
            if (tempOutService.findRecordAuto().getTemperature() <= tempInService.findRecordAuto().getTemperature()) {
                System.out.println("Air Conditioner Off!");
                data.put("code_temperature", String.valueOf(1002));
            }
            if (humiOutService.findRecordAuto().getHumidity() > humiInService.findRecordAuto().getHumidity()) {
                System.out.println("Humidifier On!");
                data.put("code_humidity", String.valueOf(1003));
            }
            if (humiOutService.findRecordAuto().getHumidity() <= humiInService.findRecordAuto().getHumidity()) {
                System.out.println("Humidifier Off!");
                data.put("code_humidity", String.valueOf(1004));
            }
            if (illuminationOutService.findRecordAuto().getIllumination() > illuminationInService.findRecordAuto().getIllumination()) {
                System.out.println("Light On!");
                data.put("code_illumination", String.valueOf(1005));
            }
            if (illuminationOutService.findRecordAuto().getIllumination() <= illuminationInService.findRecordAuto().getIllumination()) {
                System.out.println("Light Off!");
                data.put("code_illumination", String.valueOf(1006));
            }
            if (((tempOutService.findRecordAuto().getTemperature() <= tempInService.findRecordAuto().getTemperature())
                    ||
                    (illuminationOutService.findRecordAuto().getIllumination() <= illuminationInService.findRecordAuto().getIllumination()))) {
                System.out.println("Windows On!");
                data.put("code_motor", String.valueOf(1007));
            }
            if (((tempOutService.findRecordAuto().getTemperature() > tempInService.findRecordAuto().getTemperature())
                    &&
                    (illuminationOutService.findRecordAuto().getIllumination() > illuminationInService.findRecordAuto().getIllumination()))) {
                System.out.println("Windows Off!");
                data.put("code_motor", String.valueOf(1008));
            }
        }
        return Responses.successResponse(data);
    }
}
