package com.weather.domain.service;

import com.weather.domain.model.WindDirection;
import com.weather.domain.model.WindDirectionExample;
import com.weather.infra.persistence.sql.mapper.WindDirectionMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/7/26  17:30
 */
@Service
public class WindDirectionService {
    @Resource
    private WindDirectionMapper windDirectionMapper;

    public int addRecord(WindDirection windDirection) {
        return this.windDirectionMapper.insert(windDirection);
    }

    public int dropRecord(Integer id){
        return this.windDirectionMapper.deleteByPrimaryKey(id);
    }

    public int changeRecord(WindDirection windDirection){ return this.windDirectionMapper.updateByPrimaryKeySelective(windDirection);}

    public WindDirection findRecordById(Integer id){
        return this.windDirectionMapper.selectByPrimaryKey(id);
    }

    public WindDirection findRecordAuto(){
        return this.windDirectionMapper.selectForWindDirection();
    }

    public List<WindDirection> findRecordSelective(WindDirectionExample windDirectionExample, RowBounds rowBounds){
        return this.windDirectionMapper.selectByExampleWithRowbounds(windDirectionExample,rowBounds);
    }
}
