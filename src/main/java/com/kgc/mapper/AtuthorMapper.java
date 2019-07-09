package com.kgc.mapper;

import com.kgc.entity.Atuthor;
import com.kgc.entity.AtuthorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AtuthorMapper {
    int countByExample(AtuthorExample example);

    int deleteByExample(AtuthorExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Atuthor record);

    int insertSelective(Atuthor record);

    List<Atuthor> selectByExample(AtuthorExample example);

    Atuthor selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Atuthor record, @Param("example") AtuthorExample example);

    int updateByExample(@Param("record") Atuthor record, @Param("example") AtuthorExample example);

    int updateByPrimaryKeySelective(Atuthor record);

    int updateByPrimaryKey(Atuthor record);
}