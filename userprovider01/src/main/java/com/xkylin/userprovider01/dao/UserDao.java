package com.xkylin.userprovider01.dao;

import com.xkylin.userprovider01.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
