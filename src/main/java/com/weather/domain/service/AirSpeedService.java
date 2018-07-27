package com.weather.domain.service;

import com.weather.domain.model.AirSpeed;
import com.weather.domain.model.AirSpeedExample;
import com.weather.domain.model.HumiIn;
import com.weather.domain.model.HumiInExample;
import com.weather.infra.persistence.sql.mapper.AirSpeedMapper;
import com.weather.infra.persistence.sql.mapper.HumiInMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class AirSpeedService {
    @Resource
    private AirSpeedMapper airSpeedMapper;

    public int addRecord(AirSpeed airSpeed) {
        return this.airSpeedMapper.insert(airSpeed);
    }

    public int dropRecord(Integer id){
        return this.airSpeedMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(AirSpeed airSpeed){ return this.airSpeedMapper.updateByPrimaryKeySelective(airSpeed);}

    public AirSpeed findRecordById(Integer id){
        return this.airSpeedMapper.selectByPrimaryKey(id);
    }

    public AirSpeed findRecordAuto(){
        return this.airSpeedMapper.selectForAirSpeed();
    }

    public List<AirSpeed> findRecordSelective(AirSpeedExample airSpeedExample, RowBounds rowBounds){
        return this.airSpeedMapper.selectByExampleWithRowbounds(airSpeedExample,rowBounds);
    }
}
