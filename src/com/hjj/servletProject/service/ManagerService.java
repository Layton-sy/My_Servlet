package com.hjj.servletProject.service;

import com.hjj.servletProject.entity.Manager;

/**
 * @author Layton
 * @version 1.0
 * @date 2021/1/23 22:11
 */
public interface ManagerService {
    public Manager login(String username,String password);
}
