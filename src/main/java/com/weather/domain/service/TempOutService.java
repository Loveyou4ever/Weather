package com.weather.domain.service;

import com.weather.domain.model.TempOut;
import com.weather.domain.model.TempOutExample;
import com.weather.infra.persistence.sql.mapper.TempOutMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:13
 */

@Service
public class TempOutService {
    @Resource
    private TempOutMapper tempOutMapper;

    public int addRecord(TempOut tempOut) {
        return this.tempOutMapper.insert(tempOut);
    }

    public int dropRecord(Integer id){
        return this.tempOutMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(TempOut tempOut){ return this.tempOutMapper.updateByPrimaryKeySelective(tempOut);}

    public TempOut findRecordById(Integer id){
        return this.tempOutMapper.selectByPrimaryKey(id);
    }

    public TempOut findRecordAuto(){
        return this.tempOutMapper.selectForTemperatureOutdoor();
    }

    public List<TempOut> findRecordSelective(TempOutExample tempOutExample, RowBounds rowBounds){
        return this.tempOutMapper.selectByExampleWithRowbounds(tempOutExample,rowBounds);
    }
}
