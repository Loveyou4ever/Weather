package com.weather.domain.service;

import com.weather.domain.model.HumiIn;
import com.weather.domain.model.HumiInExample;
import com.weather.domain.model.HumiOut;
import com.weather.domain.model.HumiOutExample;
import com.weather.infra.persistence.sql.mapper.HumiInMapper;
import com.weather.infra.persistence.sql.mapper.HumiOutMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class HumiOutService {
    @Resource
    private HumiOutMapper humiOutMapper;

    public int addRecord(HumiOut humiOut) {
        return this.humiOutMapper.insert(humiOut);
    }

    public int dropRecord(Integer id){
        return this.humiOutMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(HumiOut humiOut){ return this.humiOutMapper.updateByPrimaryKeySelective(humiOut);}

    public HumiOut findRecordById(Integer id){
        return this.humiOutMapper.selectByPrimaryKey(id);
    }

    public HumiOut findRecordAuto(){
        return this.humiOutMapper.selectForHumidityOutdoor();
    }

    public List<HumiOut> findRecordSelective(HumiOutExample humiOutExample, RowBounds rowBounds){
        return this.humiOutMapper.selectByExampleWithRowbounds(humiOutExample,rowBounds);
    }
}
