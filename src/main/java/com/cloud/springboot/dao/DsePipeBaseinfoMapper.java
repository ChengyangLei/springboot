package com.cloud.springboot.dao;

import com.cloud.springboot.entity.DsePipeBaseinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DsePipeBaseinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSE_PIPE_BASEINFO
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSE_PIPE_BASEINFO
     *
     * @mbg.generated
     */
    int insert(DsePipeBaseinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSE_PIPE_BASEINFO
     *
     * @mbg.generated
     */
    DsePipeBaseinfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSE_PIPE_BASEINFO
     *
     * @mbg.generated
     */
    List<DsePipeBaseinfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSE_PIPE_BASEINFO
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DsePipeBaseinfo record);
}