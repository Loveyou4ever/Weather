package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.IlluminationOut;
import com.weather.domain.model.IlluminationOutExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface IlluminationOutMapper {
    int countByExample(IlluminationOutExample example);

    int deleteByExample(IlluminationOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IlluminationOut record);

    int insertSelective(IlluminationOut record);

    List<IlluminationOut> selectByExampleWithRowbounds(IlluminationOutExample example, RowBounds rowBounds);

    List<IlluminationOut> selectByExample(IlluminationOutExample example);

    IlluminationOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IlluminationOut record, @Param("example") IlluminationOutExample example);

    int updateByExample(@Param("record") IlluminationOut record, @Param("example") IlluminationOutExample example);

    int updateByPrimaryKeySelective(IlluminationOut record);

    int updateByPrimaryKey(IlluminationOut record);

    IlluminationOut selectForIlluminationOutdoor();
}