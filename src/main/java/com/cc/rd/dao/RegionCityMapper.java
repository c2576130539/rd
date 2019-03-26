package com.cc.rd.dao;

import com.cc.rd.entity.RegionCity;
import com.cc.rd.entity.RegionCityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionCityMapper {
    long countByExample(RegionCityExample example);

    int deleteByExample(RegionCityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionCity record);

    int insertSelective(RegionCity record);

    List<RegionCity> selectByExample(RegionCityExample example);

    RegionCity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionCity record, @Param("example") RegionCityExample example);

    int updateByExample(@Param("record") RegionCity record, @Param("example") RegionCityExample example);

    int updateByPrimaryKeySelective(RegionCity record);

    int updateByPrimaryKey(RegionCity record);
}