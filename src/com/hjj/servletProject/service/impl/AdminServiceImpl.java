package com.hjj.servletProject.service.impl;

import com.hjj.servletProject.dao.IAdminDao;
import com.hjj.servletProject.dao.impl.IAdminDaoImpl;
import com.hjj.servletProject.entity.Admin;
import com.hjj.servletProject.service.AdminService;
import com.hjj.servletProject.utils.DbUtils;

import java.util.List;

/**
 * @author Layton
 * @version 1.0
 * @date 2020/11/21 0:28
 */
public class AdminServiceImpl implements AdminService {

    //dao层的接口对象
    private IAdminDao adminDao = new IAdminDaoImpl();

    @Override
    public Admin Login(String username, String password) {
        Admin result = null;
        try {
            //开始事务
            DbUtils.begin();
            Admin admin = adminDao.select(username);
            if (admin != null) {
                //用户存在，接下来验证密码
                if (admin.getPassword().equals(password)) {
                    //查询到的对象密码和传过来的密码相等
                    result = admin;
                }
            }
            //提交事务
            DbUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常则回滚
            DbUtils.rollback();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> admins = null;
        try {
            DbUtils.begin();
            admins = adminDao.selectAll();
            DbUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DbUtils.rollback();
        }
        return admins;
    }
}