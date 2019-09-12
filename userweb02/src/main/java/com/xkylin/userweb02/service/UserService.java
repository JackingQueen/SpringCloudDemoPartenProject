package com.xkylin.userweb02.service;

import com.xkylin.userweb02.bean.User;

import java.util.Map;

public interface UserService {
    public Map getUserMap();
    public void createUser(User user);
    public User getUser(Long id);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
}
