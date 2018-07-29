package com.weather.api.resource;

import com.weather.api.respond.Response;
import com.weather.api.respond.Responses;
import com.weather.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public Response NonAuto(@RequestParam ("message") int message,com.weather.domain.model.Controller controller) {
            Date time1 = new Date();
            System.out.println(time1);
            controller.setAutoFlag(message);
            System.out.println(message);
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
        controller.setAutoFlag(10000);
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
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int flag4 = 0;
        HashMap<String, String> data = new HashMap<>();
        int auto_flag = controllerService.findRecordAuto().getAutoFlag();
        if (auto_flag == 10000){
            System.out.println("自动控制:"+auto_flag);
            if (tempOutService.findRecordAuto().getTemperature() > tempInService.findRecordAuto().getTemperature()) {
                System.out.println("Air Conditioner On!");
                flag1 = 1;
            }
            if (tempOutService.findRecordAuto().getTemperature() <= tempInService.findRecordAuto().getTemperature()) {
                System.out.println("Air Conditioner Off!");
                flag1 = 0;
            }
            if (humiOutService.findRecordAuto().getHumidity() > humiInService.findRecordAuto().getHumidity()) {
                System.out.println("Humidifier On!");
                flag2 = 1;
            }
            if (humiOutService.findRecordAuto().getHumidity() <= humiInService.findRecordAuto().getHumidity()) {
                System.out.println("Humidifier Off!");
                flag2 = 0;
            }
            if (illuminationOutService.findRecordAuto().getIllumination() > illuminationInService.findRecordAuto().getIllumination()) {
                System.out.println("Light On!");
                flag3 = 1;
            }
            if (illuminationOutService.findRecordAuto().getIllumination() <= illuminationInService.findRecordAuto().getIllumination()) {
                System.out.println("Light Off!");
                flag3 = 0;
            }
            if (((tempOutService.findRecordAuto().getTemperature() <= tempInService.findRecordAuto().getTemperature())
                    ||
                    (illuminationOutService.findRecordAuto().getIllumination() <= illuminationInService.findRecordAuto().getIllumination()))) {
                System.out.println("Curtain On!");
                flag4 = 1;
            }
            if (((tempOutService.findRecordAuto().getTemperature() > tempInService.findRecordAuto().getTemperature())
                    &&
                    (illuminationOutService.findRecordAuto().getIllumination() > illuminationInService.findRecordAuto().getIllumination()))) {
                System.out.println("Curtain Off!");
                flag4 = 0;
            }
            System.out.println(flag1);
            System.out.println(flag2);
            System.out.println(flag3);
            System.out.println(flag4);
            data.put("control_mode", String.valueOf(flag1*1000 + flag2*100 + flag3*10 +flag4));
            System.out.println(flag1*1000 + flag2*100 + flag3*10 +flag4);
        }
        else if (auto_flag <= 1111) {
            System.out.println("人工控制："+auto_flag);
            data.put("control_mode", String.valueOf(auto_flag));
        }
        return Responses.successResponse(data);
    }
}
