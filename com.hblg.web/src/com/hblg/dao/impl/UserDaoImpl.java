package com.hblg.dao.impl;

import com.hblg.bean.User;
import com.hblg.dao.UserDao;

public class UserDaoImpl extends AbstractUserDao {
    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public User findByName(String userName) {
        return null;
    }
}
