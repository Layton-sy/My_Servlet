package com.hjj.servletProject.dao;

import com.hjj.servletProject.entity.Admin;

import java.util.List;

public interface IAdminDao {
    //插入
    public int insert(Admin admin);
    //删除
    int delete(String username);
    //更新
    int update(Admin admin);
    //查询一个
    Admin select(String username);
    //查询所有
    List<Admin> selectAll();
}