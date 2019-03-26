package com.cc.rd.dao;

import com.cc.rd.entity.RegionArea;
import com.cc.rd.entity.RegionAreaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionAreaMapper {
    long countByExample(RegionAreaExample example);

    int deleteByExample(RegionAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionArea record);

    int insertSelective(RegionArea record);

    List<RegionArea> selectByExample(RegionAreaExample example);

    RegionArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionArea record, @Param("example") RegionAreaExample example);

    int updateByExample(@Param("record") RegionArea record, @Param("example") RegionAreaExample example);

    int updateByPrimaryKeySelective(RegionArea record);

    int updateByPrimaryKey(RegionArea record);
}