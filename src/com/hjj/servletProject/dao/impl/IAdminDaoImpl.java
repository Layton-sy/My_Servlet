package com.hjj.servletProject.dao.impl;

import com.hjj.servletProject.dao.IAdminDao;
import com.hjj.servletProject.entity.Admin;
import com.hjj.servletProject.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Layton
 * @version 1.0
 * @date 2020/11/20 19:39
 */
public class IAdminDaoImpl implements IAdminDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(String username) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        try {
            Admin admin = queryRunner.query(DbUtils.getConnection(), "select * from admin where username = ?;", new BeanHandler<Admin>(Admin.class), username);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> admins = null;
        try {
            admins = queryRunner.query(DbUtils.getConnection(),"select * from admin",new BeanListHandler<Admin>(Admin.class));
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
