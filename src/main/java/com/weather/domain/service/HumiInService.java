package com.weather.domain.service;

import com.weather.domain.model.HumiIn;
import com.weather.domain.model.HumiInExample;
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
public class HumiInService {
    @Resource
    private HumiInMapper humiInMapper;

    public int addRecord(HumiIn humiIn) {
        return this.humiInMapper.insert(humiIn);
    }

    public int dropRecord(Integer id){
        return this.humiInMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(HumiIn humiIn){ return this.humiInMapper.updateByPrimaryKeySelective(humiIn);}

    public HumiIn findRecordById(Integer id){
        return this.humiInMapper.selectByPrimaryKey(id);
    }

    public HumiIn findRecordAuto(){
        return this.humiInMapper.selectForHumidityIndoor();
    }

    public List<HumiIn> findRecordSelective(HumiInExample humiInExample, RowBounds rowBounds){
        return this.humiInMapper.selectByExampleWithRowbounds(humiInExample,rowBounds);
    }
}
