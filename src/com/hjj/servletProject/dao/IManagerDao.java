package com.hjj.servletProject.dao;

import com.hjj.servletProject.entity.Manager;

public interface IManagerDao {
    /**
     * 根据用户名返回对象
     * @param username
     * @return
     */
    public Manager select(String username);
}
