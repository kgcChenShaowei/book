package com.kgc.mapper;

import com.kgc.entity.Name;
import com.kgc.entity.NameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NameMapper {
    int countByExample(NameExample example);

    int deleteByExample(NameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Name record);

    int insertSelective(Name record);

    List<Name> selectByExample(NameExample example);

    Name selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Name record, @Param("example") NameExample example);

    int updateByExample(@Param("record") Name record, @Param("example") NameExample example);

    int updateByPrimaryKeySelective(Name record);

    int updateByPrimaryKey(Name record);
}