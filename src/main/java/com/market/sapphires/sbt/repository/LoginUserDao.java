package com.market.sapphires.sbt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.sapphires.sbt.entity.LoginUser;

@Repository
public interface LoginUserDao extends JpaRepository<LoginUser, Integer>, LoginUserDaoCustom {

    Optional<LoginUser> findById(long id);

    List<LoginUser> findByUsername(String username);

}
