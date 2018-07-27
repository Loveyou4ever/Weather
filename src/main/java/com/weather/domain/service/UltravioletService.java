package com.weather.domain.service;

import com.weather.domain.model.Ultraviolet;
import com.weather.domain.model.UltravioletExample;
import com.weather.infra.persistence.sql.mapper.UltravioletMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class UltravioletService {
    @Resource
    private UltravioletMapper ultravioletMapper;

    public int addRecord(Ultraviolet ultraviolet) {
        return this.ultravioletMapper.insert(ultraviolet);
    }

    public int dropRecord(Integer id){
        return this.ultravioletMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(Ultraviolet ultraviolet){ return this.ultravioletMapper.updateByPrimaryKeySelective(ultraviolet);}

    public Ultraviolet findRecordById(Integer id){
        return this.ultravioletMapper.selectByPrimaryKey(id);
    }

    public Ultraviolet findRecordAuto(){
        return this.ultravioletMapper.selectForUltraviolet();
    }

    public List<Ultraviolet> findRecordSelective(UltravioletExample ultravioletExample, RowBounds rowBounds){
        return this.ultravioletMapper.selectByExampleWithRowbounds(ultravioletExample,rowBounds);
    }
}
