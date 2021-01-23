package com.hjj.servletProject.dao.impl;


import com.hjj.servletProject.dao.IManagerDao;
import com.hjj.servletProject.entity.Manager;
import com.hjj.servletProject.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author Layton
 * @version 1.0
 * @date 2021/1/23 16:53
 */
public class IManagerDaoImpl implements IManagerDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Manager select(String username) {
        try {
            Manager manager = queryRunner.query(
                    DbUtils.getConnection(),
                    "select * from manager where username=?",
                    new BeanHandler<Manager>(Manager.class),
                    username);
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
