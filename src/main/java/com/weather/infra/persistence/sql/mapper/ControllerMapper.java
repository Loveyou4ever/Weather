package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.ControllerExample;
import com.weather.domain.model.Controller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface ControllerMapper {
    int countByExample(ControllerExample example);

    int deleteByExample(ControllerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Controller record);

    int insertSelective(Controller record);

    List<Controller> selectByExampleWithRowbounds(ControllerExample example, RowBounds rowBounds);

    List<Controller> selectByExample(ControllerExample example);

    Controller selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Controller record, @Param("example") ControllerExample example);

    int updateByExample(@Param("record") Controller record, @Param("example") ControllerExample example);

    int updateByPrimaryKeySelective(Controller record);

    int updateByPrimaryKey(Controller record);

    Controller selectForAutoFlag();
}