package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.HumiOut;
import com.weather.domain.model.HumiOutExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface HumiOutMapper {
    int countByExample(HumiOutExample example);

    int deleteByExample(HumiOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HumiOut record);

    int insertSelective(HumiOut record);

    List<HumiOut> selectByExampleWithRowbounds(HumiOutExample example, RowBounds rowBounds);

    List<HumiOut> selectByExample(HumiOutExample example);

    HumiOut selectByPrimaryKey(Integer id);

    HumiOut selectForHumidityOutdoor();

    int updateByExampleSelective(@Param("record") HumiOut record, @Param("example") HumiOutExample example);

    int updateByExample(@Param("record") HumiOut record, @Param("example") HumiOutExample example);

    int updateByPrimaryKeySelective(HumiOut record);

    int updateByPrimaryKey(HumiOut record);
}