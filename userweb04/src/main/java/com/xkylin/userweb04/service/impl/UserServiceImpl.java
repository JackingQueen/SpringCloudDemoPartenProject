package com.xkylin.userweb04.service.impl;

import com.xkylin.userweb04.bean.User;
import com.xkylin.userweb04.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Map<String, Object> getUserMap() {
        Map map = new HashMap();
        map.put("list", new ArrayList<>());
        map.put("ProviderVersion", "获取远程调用失败");
        return map;
    }

    @Override
    public void createUser(User user) {
        System.out.println("创建用户失败:"+user);

    }

    @Override
    public User getUser(Long id) {
        System.out.println("获取id："+id+" 的用户失败");
        return null;
    }

    @Override
    public void updateUser(Long id, User user) {
        System.out.println("更新id:"+id+"的用户失败");

    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("删除id为:"+id+"的用户失败");

    }
}
