package com.cc.rd.dao;

import com.cc.rd.entity.OrderInvitees;
import com.cc.rd.entity.OrderInviteesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderInviteesMapper {
    long countByExample(OrderInviteesExample example);

    int deleteByExample(OrderInviteesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInvitees record);

    int insertSelective(OrderInvitees record);

    List<OrderInvitees> selectByExample(OrderInviteesExample example);

    OrderInvitees selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderInvitees record, @Param("example") OrderInviteesExample example);

    int updateByExample(@Param("record") OrderInvitees record, @Param("example") OrderInviteesExample example);

    int updateByPrimaryKeySelective(OrderInvitees record);

    int updateByPrimaryKey(OrderInvitees record);
}