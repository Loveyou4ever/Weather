package com.weather.domain.service;

import com.weather.domain.model.AtmoPre;
import com.weather.domain.model.AtmoPreExample;
import com.weather.infra.persistence.sql.mapper.AtmoPreMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class AtmoPreService {
    @Resource
    private AtmoPreMapper atmoPreMapper;

    public int addRecord(AtmoPre atmoPre) {
        return this.atmoPreMapper.insert(atmoPre);
    }

    public int dropRecord(Integer id){
        return this.atmoPreMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(AtmoPre atmoPre){ return this.atmoPreMapper.updateByPrimaryKeySelective(atmoPre);}

    public AtmoPre findRecordById(Integer id){
        return this.atmoPreMapper.selectByPrimaryKey(id);
    }

    public AtmoPre findRecordAuto(){
        return this.atmoPreMapper.selectForAtmoPre();
    }

    public List<AtmoPre> findRecordSelective(AtmoPreExample atmoPreExample, RowBounds rowBounds){
        return this.atmoPreMapper.selectByExampleWithRowbounds(atmoPreExample,rowBounds);
    }
}
