package com.xkylin.userprovider02.dao;

import com.xkylin.userprovider02.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
