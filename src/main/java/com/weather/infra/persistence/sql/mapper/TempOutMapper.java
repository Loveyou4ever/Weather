package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.TempOut;
import com.weather.domain.model.TempOutExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface TempOutMapper {
    int countByExample(TempOutExample example);

    int deleteByExample(TempOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TempOut record);

    int insertSelective(TempOut record);

    List<TempOut> selectByExampleWithRowbounds(TempOutExample example, RowBounds rowBounds);

    List<TempOut> selectByExample(TempOutExample example);

    TempOut selectByPrimaryKey(Integer id);

    TempOut selectForTemperatureOutdoor();

    int updateByExampleSelective(@Param("record") TempOut record, @Param("example") TempOutExample example);

    int updateByExample(@Param("record") TempOut record, @Param("example") TempOutExample example);

    int updateByPrimaryKeySelective(TempOut record);

    int updateByPrimaryKey(TempOut record);
}