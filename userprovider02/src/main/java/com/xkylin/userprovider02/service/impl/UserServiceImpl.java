package com.xkylin.userprovider02.service.impl;

import com.xkylin.userprovider02.service.UserService;
import com.xkylin.userprovider02.bean.User;
import com.xkylin.userprovider02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        userDao.saveAndFlush(user);

    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
