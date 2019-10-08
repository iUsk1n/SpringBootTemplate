package com.market.sapphires.sbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.sapphires.sbt.entity.LoginUserGroup;

@Repository
public interface LoginUserGroupDao extends JpaRepository<LoginUserGroup, Integer> {

}
