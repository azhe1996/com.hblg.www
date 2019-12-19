package com.hblg.dao.impl;

import com.hblg.bean.User;
import com.hblg.dao.UserDao;

import java.util.List;

public abstract class AbstractUserDao implements UserDao {
    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public User findByName(String userName) {
        return null;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
