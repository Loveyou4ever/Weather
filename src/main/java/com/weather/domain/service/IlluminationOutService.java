package com.weather.domain.service;

import com.weather.domain.model.IlluminationOut;
import com.weather.domain.model.IlluminationOutExample;
import com.weather.infra.persistence.sql.mapper.IlluminationOutMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class IlluminationOutService {
    @Resource
    private IlluminationOutMapper illuminationOutMapper;

    public int addRecord(IlluminationOut illuminationOut) {
        return this.illuminationOutMapper.insert(illuminationOut);
    }

    public int dropRecord(Integer id){
        return this.illuminationOutMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(IlluminationOut illuminationOut){ return this.illuminationOutMapper.updateByPrimaryKeySelective(illuminationOut);}

    public IlluminationOut findRecordById(Integer id){
        return this.illuminationOutMapper.selectByPrimaryKey(id);
    }

    public IlluminationOut findRecordAuto(){
        return this.illuminationOutMapper.selectForIlluminationOutdoor();
    }

    public List<IlluminationOut> findRecordSelective(IlluminationOutExample illuminationOutExample, RowBounds rowBounds){
        return this.illuminationOutMapper.selectByExampleWithRowbounds(illuminationOutExample,rowBounds);
    }
}
