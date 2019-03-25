package com.cloud.springboot.dao;

import com.cloud.springboot.entity.TSysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TSysMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_menu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_menu
     *
     * @mbg.generated
     */
    int insert(TSysMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_menu
     *
     * @mbg.generated
     */
    TSysMenu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_menu
     *
     * @mbg.generated
     */
    List<TSysMenu> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TSysMenu record);

    List<TSysMenu> getMenusByUserId(String id);
}