package com.weather.domain.service;

import com.weather.domain.model.IlluminationIn;
import com.weather.domain.model.IlluminationInExample;
import com.weather.infra.persistence.sql.mapper.IlluminationInMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class IlluminationInService {
    @Resource
    private IlluminationInMapper illuminationInMapper;

    public int addRecord(IlluminationIn illuminationIn) {
        return this.illuminationInMapper.insert(illuminationIn);
    }

    public int dropRecord(Integer id){
        return this.illuminationInMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(IlluminationIn illuminationIn){ return this.illuminationInMapper.updateByPrimaryKeySelective(illuminationIn);}

    public IlluminationIn findRecordById(Integer id){
        return this.illuminationInMapper.selectByPrimaryKey(id);
    }

    public IlluminationIn findRecordAuto(){
        return this.illuminationInMapper.selectForIlluminationIndoor();
    }

    public List<IlluminationIn> findRecordSelective(IlluminationInExample illuminationInExample, RowBounds rowBounds){
        return this.illuminationInMapper.selectByExampleWithRowbounds(illuminationInExample,rowBounds);
    }
}
