package com.cc.rd.dao;

import com.cc.rd.entity.FileData;
import com.cc.rd.entity.FileDataExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileDataMapper {
    long countByExample(FileDataExample example);

    int deleteByExample(FileDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileData record);

    int insertSelective(FileData record);

    List<FileData> selectByExampleWithBLOBs(FileDataExample example);

    List<FileData> selectByExample(FileDataExample example);

    FileData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileData record, @Param("example") FileDataExample example);

    int updateByExampleWithBLOBs(@Param("record") FileData record, @Param("example") FileDataExample example);

    int updateByExample(@Param("record") FileData record, @Param("example") FileDataExample example);

    int updateByPrimaryKeySelective(FileData record);

    int updateByPrimaryKeyWithBLOBs(FileData record);

    int updateByPrimaryKey(FileData record);
}