package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.TempIn;
import com.weather.domain.model.TempInExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import java.util.List;
@Mapper
public interface TempInMapper {
    int countByExample(TempInExample example);

    int deleteByExample(TempInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TempIn record);

    int insertSelective(TempIn record);

    List<TempIn> selectByExampleWithRowbounds(TempInExample example, RowBounds rowBounds);

    List<TempIn> selectByExample(TempInExample example);

    TempIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TempIn record, @Param("example") TempInExample example);

    int updateByExample(@Param("record") TempIn record, @Param("example") TempInExample example);

    int updateByPrimaryKeySelective(TempIn record);

    int updateByPrimaryKey(TempIn record);

    TempIn selectForTemperatureIndoor();
}