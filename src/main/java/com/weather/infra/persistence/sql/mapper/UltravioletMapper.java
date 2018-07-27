package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.Ultraviolet;
import com.weather.domain.model.UltravioletExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface UltravioletMapper {
    int countByExample(UltravioletExample example);

    int deleteByExample(UltravioletExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ultraviolet record);

    int insertSelective(Ultraviolet record);

    List<Ultraviolet> selectByExampleWithRowbounds(UltravioletExample example, RowBounds rowBounds);

    List<Ultraviolet> selectByExample(UltravioletExample example);

    Ultraviolet selectByPrimaryKey(Integer id);

    Ultraviolet selectForUltraviolet();

    int updateByExampleSelective(@Param("record") Ultraviolet record, @Param("example") UltravioletExample example);

    int updateByExample(@Param("record") Ultraviolet record, @Param("example") UltravioletExample example);

    int updateByPrimaryKeySelective(Ultraviolet record);

    int updateByPrimaryKey(Ultraviolet record);
}