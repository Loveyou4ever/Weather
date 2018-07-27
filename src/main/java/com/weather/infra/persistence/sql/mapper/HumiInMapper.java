package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.HumiIn;
import com.weather.domain.model.HumiInExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface HumiInMapper {
    int countByExample(HumiInExample example);

    int deleteByExample(HumiInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HumiIn record);

    int insertSelective(HumiIn record);

    List<HumiIn> selectByExampleWithRowbounds(HumiInExample example, RowBounds rowBounds);

    List<HumiIn> selectByExample(HumiInExample example);

    HumiIn selectByPrimaryKey(Integer id);

    HumiIn selectForHumidityIndoor();

    int updateByExampleSelective(@Param("record") HumiIn record, @Param("example") HumiInExample example);

    int updateByExample(@Param("record") HumiIn record, @Param("example") HumiInExample example);

    int updateByPrimaryKeySelective(HumiIn record);

    int updateByPrimaryKey(HumiIn record);
}