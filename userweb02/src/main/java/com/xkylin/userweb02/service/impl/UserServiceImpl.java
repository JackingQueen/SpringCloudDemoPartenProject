package com.xkylin.userweb02.service.impl;

import com.xkylin.userweb02.bean.User;
import com.xkylin.userweb02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //远程服务调用客户端
    @Autowired
    RestTemplate restTemplate;
    //支持负载均衡的调用客户端
    @Autowired
    LoadBalancerClient loadBalancerClient;

    /***
     * 通过客户端负载均衡器获取生产者服务器基础地址
     * @return
     */
    public String getServerUrl() {
        //通过客户端调用器查找指定服务
        ServiceInstance inst  = loadBalancerClient.choose("USERPROVIDER");
        //获取服务提供者服务器ip、端口号
        String ip = inst.getHost();
        int port = inst.getPort();
        //拼接调用地址
        String url="http://"+ip+":"+port+"/user";
        return url;
    }

    @Override
    public Map getUserMap() {
        Map map = restTemplate.getForObject(getServerUrl()+"/getall", Map.class);
        return map;
    }

    @Override
    public void createUser(User user) {

        restTemplate.postForObject(getServerUrl()+"/save", user,String.class);

    }

    @Override
    public User getUser(Long id) {

        return restTemplate.getForObject(getServerUrl()+"/get/"+id, User.class);
    }

    @Override
    public void updateUser(Long id, User user) {
        restTemplate.put(getServerUrl()+"/update/"+id, user);

    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(getServerUrl()+"/delete/"+id);
    }
}
