package com.weather.domain.service;

import com.weather.domain.model.TempIn;
import com.weather.domain.model.TempInExample;
import com.weather.infra.persistence.sql.mapper.TempInMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  16:51
 */
@Service
public class TempInService {
    @Resource
    private TempInMapper tempInMapper;

    public int addRecord(TempIn tempIn) {
        return this.tempInMapper.insert(tempIn);
    }

    public int dropRecord(Integer id){
        return this.tempInMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(TempIn tempIn){ return this.tempInMapper.updateByPrimaryKeySelective(tempIn);}

    public TempIn findRecordById(Integer id){
        return this.tempInMapper.selectByPrimaryKey(id);
    }

    public TempIn findRecordAuto(){
        return this.tempInMapper.selectForTemperatureIndoor();
    }

    public List<TempIn> findRecordSelective(TempInExample tempInExample, RowBounds rowBounds){
        return this.tempInMapper.selectByExampleWithRowbounds(tempInExample,rowBounds);
    }
}
