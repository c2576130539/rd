package com.cc.rd.dao;

import com.cc.rd.entity.RegionProvince;
import com.cc.rd.entity.RegionProvinceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionProvinceMapper {
    long countByExample(RegionProvinceExample example);

    int deleteByExample(RegionProvinceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionProvince record);

    int insertSelective(RegionProvince record);

    List<RegionProvince> selectByExample(RegionProvinceExample example);

    RegionProvince selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionProvince record, @Param("example") RegionProvinceExample example);

    int updateByExample(@Param("record") RegionProvince record, @Param("example") RegionProvinceExample example);

    int updateByPrimaryKeySelective(RegionProvince record);

    int updateByPrimaryKey(RegionProvince record);
}