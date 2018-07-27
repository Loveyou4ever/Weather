package com.weather.domain.service;

import com.weather.domain.model.Controller;
import com.weather.domain.model.ControllerExample;
import com.weather.domain.model.TempIn;
import com.weather.domain.model.TempInExample;
import com.weather.infra.persistence.sql.mapper.ControllerMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/27  16:44
 */
@Service
public class ControllerService {
    @Resource
    private ControllerMapper controllerMapper;

    public int addRecord(Controller controller) {
        return this.controllerMapper.insert(controller);
    }

    public int dropRecord(Integer id){
        return this.controllerMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(Controller controller){ return this.controllerMapper.updateByPrimaryKeySelective(controller);}

    public Controller findRecordById(Integer id){
        return this.controllerMapper.selectByPrimaryKey(id);
    }

    public Controller findRecordAuto(){
        return this.controllerMapper.selectForAutoFlag();
    }

    public List<Controller> findRecordSelective(ControllerExample controllerExample, RowBounds rowBounds){
        return this.controllerMapper.selectByExampleWithRowbounds(controllerExample,rowBounds);
    }
}
