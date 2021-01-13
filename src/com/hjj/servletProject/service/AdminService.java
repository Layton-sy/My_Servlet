package com.hjj.servletProject.service;


import com.hjj.servletProject.entity.Admin;

import java.util.List;

/**
 * @author Layton
 * @version 1.0
 * @date 2020/11/21 0:22
 */
public interface AdminService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public Admin Login(String username, String password);

    /**
     * 展示所有用户
     * @return
     */
    public List<Admin> showAllAdmin();
}