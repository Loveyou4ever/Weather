package com.weather.infra.persistence.sql.mapper;

import com.weather.domain.model.WindDirection;
import com.weather.domain.model.WindDirectionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface WindDirectionMapper {
    int countByExample(WindDirectionExample example);

    int deleteByExample(WindDirectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WindDirection record);

    int insertSelective(WindDirection record);

    List<WindDirection> selectByExampleWithRowbounds(WindDirectionExample example, RowBounds rowBounds);

    List<WindDirection> selectByExample(WindDirectionExample example);

    WindDirection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WindDirection record, @Param("example") WindDirectionExample example);

    int updateByExample(@Param("record") WindDirection record, @Param("example") WindDirectionExample example);

    int updateByPrimaryKeySelective(WindDirection record);

    int updateByPrimaryKey(WindDirection record);

    WindDirection selectForWindDirection();
}