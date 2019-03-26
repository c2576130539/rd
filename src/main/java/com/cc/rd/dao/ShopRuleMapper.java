package com.cc.rd.dao;

import com.cc.rd.entity.ShopRule;
import com.cc.rd.entity.ShopRuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopRuleMapper {
    long countByExample(ShopRuleExample example);

    int deleteByExample(ShopRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopRule record);

    int insertSelective(ShopRule record);

    List<ShopRule> selectByExample(ShopRuleExample example);

    ShopRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopRule record, @Param("example") ShopRuleExample example);

    int updateByExample(@Param("record") ShopRule record, @Param("example") ShopRuleExample example);

    int updateByPrimaryKeySelective(ShopRule record);

    int updateByPrimaryKey(ShopRule record);
}