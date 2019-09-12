package com.xkylin.userweb03.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xkylin.userweb03.bean.User;
import com.xkylin.userweb03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //远程服务调用客户端
    @Autowired
    RestTemplate restTemplate;

    //开启Ribbon后，RestTemplate直接使用服务名就可以发起调用
    String url="http://USERPROVIDER";

    @Override
    @HystrixCommand(fallbackMethod="getUserMapFallbackMethod")
    public Map getUserMap() {
        long beginTime = System.currentTimeMillis();
        Map map = restTemplate.getForObject(url+"/user/getall", Map.class);
        long endTime=System.currentTimeMillis();
        System.out.println("程序执行时间:"+(endTime-beginTime));
        return map;
    }

    /**
     * 获取全部用户数据，发生熔断后调用方法
     * @return
     */
    public Map<String, Object> getUserMapFallbackMethod() {
        Map map = new HashMap();
        map.put("list", new ArrayList<>());
        map.put("ProviderVersion", "获取远程调用失败");
        return map;
    }

    @Override
    public void createUser(User user) {

        restTemplate.postForObject(url+"/user/save", user,String.class);

    }

    @Override
    public User getUser(Long id) {

        return restTemplate.getForObject(url+"/user/get/"+id, User.class);
    }

    @Override
    public void updateUser(Long id, User user) {
        restTemplate.put(url+"/user/update/"+id, user);

    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(url+"/user/delete/"+id);
    }
}
