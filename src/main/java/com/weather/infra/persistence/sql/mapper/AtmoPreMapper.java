package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.AtmoPre;
import com.weather.domain.model.AtmoPreExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface AtmoPreMapper {
    int countByExample(AtmoPreExample example);

    int deleteByExample(AtmoPreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AtmoPre record);

    int insertSelective(AtmoPre record);

    List<AtmoPre> selectByExampleWithRowbounds(AtmoPreExample example, RowBounds rowBounds);

    List<AtmoPre> selectByExample(AtmoPreExample example);

    AtmoPre selectByPrimaryKey(Integer id);

    AtmoPre selectForAtmoPre();

    int updateByExampleSelective(@Param("record") AtmoPre record, @Param("example") AtmoPreExample example);

    int updateByExample(@Param("record") AtmoPre record, @Param("example") AtmoPreExample example);

    int updateByPrimaryKeySelective(AtmoPre record);

    int updateByPrimaryKey(AtmoPre record);
}