package com.hjj.servletProject.service.impl;

import com.hjj.servletProject.dao.IManagerDao;
import com.hjj.servletProject.dao.impl.IManagerDaoImpl;
import com.hjj.servletProject.entity.Manager;
import com.hjj.servletProject.service.ManagerService;
import com.hjj.servletProject.utils.DbUtils;

/**
 * @author Layton
 * @version 1.0
 * @date 2021/1/23 22:12
 */
public class ManagerServiceImpl implements ManagerService {
    IManagerDao managerDao = new IManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        Manager manager = null;
        try {
            DbUtils.begin();
            Manager tmp = managerDao.select(username);
            if(tmp != null){
                if(tmp.getPassword().equals(password)){
                    manager = tmp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}
