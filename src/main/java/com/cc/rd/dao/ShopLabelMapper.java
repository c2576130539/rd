package com.cc.rd.dao;

import com.cc.rd.entity.ShopLabel;
import com.cc.rd.entity.ShopLabelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopLabelMapper {
    long countByExample(ShopLabelExample example);

    int deleteByExample(ShopLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopLabel record);

    int insertSelective(ShopLabel record);

    List<ShopLabel> selectByExample(ShopLabelExample example);

    ShopLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopLabel record, @Param("example") ShopLabelExample example);

    int updateByExample(@Param("record") ShopLabel record, @Param("example") ShopLabelExample example);

    int updateByPrimaryKeySelective(ShopLabel record);

    int updateByPrimaryKey(ShopLabel record);
}