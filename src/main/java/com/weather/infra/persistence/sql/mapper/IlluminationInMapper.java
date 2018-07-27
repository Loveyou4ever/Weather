package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.IlluminationIn;
import com.weather.domain.model.IlluminationInExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface IlluminationInMapper {
    int countByExample(IlluminationInExample example);

    int deleteByExample(IlluminationInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IlluminationIn record);

    int insertSelective(IlluminationIn record);

    List<IlluminationIn> selectByExampleWithRowbounds(IlluminationInExample example, RowBounds rowBounds);

    List<IlluminationIn> selectByExample(IlluminationInExample example);

    IlluminationIn selectByPrimaryKey(Integer id);

    IlluminationIn selectForIlluminationIndoor();

    int updateByExampleSelective(@Param("record") IlluminationIn record, @Param("example") IlluminationInExample example);

    int updateByExample(@Param("record") IlluminationIn record, @Param("example") IlluminationInExample example);

    int updateByPrimaryKeySelective(IlluminationIn record);

    int updateByPrimaryKey(IlluminationIn record);
}