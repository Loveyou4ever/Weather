package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.AirSpeed;
import com.weather.domain.model.AirSpeedExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface AirSpeedMapper {
    int countByExample(AirSpeedExample example);

    int deleteByExample(AirSpeedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AirSpeed record);

    int insertSelective(AirSpeed record);

    List<AirSpeed> selectByExampleWithRowbounds(AirSpeedExample example, RowBounds rowBounds);

    List<AirSpeed> selectByExample(AirSpeedExample example);

    AirSpeed selectByPrimaryKey(Integer id);

    AirSpeed selectForAirSpeed();

    int updateByExampleSelective(@Param("record") AirSpeed record, @Param("example") AirSpeedExample example);

    int updateByExample(@Param("record") AirSpeed record, @Param("example") AirSpeedExample example);

    int updateByPrimaryKeySelective(AirSpeed record);

    int updateByPrimaryKey(AirSpeed record);
}