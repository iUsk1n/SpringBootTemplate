package com.market.sapphires.sbt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.sapphires.sbt.entity.LoginUser;

@Repository
public interface LoginUserDao extends JpaRepository<LoginUser, Integer> {

    List<LoginUser> findByUsername(String username);

}
