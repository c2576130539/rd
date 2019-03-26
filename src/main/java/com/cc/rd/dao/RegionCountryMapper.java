package com.cc.rd.dao;

import com.cc.rd.entity.RegionCountry;
import com.cc.rd.entity.RegionCountryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionCountryMapper {
    long countByExample(RegionCountryExample example);

    int deleteByExample(RegionCountryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionCountry record);

    int insertSelective(RegionCountry record);

    List<RegionCountry> selectByExample(RegionCountryExample example);

    RegionCountry selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionCountry record, @Param("example") RegionCountryExample example);

    int updateByExample(@Param("record") RegionCountry record, @Param("example") RegionCountryExample example);

    int updateByPrimaryKeySelective(RegionCountry record);

    int updateByPrimaryKey(RegionCountry record);
}